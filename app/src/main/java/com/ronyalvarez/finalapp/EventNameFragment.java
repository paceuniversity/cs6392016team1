package com.ronyalvarez.finalapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


public class EventNameFragment extends DialogFragment implements TextView.OnEditorActionListener {

    public interface EventNameDialogListener{
        void onFinishEditDialog(String inputText);
    }

    private EditText mEditText;

    public EventNameFragment() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_name, container);
        mEditText = (EditText) view.findViewById(R.id.txt_event_name);
        getDialog().setTitle("New Event");
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        mEditText.setOnEditorActionListener(this);

        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
        if (EditorInfo.IME_ACTION_DONE == actionId){
            EventNameDialogListener activity = (EventNameDialogListener)getTargetFragment();
            activity.onFinishEditDialog(mEditText.getText().toString());
            this.dismiss();
            return true;
        }
        return false;
    }
}
