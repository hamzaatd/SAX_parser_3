package com.example.sax_parser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.one);
        final Retrofit r = new Retrofit.Builder().baseUrl("http://www.w3schools.com")
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

                 final api one =r.create(api.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<breakfast_menu> br =one.get_all();
                br.enqueue(new Callback<breakfast_menu>() {
                    @Override
                    public void onResponse(Call<breakfast_menu> call, Response<breakfast_menu> response) {
                        breakfast_menu menu =response.body();
                        List<food> f= menu.getFood();
                        String calories = f.get(0).getCalories();
                        String name =f.get(0).getName();
                        String price =f.get(0).getPrice();
                        String description=f.get(0).getDescription();
                        Toast.makeText(MainActivity.this, "data is data "+calories, Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "data is data "+name, Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "data is data "+price, Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "data is data "+description, Toast.LENGTH_LONG).show();
                                      }

                    @Override
                    public void onFailure(Call<breakfast_menu> call, Throwable t) {
                        Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });












            }
        });

    }




}
