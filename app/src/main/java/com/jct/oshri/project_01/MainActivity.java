package com.jct.oshri.project_01;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jct.oshri.project_01.controller.TimePickerFragment;
import com.jct.oshri.project_01.model.backend.DB_manager;
import com.jct.oshri.project_01.model.backend.factoryMethod;
import com.jct.oshri.project_01.model.datasource.FireBase_DBManager;
import com.jct.oshri.project_01.model.entities.optionOfTrip;
import com.jct.oshri.project_01.model.entities.ride;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void submit_click(View view) {
        if (!isValidated()) return;

        Toast toast = Toast.makeText(getApplicationContext(), "Sending..", Toast.LENGTH_SHORT);
        toast.show();

        String fullName = ((EditText) findViewById(R.id.fullName)).getText().toString();
        String PhoneNumber = ((EditText) findViewById(R.id.phone)).getText().toString();
        String Email = ((EditText) findViewById(R.id.email)).getText().toString();
        String source = ((EditText) findViewById(R.id.curLocation)).getText().toString();
        String dest = ((EditText) findViewById(R.id.desLocation)).getText().toString();
        String startTime = ((TextView) findViewById(R.id.timeText)).getText().toString();
        String finishTime = "unknown";
        optionOfTrip status = optionOfTrip.UNOCCUPIED;

        ride ride = new ride(status, source, dest, startTime, finishTime, fullName, PhoneNumber, Email);

        DB_manager dBase = factoryMethod.getManager();
        dBase.addNewRide(ride);
    }

    private boolean isValidated() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this).setNeutralButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        if (((EditText) findViewById(R.id.fullName)).getText().toString().length() == 0) {
            alert.setMessage("Full name is missing!");
            alert.show();
            return false;
        }

        if (((EditText) findViewById(R.id.phone)).getText().toString().length() == 0) {
            alert.setMessage("Phone number is missing!");
            alert.show();
            return false;
        }

        if (((EditText) findViewById(R.id.email)).getText().toString().length() == 0) {
            alert.setMessage("Email address is missing!");
            alert.show();
            return false;
        }

        if (((EditText) findViewById(R.id.curLocation)).getText().toString().length() == 0) {
            alert.setMessage("Current location is missing!");
            alert.show();
            return false;
        }

        if (((EditText) findViewById(R.id.desLocation)).getText().toString().length() == 0) {
            alert.setMessage("Destination address is missing!");
            alert.show();
            return false;
        }

        return true;
    }

    public void choseTime(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");
    }

}
