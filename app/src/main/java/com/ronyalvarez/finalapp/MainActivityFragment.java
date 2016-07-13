package com.ronyalvarez.finalapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EventNameFragment.EventNameDialogListener {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        Typeface myTypeFace = Typeface.createFromAsset(getActivity().getAssets(), "Angeline Vintage_Demo.ttf");
        TextView title = (TextView) v.findViewById(R.id.tvEventage);
        assert title != null;
        title.setTypeface(myTypeFace);

        Button button = (Button)v.findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Images.class);
                startActivity(intent);

            }
        });

        Button bStartStop = (Button)v.findViewById(R.id.bStartStop);
        bStartStop.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog();
            }
        });
        return v;
    }

    public void showEditDialog(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        EventNameFragment eventNameFragment = new EventNameFragment();
        eventNameFragment.setTargetFragment(this, 0);
        eventNameFragment.show(fm, "fragment_event_name");
    }

    @Override
    public void onFinishEditDialog(final String inputText){
        final TextView textView = (TextView)getView().findViewById(R.id.tvEvent);
        textView.setText(inputText);
        textView.setVisibility(TextView.VISIBLE);

    }

}
