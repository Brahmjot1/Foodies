package com.brahm.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodDescription extends AppCompatActivity {

    TextView foodDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_description);

        Intent fromMain = getIntent();
        String result=fromMain.getStringExtra("DescriptionOfFood");


     TextView txtFoodDescription;
     txtFoodDescription=findViewById(R.id.txtFoodDescription);
        txtFoodDescription.setMovementMethod(new ScrollingMovementMethod());
     txtFoodDescription.setText(result);



    }

}