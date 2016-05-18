package com.naktec.bakasura.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.naktec.bakasura.R;
import com.naktec.bakasura.adapter.ProductAdapter;
import com.naktec.bakasura.model.HotelDetail;

public class ProductDetailViewActivity extends AppCompatActivity {
    String[] hotel={"Dosa","Idli","Upma","Poori ","Prata","Vada","Goobi"};
    HotelDetail hotelDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_view);
        Intent i = getIntent();
        Gson gson = new Gson();
        hotelDetail = gson.fromJson(i.getStringExtra("hotel"), HotelDetail.class);

        ProductAdapter dataAdapter = new ProductAdapter(ProductDetailViewActivity.this,
                R.layout.product_detail_list_layout,hotel,hotelDetail);
        ListView listView = (ListView) findViewById(R.id.listView_product_detail);
        listView.setAdapter(dataAdapter);


        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ProductDetailViewActivity.this, CartActivity.class);

                startActivity(i);
            }
        });*/



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu_product_detail_list, menu);
        //  menu_hotlist = menu.findItem(R.id.menu_hotlist).getActionView();
        // counttxt= (TextView) menu_hotlist.findViewById(R.id.hotlist_hot);
        RelativeLayout badgeLayout = (RelativeLayout) menu.findItem(R.id.menu_hotlist).getActionView();
        TextView counttxt = (TextView) badgeLayout.findViewById(R.id.count_indicator);
       // counttxt.setVisibility(View.INVISIBLE);
        // updateHotCount(0);
        counttxt.setText("23");
        badgeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if (mpref.getMainOrder().isEmpty()) {
                    counttxt.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "There are no items in the cart", Toast.LENGTH_LONG).show();
                    dialog2 = ProgressDialog.show(ProductDetailListActivity.this,
                            "", "Loading..  Please wait", true);
                    reLoadProducts();
                } else {
                    if (!counttxt.getText().toString().isEmpty()) {
                        Integer noItems = new Integer(counttxt.getText().toString());

                        Intent gotoSetCart = new Intent(ProductDetailListActivity.this, CartDetailActivity.class);
                        startActivity(gotoSetCart);
                    }
                }*/
                Intent i = new Intent(ProductDetailViewActivity.this, CartActivity.class);

                startActivity(i);
            }
        });
        /*new MyMenuItemStuffListener(menu_hotlist, "Show hot message") {
            @Override
            public void onClick(View v) {

            }

            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                return false;
            }
        };*/
        return super.onCreateOptionsMenu(menu);
    }
}
