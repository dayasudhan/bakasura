package com.naktec.bakasura.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.naktec.bakasura.R;
import com.naktec.bakasura.adapter.HotelListAdapter;

public class HotelActivity extends AppCompatActivity {
    String[] hotel={"A2b","Empire","Hsr Club","Vidyarthi Bhavan ","Udupi Garden","Halli Mane","SLV Dose Camp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        HotelListAdapter dataAdapter = new HotelListAdapter(HotelActivity.this,
                R.layout.hotel_list_item,hotel);
        ListView listView = (ListView) findViewById(R.id.listView_vendor);
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(HotelActivity.this, CategoriesActivity.class);

                startActivity(i);
            }
        });
        ImageView filter= (ImageView) findViewById(R.id.filter_btn_vendor_list);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogForVendorFilter();
            }
        });
    }


    private void showAlertDialogForVendorFilter( ) {


        final Dialog detailDialog= new Dialog(HotelActivity.this);
        detailDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp = detailDialog.getWindow().getAttributes();
        wmlp.gravity = Gravity.TOP | Gravity.RIGHT;
        wmlp.x = 30;   //x position
        wmlp.y = 130;
        detailDialog.setContentView(R.layout.filter_hotel_dialog);

        TextView meal= (TextView)detailDialog.findViewById(R.id.checkbox_title_1);
       // meal.setTypeface(cr);

        TextView night= (TextView)detailDialog.findViewById(R.id.checkbox_title);
      //  night.setTypeface(cr);
        CheckBox check= (CheckBox) detailDialog.findViewById(R.id.checkBox_filter);
        CheckBox check1= (CheckBox) detailDialog.findViewById(R.id.checkBox_filter_1);
       /* if(mpref.getNightStore().equals("nighttrue")){
            check.setChecked(true);
            mNightStoreId=1;
        }else{
            check.setChecked(false);
            mNightStoreId=0;
        }
        if(mpref.getMealVoucher().equals("mealtrue")){
            check1.setChecked(true);
            mMealVoucher=2;
        }else{
            check1.setChecked(false);
            mMealVoucher=0;
        }*/
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckBox cb= (CheckBox)view;
                if(cb.isChecked()){
                    // Toast.makeText(getApplicationContext(), "Night Store",Toast.LENGTH_SHORT).show();
                   // mNightStoreId=1;
                   // mpref.setNightStore("nighttrue");
                }else{
                    // Toast.makeText(getApplicationContext(), "Night Store Deactivated",Toast.LENGTH_SHORT).show();
                  //  mNightStoreId=0;
                  //  mpref.setNightStore("nightfalse");
                }
            }
        });

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb1= (CheckBox)view;
                //   Toast.makeText(getApplicationContext(), "Accept Meal Voucaher",Toast.LENGTH_SHORT).show();
                if(cb1.isChecked()){
                    //      Toast.makeText(getApplicationContext(), "Accept Meal Voucaher",Toast.LENGTH_SHORT).show();
                  //  mMealVoucher=2;
                  //  mpref.setMealVoucher("mealtrue");
                }else{

                    //     Toast.makeText(getApplicationContext(), "Accept Meal Voucaher Deactivated",Toast.LENGTH_SHORT).show();
                  //  mMealVoucher=0;
                  //  mpref.setMealVoucher("mealfalse");
                }

            }
        });
        TextView update= (TextView) detailDialog.findViewById(R.id.update_filter);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailDialog.dismiss();
               // UpdateVendrorList();
            }
        });
        TextView reset= (TextView) detailDialog.findViewById(R.id.reset_filter);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailDialog.dismiss();
               // mpref.setMealVoucher("no");
               // mpref.setNightStore("noNight");
              //  mMealVoucher=0;
              //  mNightStoreId=0;
              //  UpdateVendrorList();
            }
        });
        detailDialog.show();


    }


}
