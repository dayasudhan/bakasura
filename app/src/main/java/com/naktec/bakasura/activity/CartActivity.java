package com.naktec.bakasura.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.naktec.bakasura.R;
import com.naktec.bakasura.adapter.ProductAdapter;
import com.naktec.bakasura.model.HotelDetail;
import com.naktec.bakasura.model.MenuAdapter;
import com.naktec.bakasura.model.MenuOrder;
import com.naktec.bakasura.model.Order;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    String[] hotel={"Dosa","Idli"};
    Order order;
    ArrayList<MenuAdapter> mMenulist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        Gson gson = new Gson();
        order = gson.fromJson(intent.getStringExtra("order"), Order.class);

        mMenulist = new ArrayList<MenuAdapter>();
        for(int i = 0; i< order.getMenuItems().size();i++)
        {
            MenuAdapter menuAdapter = new MenuAdapter( order.getMenuItems().get(i));
            mMenulist.add(menuAdapter);
        }
        ProductAdapter dataAdapter = new ProductAdapter(CartActivity.this,
                R.layout.product_detail_list_layout,mMenulist);
        ListView listView = (ListView) findViewById(R.id.listView_cart);
        TextView vendor_name = (TextView) findViewById(R.id.vendor_add_cart_name);
        listView.setAdapter(dataAdapter);
        Button btn= (Button) findViewById(R.id.orderDetailButton_next);

        vendor_name.setText(order.getHotelItem().getName());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this, CutomerEnterDetailsActivity.class);
                Gson gson = new Gson();
                String strOrder = gson.toJson(order);
                i.putExtra("order", strOrder);
                startActivity(i);
            }
        });
    }
}
