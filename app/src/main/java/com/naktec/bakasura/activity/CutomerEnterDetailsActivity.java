package com.naktec.bakasura.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.naktec.bakasura.R;

public class CutomerEnterDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomer_enter_details);
        Button btn= (Button) findViewById(R.id.orderDetailButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CutomerEnterDetailsActivity.this, FinishActivity.class);

                startActivity(i);
                finish();
            }
        });
    }
}
