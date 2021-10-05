package com.example.androidtasksoftexpert.ui;

import com.example.androidtasksoftexpert.pojos.CarModel;

import java.util.List;

public interface BaseContract {

    interface View {

    public void viewResult( List<CarModel> cars);
    public void  showDetailsView(CarModel car);

    }

    interface Presenter {
        public  void  loadData();
        public  void handleRetriveSuccessData( List<CarModel> cars);

    }
}
