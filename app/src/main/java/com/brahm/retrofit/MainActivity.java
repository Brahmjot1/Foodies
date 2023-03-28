package com.brahm.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements selectListener {

    List<Meal> allUserList=new ArrayList<>();
     RecyclerView rcvMain;
     SearchView searchView;
     userMeal usermeal;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         rcvMain=findViewById(R.id.rcvMain);
         searchView=findViewById(R.id.searchview);
         searchView.clearFocus();
         rcvMain.setLayoutManager(new LinearLayoutManager(this));

        TextView itemTxt;
        itemTxt =  findViewById(R.id.itemTxt);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                serachText(newText);
                return true;
            }
        });


        RetrofitInstance.getInstance().apiInterface.getDishes().enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful())
                        {

                            try {
                                JSONObject jsonObject=new JSONObject(response.body().string());
                                JSONArray jsonArray=jsonObject.getJSONArray("meals");
                                for(int i=0;i<jsonArray.length();i++)
                                {
                                    JSONObject jsonObject1= new JSONObject(String.valueOf(jsonArray.get(i)));
                                    String description=jsonObject1.getString("strDescription");
                                    String id=jsonObject1.getString("idIngredient");
                                    String ingredient=jsonObject1.getString("strIngredient");

                                        Meal meal=new Meal(id,description,ingredient);
                                            allUserList.add(meal);
                                }

                            usermeal=new userMeal(MainActivity.this,allUserList,MainActivity.this);
                                rcvMain.setAdapter(usermeal);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t)
                {
                    Log.e("api","Something went wrong"+t.getLocalizedMessage());
                }
            });
    }

    private void serachText(String newText) {
        List<Meal> filterlist=new ArrayList<>();
        for(Meal m:allUserList)
        {
            if(m.getStrIngredient().toLowerCase().contains(newText.toLowerCase()))
            {
                filterlist.add(m);
            }
        }
       usermeal.setfilteredList(filterlist);
    }


    @Override
    public void onItemClicked(Meal meal)
    {
        Intent iNext;
        iNext = new Intent(MainActivity.this,FoodDescription.class);
        iNext.putExtra("DescriptionOfFood",meal.getStrDescription());
        startActivity(iNext);
    }
}
