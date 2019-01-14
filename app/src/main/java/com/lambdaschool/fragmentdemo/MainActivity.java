package com.lambdaschool.fragmentdemo;

import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements PlusOneFragment.OnFragmentInteractionListener, LoginFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FrameLayout frameLayout = findViewById(R.id.fragment_holder);

        /*PlusOneFragment fragment = new PlusOneFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_holder, fragment).commit();*/

        /*DialogFragment dialogFragment = new PlusOneFragment();
        dialogFragment.show(getSupportFragmentManager(), PlusOneFragment.TAG);*/

        LoginFragment fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_holder, fragment).commit();
//        fragment.show(getSupportFragmentManager(), LoginFragment.TAG);

    }

    @Override
    public void onLoginFragmentInteraction(String uri) {
        Log.i(TAG, uri);
        if(getResources().getBoolean(R.bool.is_tablet)) {
            // update other fragment
        } else {
            Fragment fragment = new PlusOneFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, fragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
