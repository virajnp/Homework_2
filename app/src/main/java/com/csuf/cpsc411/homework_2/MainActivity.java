package com.csuf.cpsc411.homework_2;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.csuf.cpsc411.homework_2.adapter.AppConstant;
import com.csuf.cpsc411.homework_2.adapter.CustomList;
import com.csuf.cpsc411.homework_2.model.Student;
import com.csuf.cpsc411.homework_2.model.Vehicle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CustomList adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.list);
        adapter = new CustomList(AppConstant.dataModels,getApplicationContext());
        listview.setAdapter(adapter);

        if(AppConstant.flag){
            new Task().execute();
        }

    }

    private class Task extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @SuppressLint("CommitTransaction")
        protected Void doInBackground(Void... params) {

            Student student = new Student("1","Viraj", "Pargaonkar");

            ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
            vehicle.add(new Vehicle("1","BMW", "X1","2019"));
            vehicle.add(new Vehicle("1","Tesla", "Model S","2019"));
            student.setVehicle(vehicle);
            AppConstant.dataModels.add(student);

            student = new Student("2","Arindam", "Roy");
            vehicle = new ArrayList<Vehicle>();
            vehicle.add(new Vehicle("2","Honda", "Accord","2018"));
            vehicle.add(new Vehicle("2","Honda", "Civic","2016"));
            vehicle.add(new Vehicle("2","Chevrolet", "Camaro","2018"));
            student.setVehicle(vehicle);
            AppConstant.dataModels.add(student);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

             adapter.notifyDataSetChanged();
            Log.d("vt","MAinActivity onPostExecute"+AppConstant.dataModels);

        }

    }

}
