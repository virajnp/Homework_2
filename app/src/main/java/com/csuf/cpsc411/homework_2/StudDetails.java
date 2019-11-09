package com.csuf.cpsc411.homework_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.csuf.cpsc411.homework_2.adapter.AppConstant;

public class StudDetails extends AppCompatActivity {

    TextView sd_cwid,sd_vehicleMake,sd_vehicleModel,sd_vehicleYear;
    EditText sd_fname,sd_lname;
    int position,course_len;
    MainActivity m;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:

                Intent i = new Intent(StudDetails.this,AddStudent.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vehicledetails);

        sd_vehicleMake = (TextView)findViewById(R.id.sd_vehicleMake);
        sd_vehicleModel = (TextView)findViewById(R.id.sd_vehicleModel);
        sd_vehicleYear = (TextView)findViewById(R.id.sd_vehicleYear);
        sd_cwid = (TextView)findViewById(R.id.sd_cwid);
        sd_fname = (EditText)findViewById(R.id.sd_fname);
        sd_lname = (EditText)findViewById(R.id.sd_lname);

        sd_fname.setEnabled(false);
        sd_lname.setEnabled(false);

        m = new MainActivity();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {

                sd_cwid.setText(extras.getString("cwid"));
                sd_fname.setText(extras.getString("fname"));
                sd_lname.setText(extras.getString("lname"));
                position= extras.getInt("pos");

                course_len= AppConstant.dataModels.get(position).getVehicle().size();


                for(int i=0;i<course_len;i++){


                    sd_vehicleMake.append( AppConstant.dataModels.get(position).getVehicle().get(i).getMake()+ "\n"+"\n");
                    sd_vehicleModel.append( AppConstant.dataModels.get(position).getVehicle().get(i).getModel()+"\n"+"\n");
                    sd_vehicleYear.append( AppConstant.dataModels.get(position).getVehicle().get(i).getYear()+ "\n"+"\n");
                }


            }
        }

    }
}
