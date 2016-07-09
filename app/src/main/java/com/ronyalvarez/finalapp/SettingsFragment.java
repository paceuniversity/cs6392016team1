package com.ronyalvarez.finalapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class SettingsFragment extends Fragment {
    private Config config = new Config();
    private CheckBox cbPhone;
    private CheckBox cbGPS;
    private CheckBox cbSMS;
    private Button bOK;
    private Button bCancel;

    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        Firebase.setAndroidContext(getContext());
        Firebase mRef = new Firebase(FbConfig.FIREBASE_URL);
        Firebase configRef = mRef.child("Config");
        final Firebase phoneRef = configRef.child("Phone");
        final Firebase gpsRef = configRef.child("GPS");
        final Firebase smsRef = configRef.child("SMS");

        cbPhone = (CheckBox)v.findViewById(R.id.cbPhone);
        cbGPS = (CheckBox)v.findViewById(R.id.cbGPS);
        cbSMS = (CheckBox)v.findViewById(R.id.cbSMS);
        bOK = (Button)v.findViewById(R.id.bOk);
        bCancel = (Button)v.findViewById(R.id.bCancel);

        //mRef.child("config2").setValue(config);


        phoneRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cbPhone.setChecked(dataSnapshot.getValue(boolean.class));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("firebase","error writing to database");
            }
        });

        gpsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cbGPS.setChecked(dataSnapshot.getValue(boolean.class));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("firebase","error writing to database");
            }
        });

        smsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cbSMS.setChecked(dataSnapshot.getValue(boolean.class));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("firebase","error writing to database");
            }
        });






        bOK.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneRef.setValue(cbSMS.isChecked());
                gpsRef.setValue(cbGPS.isChecked());
                smsRef.setValue(cbSMS.isChecked());
                getActivity().finish();
            }
        });

        bCancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return v;
    }
}
