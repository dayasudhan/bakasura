package com.naktec.bakasura.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.naktec.bakasura.R;
import com.naktec.bakasura.model.Order;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

public class CutomerEnterDetailsActivity extends AppCompatActivity {

    Order order;
    String responseOrder;
    EditText editName,editPhone,editEmail,editHouseNo,editAreaName,editLandmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomer_enter_details);
        Intent intent = getIntent();
        Gson gson = new Gson();
        order = gson.fromJson(intent.getStringExtra("order"), Order.class);
        responseOrder = new String();
        Button btn= (Button) findViewById(R.id.placeOrderButton);
        editName=(EditText)findViewById(R.id.orderDetailName);
        editPhone=(EditText)findViewById(R.id.orderDetailPhone);
        editEmail=(EditText)findViewById(R.id.orderDetailEmail);
        editHouseNo=(EditText)findViewById(R.id.orderDetailAddress_house_no);
        editAreaName=(EditText)findViewById(R.id.orderDetailAddress_areaname);
        editLandmark=(EditText)findViewById(R.id.orderDetailAddress_landmark);
        TextView orderTotalCharge = (TextView) findViewById(R.id.textView);
        orderTotalCharge.setText(String.valueOf(order.getBill_value()));
        if(true) {
            editName.setText("name");
            editPhone.setText("9566229075");
            editEmail.setText("hjgjhgj");
            editAreaName.setText("areaname");
            editLandmark.setText("landmark");
            editHouseNo.setText("houseno");
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                order.getCustomer().setName(editName.getText().toString());

                order.getCustomer().setEmail(editEmail.getText().toString());
                order.getCustomer().getAddress().setAreaName(editAreaName.getText().toString());
                order.getCustomer().getAddress().setLandMark(editLandmark.getText().toString());
                order.getCustomer().getAddress().setAddressLine1(editHouseNo.getText().toString());
                if (validatePhoneNumber(editPhone.getText().toString())) {
                    order.getCustomer().setPhone(editPhone.getText().toString());
                    Gson gson = new Gson();
                    String strOrder = gson.toJson(order);
                    postOrder(strOrder);
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Phone Number ", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private static boolean validatePhoneNumber(String phoneNo)
    {
        if (phoneNo.matches("\\d{10}"))
            return true;
        else if(phoneNo.matches("\\+\\d{12}")) return true;
        else return false;
    }
    public void postOrder(String order)
    {
     //   String order_url = "http://10.239.54.58:3000/v1/mobile/vendor/order";
       String order_url = "http://oota.herokuapp.com/v1/mobile/vendor/order";

        new PostJSONAsyncTask().execute(order_url,order);
    }
    public  class PostJSONAsyncTask extends AsyncTask<String, Void, Boolean> {
        ProgressDialog dialog;
        public  PostJSONAsyncTask()
        {
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(CutomerEnterDetailsActivity.this);
            dialog.setMessage("Posting Order, please wait");
            dialog.setTitle("Connecting....");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {
                ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
                HttpPost request = new HttpPost(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters);
                StringEntity se = new StringEntity(urls[1]);
                request.setEntity(se);
                request.setHeader("Accept", "application/json");
                request.setHeader("Content-type", "application/json");
                HttpResponse response = httpclient.execute(request);

                int status = response.getStatusLine().getStatusCode();
                if (status == 200) {
                    HttpEntity entity = response.getEntity();

                    responseOrder = EntityUtils.toString(entity);
                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();
            // adapter.notifyDataSetChanged();
            // bindView();
            if (result == true){
                Intent i = new Intent(CutomerEnterDetailsActivity.this, FinishActivity.class);
                i.putExtra("order", responseOrder);
                startActivity(i);
                finish();
        }
            else if (result == false)
                Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();

        }
    }
}
