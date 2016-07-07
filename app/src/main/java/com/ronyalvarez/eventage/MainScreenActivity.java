package com.ronyalvarez.eventage;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainScreenActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private CustomAdapter mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_screen);

            if (savedInstanceState == null)
            {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.drawer_layout, new PlaceholderFragment())
                        .commit();
            }

            final TextView tvWelcomeMessage = (TextView) findViewById(R.id.tvWelcomeMessage);
            final Switch toggle = (Switch) findViewById((R.id.switch1)); //setting the switch button as toggle



            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            String username = intent.getStringExtra("username");

            String message = "Hello ";
            message = message.concat(name);
            message = message.concat(", welcome to your user area!");

            tvWelcomeMessage.setText(message);


            toggle.setChecked(true); //setting toggle to true
            toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() //when toggle changes from true to false
                {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) //on the change
                        {
                            if (bChecked)
                                {
                                    //this is where we code to have all information captured (calls, texts, pictures, etc)
                                }
                            else
                                {
                                    setContentView(R.layout.fragment_results); //when we are finished with the event, open results
                                }
                        }
                });

            if (toggle.isChecked())
                {
                    //this is where we code to have all information captured (calls, texts, pictures, etc)
                }
            else
                {
                    setContentView(R.layout.fragment_results);
                }

            mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
            mActivityTitle = getTitle().toString();

            addDrawerItems();
            setupDrawer();

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

    private void addDrawerItems() {
        String[] menuTitles = getResources().getStringArray(R.array.menu_items);
        int[] menuImages = {
                R.drawable.ic_gallery,
                R.drawable.ic_facebook_icon,
                R.drawable.ic_twitter_icon,
                R.drawable.ic_settings,
                R.drawable.ic_logout
        };

        mAdapter = new CustomAdapter(this, menuTitles, menuImages);
        mDrawerList.setAdapter(mAdapter);
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public static class PlaceholderFragment extends Fragment
    {
        public PlaceholderFragment()

        {

        }

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
