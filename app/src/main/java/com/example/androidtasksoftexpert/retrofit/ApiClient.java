package com.example.androidtasksoftexpert.retrofit;

import android.util.Log;

import com.example.androidtasksoftexpert.pojos.CarModel;
import com.example.androidtasksoftexpert.pojos.ResponseModel;
import com.example.androidtasksoftexpert.ui.BaseContract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient  implements Callback<ResponseModel> {
    static final String BASE_URL = "https://demo1585915.mockable.io/";

    BaseContract.Presenter presenter ;

    public ApiClient(BaseContract.Presenter presenter) {
        this.presenter = presenter;
    }


    public void start( int page) {


        Log.i("soha" ,"start");

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Log.i("soha" ,"10000");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();



        ApiService api = retrofit.create(ApiService.class);

        Call<ResponseModel> call = api.getData(page );
        call.enqueue(this);


    }

    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

        if(response.isSuccessful()) {
//            List<ResponseModel> responseList = response.body();
//            for(ResponseModel p : responseList)
if(response.body() !=null) {
    List<CarModel> carModels = response.body().getData();
presenter.handleRetriveSuccessData(carModels);

}
//           for( CarModel car : carModels)
//           {
//               Log.i("soha" ,car.getBrand());
//               Log.i("soha" ,car.isUsed()+"");
//
//
//
//           }


        } else {
            System.out.println(response.errorBody());

        }
    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {

        Log.i("soha" ,"fail");


        t.printStackTrace();
    }
}
