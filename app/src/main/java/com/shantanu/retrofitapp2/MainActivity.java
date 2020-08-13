package com.shantanu.retrofitapp2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shantanu.retrofitapp2.Adapter.CustomAdapter;
import com.shantanu.retrofitapp2.Module.RetroPhoto;
import com.shantanu.retrofitapp2.network.GetDataService;
import com.shantanu.retrofitapp2.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);//declaration

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");


        getAllData();
    }

    private void getAllData() {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<RetroPhoto> call = service.getAllPhotos();
        progressDoalog.show();
        call.enqueue(new Callback<RetroPhoto>() {
            @Override
            public void onResponse(Call<RetroPhoto> call, Response<RetroPhoto> response) {
                if (response.isSuccessful()) {
                    progressDoalog.dismiss();

                    RetroPhoto photoList = response.body();

                    adapter = new CustomAdapter(MainActivity.this, R.layout.list, photoList.getDatas());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<RetroPhoto> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}