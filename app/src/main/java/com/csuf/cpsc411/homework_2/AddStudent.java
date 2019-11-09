package com.csuf.cpsc411.homework_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.csuf.cpsc411.homework_2.adapter.AppConstant;
import com.csuf.cpsc411.homework_2.model.Student;
import com.csuf.cpsc411.homework_2.model.Vehicle;
import java.util.ArrayList;

public class AddStudent extends AppCompatActivity {

    ImageView add_img;

    EditText sd_add_fname,sd_add_lname,sd_add_cwid,sd_add_vehicleMake,
            sd_add_vehicleModel,sd_add_vehicleYear;

    ArrayList<Vehicle> vehicle;

    boolean obb=false;

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addstudent);

        add_img = (ImageView) findViewById(R.id.img_add);
        sd_add_fname = (EditText)findViewById(R.id.sd_add_fname);
        sd_add_lname = (EditText)findViewById(R.id.sd_add_lname);
        sd_add_cwid = (EditText)findViewById(R.id.sd_add_cwid);
        sd_add_vehicleMake = (EditText)findViewById(R.id.sd_add_vehicleMake);
        sd_add_vehicleModel = (EditText)findViewById(R.id.sd_add_vehicleModel);
        sd_add_vehicleYear = (EditText)findViewById(R.id.sd_add_vehicleYear);


        add_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(obb==false){
                    createStudentObject();
                }

                vehicle.add(new Vehicle(sd_add_cwid.getText().toString(),
                        sd_add_vehicleMake.getText().toString(),
                        sd_add_vehicleModel.getText().toString(),
                        sd_add_vehicleYear.getText().toString()));

                student.setVehicle(vehicle);

                sd_add_cwid.setEnabled(false);
                sd_add_fname.setEnabled(false);
                sd_add_lname.setEnabled(false);

                sd_add_vehicleMake.getText().clear();
                sd_add_vehicleModel.getText().clear();
                sd_add_vehicleYear.getText().clear();

            }
        });

    }

    public void saveDate(){

        if(obb==false){
            createStudentObject();
        }


        vehicle.add(new Vehicle(sd_add_cwid.getText().toString(),
                sd_add_vehicleMake.getText().toString(),
                sd_add_vehicleModel.getText().toString(),
                sd_add_vehicleYear.getText().toString()));

        student.setVehicle(vehicle);
        AppConstant.dataModels.add(student);


    }

    public void createStudentObject(){

        student= new Student(sd_add_cwid.getText().toString(),
                sd_add_fname.getText().toString(),sd_add_lname.getText().toString());

        vehicle = new ArrayList<Vehicle>();

        obb=true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.findItem(R.id.add).setTitle("Done");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle item selection
        switch (item.getItemId()) {
            case R.id.add:

                saveDate();

                Intent i = new Intent(AddStudent.this,MainActivity.class);
                startActivity(i);
                AppConstant.flag = false;

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}