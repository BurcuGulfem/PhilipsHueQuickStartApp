package com.philips.lighting.quickstart;

/**
 * Created by burcuarabaci on 06/03/17.
 */


import android.app.Fragment;

/**
 * This interface must be implemented by activities that contain this
 * fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that
 * activity.
 * <p>
 */
public interface OnFragmentInteractionListener {
    void openNewFragment(Fragment fragment, String tag, boolean replace, boolean addToBackstack);
    void closeFragment(String tag);
}