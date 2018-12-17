package com.jct.oshri.project_01.model.datasource;

import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jct.oshri.project_01.model.backend.DB_manager;
import com.jct.oshri.project_01.model.entities.ride;

public class FireBase_DBManager implements DB_manager {

    @Override
    public void addNewRide(final ride aRide) {
        DatabaseReference ridesRef = FirebaseDatabase.getInstance().getReference("Ride");
        final String key = ridesRef.push().getKey();
        DatabaseReference userRideRef = ridesRef.child(key);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (!dataSnapshot.exists()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = database.getReference("Ride/" + key);
                    databaseReference.setValue(aRide);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        userRideRef.addListenerForSingleValueEvent(eventListener);
    }
}
