package com.naktec.bakasura.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.naktec.bakasura.R;
import com.naktec.bakasura.adapter.LocationAdapter;

public class CategoriesActivity extends AppCompatActivity {
    String[] area={"South Indian","North Indian","Punjabi","Chinees"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        LocationAdapter dataAdapter = new LocationAdapter(CategoriesActivity.this,
                R.layout.area_list,area);
        ListView listView = (ListView) findViewById(R.id.sub_product_listView);
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CategoriesActivity.this, ProductDetailViewActivity.class);

                startActivity(i);
            }
        });
    }
}
