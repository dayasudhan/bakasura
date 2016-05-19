package com.naktec.bakasura.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.naktec.bakasura.R;
import com.naktec.bakasura.model.Order;

public class CutomerEnterDetailsActivity extends AppCompatActivity {

    Order order;
    EditText editName,editPhone,editEmail,editHouseNo,editAreaName,editLandmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomer_enter_details);
        Intent intent = getIntent();
        Gson gson = new Gson();
        order = gson.fromJson(intent.getStringExtra("order"), Order.class);

        Button btn= (Button) findViewById(R.id.orderDetailButton);
        editName=(EditText)findViewById(R.id.orderDetailName);
        editPhone=(EditText)findViewById(R.id.orderDetailPhone);
        editEmail=(EditText)findViewById(R.id.orderDetailEmail);
        editHouseNo=(EditText)findViewById(R.id.orderDetailAddress_house_no);
        editAreaName=(EditText)findViewById(R.id.orderDetailAddress_areaname);
        editLandmark=(EditText)findViewById(R.id.orderDetailAddress_landmark);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CutomerEnterDetailsActivity.this, FinishActivity.class);
                order.getCustomer().setName(editName.getText().toString());
                order.getCustomer().setPhone(editPhone.getText().toString());
                order.getCustomer().setEmail(editEmail.getText().toString());
                order.getCustomer().getAddress().setAreaName(editAreaName.getText().toString());
                order.getCustomer().getAddress().setLandMark(editLandmark.getText().toString());
                order.getCustomer().getAddress().setAddressLine1(editHouseNo.getText().toString());
                Gson gson = new Gson();
                String strOrder = gson.toJson(order);
                i.putExtra("order", strOrder);
                startActivity(i);
                finish();
            }
        });
    }
}
