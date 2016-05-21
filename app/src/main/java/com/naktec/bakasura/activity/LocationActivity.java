package com.naktec.bakasura.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.naktec.bakasura.R;
import com.naktec.bakasura.adapter.LocationAdapter;

import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class LocationActivity extends AppCompatActivity {

    private static final String TAG_SUBAREAS = "subAreas";
    String[] areaCoverage={"kormangla","Vijaynagar","Hsr Layout","Btm Layout"};
    private ArrayList<String> mCityCoverage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_location_search);
        mCityCoverage =  new ArrayList<String>();
        getCityCoverage();
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        LocationAdapter dataAdapter = new LocationAdapter(LocationActivity.this,
                R.layout.area_list,areaCoverage,mCityCoverage);
        ListView   listView = (ListView) findViewById(R.id.area_listView);
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(LocationActivity.this,HotelActivity.class);
                i.putExtra("area", mCityCoverage.get(position));
                startActivity(i);
            }
        });

    }
    //http://oota.herokuapp.com/v1/admin/coverageArea
    public void getCityCoverage()
    {
        mCityCoverage.clear();
        String order_url = "http://oota.herokuapp.com/v1/admin/coverageArea";
        new JSONAsyncTask().execute(order_url);
    }
    public  class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;

        ListView mListView;
        Activity mContex;
        public  JSONAsyncTask()
        {

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(LocationActivity.this);
            dialog.setMessage("Loading, please wait");
            dialog.setTitle("Connecting server");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();

                    String data = EntityUtils.toString(entity);
                    JSONArray jarray = new JSONArray(data);

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        if(object.has(TAG_SUBAREAS)) {
                            JSONArray subAreasArray = object.getJSONArray(TAG_SUBAREAS);
                            for (int j = 0; j < subAreasArray.length(); j++) {
                                JSONObject city_object = subAreasArray.getJSONObject(j);
                                mCityCoverage.add(city_object.get("name").toString());
                            }
                        }
                    }
                    return true;
                }
            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();
            if (result == false)
                Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();

        }
    }

}
