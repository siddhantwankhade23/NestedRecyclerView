package com.example.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.nestedrecyclerview.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        List<List<MyPojo>> myPojoList = new Gson().fromJson(loadJsonFromAssets("urls.json"), new TypeToken<List<List<MyPojo>>>() {
        }.getType());

        activityMainBinding.rvParent.setLayoutManager(new LinearLayoutManager(this));

        ParentAdapter parentAdapter = new ParentAdapter(this,myPojoList);
        activityMainBinding.rvParent.setAdapter(parentAdapter);


    }


    public String loadJsonFromAssets(String fileName) {
        String json = null;
        try (InputStream is = this.getAssets().open(fileName)) {

            int size = is.available();
            byte[] buffer = new byte[size];

            int bytesRead = is.read(buffer);

            json = new String(buffer, "UTF-8");

        } catch (Exception ex) {
            return null;
        }

        return json;
    }
}