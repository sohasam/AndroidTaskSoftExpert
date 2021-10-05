package com.example.androidtasksoftexpert.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtasksoftexpert.R;
import com.example.androidtasksoftexpert.pojos.CarModel;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.InformationListViewHolder> {
    private List<CarModel> carsArray = new ArrayList<>();
    private BaseContract.View view;

    private Context context;


    public Adapter(List<CarModel> carsArray, Context context, BaseContract.View view) {
        this.carsArray = carsArray;
        this.context = context;
        this.view = view;
    }

    @NonNull
    @Override
    public InformationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        InformationListViewHolder informationListViewHolder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        informationListViewHolder = new Adapter.InformationListViewHolder(inflater.inflate(R.layout.list_item, parent, false));
        return informationListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InformationListViewHolder holder, int position) {

        final CarModel car = carsArray.get(position);
        holder.BrandTextView.setText(car.getBrand());
        holder.ConstructionYearTextView.setText(car.getConstractionYear());
        if (car.isUsed()) {
            holder.isUsedtrueBtn.setVisibility(View.VISIBLE);
            holder.isUsedfalseBtn.setVisibility(View.GONE);

        } else {

            holder.isUsedtrueBtn.setVisibility(View.GONE);
            holder.isUsedfalseBtn.setVisibility(View.VISIBLE);


        }


    }

    @Override
    public int getItemCount() {
        return carsArray.size();
    }

    public class InformationListViewHolder extends RecyclerView.ViewHolder {

        private TextView BrandTextView;
        private TextView ConstructionYearTextView;
        private Button isUsedtrueBtn;
        private Button isUsedfalseBtn;

        ImageView img;
        View layoutView;
//        ConstraintLayout constraintLayout;

        public InformationListViewHolder(@NonNull View itemView) {
            super(itemView);
            /// find by id
            layoutView = itemView;
            BrandTextView = itemView.findViewById(R.id.brand);
            ConstructionYearTextView = itemView.findViewById(R.id.year);
            isUsedtrueBtn = itemView.findViewById(R.id.truebtn);
            isUsedfalseBtn = itemView.findViewById(R.id.falsebtn);
            img = itemView.findViewById(R.id.imageView);

        }
    }

    /////////////////////////////////////////
}


