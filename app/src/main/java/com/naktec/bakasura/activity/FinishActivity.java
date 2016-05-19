package com.naktec.bakasura.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.naktec.bakasura.R;
import com.naktec.bakasura.model.Order;

public class FinishActivity extends AppCompatActivity {

    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Intent intent = getIntent();
        Gson gson = new Gson();
        order = gson.fromJson(intent.getStringExtra("order"), Order.class);

        TextView txtViewName = (TextView) findViewById(R.id.vendor_name_value);
        TextView txtViewPhone = (TextView) findViewById(R.id.vendor_contact_value);
        TextView txtViewAddress = (TextView) findViewById(R.id.address_value);
        TextView txtViewMenu = (TextView) findViewById(R.id.items_value);

        txtViewName.setText(order.getCustomer().getName());
        txtViewPhone.setText(order.getCustomer().getPhone());


    }
    public void onBackPressed() {

        Intent start = new Intent(FinishActivity.this,LocationActivity.class);
        start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(start);
        finish();
    }
}
