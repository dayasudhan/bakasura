package com.naktec.bakasura.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.naktec.bakasura.R;
import com.naktec.bakasura.adapter.ProductAdapter;

public class CartActivity extends AppCompatActivity {
    String[] hotel={"Dosa","Idli"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ProductAdapter dataAdapter = new ProductAdapter(CartActivity.this,
                R.layout.product_detail_list_layout,hotel,null);
        ListView listView = (ListView) findViewById(R.id.listView_cart);
        listView.setAdapter(dataAdapter);
        Button btn= (Button) findViewById(R.id.orderDetailButton_next);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this, CutomerEnterDetailsActivity.class);

                startActivity(i);
            }
        });
    }
}
