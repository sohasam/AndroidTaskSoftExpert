package com.example.androidtasksoftexpert.ui;

import com.example.androidtasksoftexpert.pojos.CarModel;
import com.example.androidtasksoftexpert.retrofit.ApiClient;

import java.util.List;

public class Presenter implements BaseContract.Presenter {

    BaseContract.View  view ;

    ApiClient apiClient;
    public Presenter(BaseContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {

       if(apiClient==null)
       {
           apiClient= new ApiClient(this);
       }
        apiClient.start(1);

    }

    @Override
    public void handleRetriveSuccessData(List<CarModel> cars) {
        view.viewResult(cars);
    }


}
