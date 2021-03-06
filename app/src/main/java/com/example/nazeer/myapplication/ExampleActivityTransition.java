package com.example.nazeer.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ExampleActivityTransition extends AppCompatActivity implements View.OnClickListener{

    ImageView redIv,blueIv,greenIv;
    public static View selectedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exampletransition1);
        redIv= (ImageView) findViewById(R.id.imageViewRedCircle);
        blueIv= (ImageView) findViewById(R.id.imageViewBlueCircle);
        greenIv= (ImageView) findViewById(R.id.imageViewGreenCircle);

        redIv.setOnClickListener(this);
        greenIv.setOnClickListener(this);
        blueIv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

            selectedView=v;
        int id=v.getId();
        switch (id){
            case R.id.imageViewRedCircle:
                startActivity(v, R.drawable.red_circle);
                break;
            case R.id.imageViewGreenCircle:
                startActivity(v, R.drawable.green_circle);
                break;
            case R.id.imageViewBlueCircle:
                startActivity(v, R.drawable.blue_rectangle);
                break;
        }
    }

    private void startActivity(final View fromView, int imageResource) {

        Intent intent =new Intent(this, ExampleTransitionActivity2.class);
        intent.putExtra("selectedImage", imageResource);
        int []startlocation=new int [2];
        int startWidth=selectedView.getLayoutParams().width;
        int startHeight=selectedView.getLayoutParams().height;
        selectedView.getLocationOnScreen(startlocation);
        intent.putExtra("startLocation",startlocation);
        intent.putExtra("startWidth",startWidth);
        intent.putExtra("startHeight",startHeight);
        startActivity(intent);
        overridePendingTransition(0,0);


    }

    @Override
    protected void onResume() {
        super.onResume();
        if(selectedView!=null){
            selectedView.setVisibility(View.VISIBLE);
        }
    }
}
