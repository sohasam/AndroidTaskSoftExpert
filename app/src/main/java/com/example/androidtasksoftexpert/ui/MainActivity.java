package com.example.androidtasksoftexpert.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidtasksoftexpert.R;
import com.example.androidtasksoftexpert.pojos.CarModel;
import com.example.androidtasksoftexpert.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseContract.View {


    BaseContract.Presenter presenter = new Presenter(this);
    private Adapter adapter;
    private RecyclerView recyclerView;

    List<CarModel> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        presenter.loadData();




    }

    @Override
    public void viewResult(List<CarModel> cars) {

        adapter = new Adapter(cars, this,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //  recycler_view.addItemDecoration(new RecyclerView.ItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showDetailsView(CarModel car) {

    }
}
