package com.naktec.bakasura.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.naktec.bakasura.R;
import com.naktec.bakasura.model.HotelDetail;

import java.util.ArrayList;


public class HotelListAdapter extends BaseAdapter{
    Activity con;
    Typeface cr;
    int layoutResID;
    private String[] city;
    private ArrayList<HotelDetail> mhotelList;
    int pos;
    // PreferenceManager mpref;

    public HotelListAdapter(Activity context, int layoutResourceID,
                            ArrayList<HotelDetail> hotelList) {

        con = context;
        mhotelList = hotelList;
        layoutResID = layoutResourceID;
        // this.cr=cr;

    }

    @Override
    public int getCount() {
        return mhotelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HotelItemHolder itemHolder;
        View view = convertView;
        //  mpref= PreferenceManager.instance(con);
        //  LocationListNameModel city = getItem(position);

        itemHolder = new HotelItemHolder();
        if(view==null){
            LayoutInflater inflater = ((Activity)con).getLayoutInflater();
            view = inflater.inflate(layoutResID, parent, false);


            itemHolder = new HotelItemHolder();
            itemHolder.hotelName= (TextView) view.findViewById(R.id.vendor_name);

            view.setTag(itemHolder);
        }else{
            itemHolder = (HotelItemHolder) view.getTag();
        }

        //   itemHolder.city.setTypeface(cr);
        itemHolder.hotelName.setText(mhotelList.get(position).getHotelItem().getName());
        return view;

    }
    /*public void update(List<LocationListNameModel> rowItems) {
        city=rowItems;
    }*/
    private static class HotelItemHolder {
        TextView hotelName;


    }
}