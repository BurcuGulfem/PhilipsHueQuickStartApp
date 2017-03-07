package com.philips.lighting.quickstart;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.philips.lighting.samples.DummyFragment;
import com.philips.lighting.samples.RandomLightsFragment;

/**
 * MyApplicationActivity - The starting point for creating your own Hue App.
 * Currently contains a simple view with a button to change your lights to random colours.  Remove this and add your own app implementation here! Have fun!
 *
 * @author SteveyO
 */
public class MyApplicationActivity extends Activity implements SamplesListFragment.OnFragmentInteractionListener {
    public static final String TAG = "QuickStart";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);

        //Add the home fragment at app opening.
        //We don't add this to backstack so we don't see a blank activity on back press
        Fragment samplesListFragment = new SamplesListFragment();
        openNewFragment(samplesListFragment, false, false);
    }

    public void openNewFragment(Fragment fragment, boolean replace, boolean addToBackstack) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (replace) {
            fragmentTransaction.replace(R.id.content, fragment);
        } else {
            fragmentTransaction.add(R.id.content, fragment);
        }
        if (addToBackstack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    /**
     * Open the fragment at given index.
     * Add your fragment name to samples_list on strings.xml to see them in list
     * Then initialize your fragment at the same index
     *
     * @param selectedSample index of the sample in samples_list on strings.xml
     */
    @Override
    public void onSampleSelected(int selectedSample) {
        Fragment fragment;
        switch (selectedSample) {
            case 0:
                fragment = RandomLightsFragment.newInstance();
                break;
            default:
                fragment = DummyFragment.newInstance();
                break;
        }
        openNewFragment(fragment, true, true);
    }
}
