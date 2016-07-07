package com.ronyalvarez.eventage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrew on 7/6/2016.
 */
public class ResultsFragment extends Fragment
    {
        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View rootView = inflater.inflate(R.layout.fragment_results, container, false);

            String[] events = {"Picture taken @ 10:32", "Text to Jessie", "Tweet: 'Amazing Time!'" +
                    "Phone Call to John M", "Instagram post @ 2 PM", "Text to Simon"}; //this array is being used as an example

            List<String> eventsAL = new ArrayList<String>(Arrays.asList(events));

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.fragment_results,
                    R.id.textView2,
                    eventsAL);

            ListView listView = (ListView) rootView.findViewById(R.id.listView);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    if (position == 1)
                    {
                        //code here to possibly delete events or something
                    }
                }

            });

            return rootView;
        }
    }
