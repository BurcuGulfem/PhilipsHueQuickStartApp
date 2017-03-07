package com.philips.lighting.quickstart;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * MyApplicationActivity - The starting point for creating your own Hue App.  
 * Currently contains a simple view with a button to change your lights to random colours.  Remove this and add your own app implementation here! Have fun!
 * 
 * @author SteveyO
 *
 */
public class MyApplicationActivity extends Activity {
    public static final String TAG = "QuickStart";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);

        //Add the home fragment at app opening.
        // We do not add this fragment to backstack, as we don't want to return back to it
        Fragment randomLightsFragment = new RandomLightsFragment();
        openNewFragment(randomLightsFragment,RandomLightsFragment.TAG,false,false);
    }

    public void openNewFragment(Fragment fragment, String tag, boolean replace, boolean addToBackstack){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        if(replace){
            fragmentTransaction.replace(R.id.content,fragment,tag);
        }
        else {
            fragmentTransaction.add(R.id.content,fragment,tag);
        }
        if(addToBackstack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
