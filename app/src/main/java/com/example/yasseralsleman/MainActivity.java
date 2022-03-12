package com.example.yasseralsleman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setBackground(null);
        bottom_navigation.setItemIconTintList(null);

        bottom_navigation.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BlankFragment1()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.Fragment1:
                    selectedFragment = new BlankFragment1();
                    break;
                case R.id.Fragment2:
                    selectedFragment = new BlankFragment2();
                    break;
                case R.id.Fragment3:
                    selectedFragment = new BlankFragment3();
                    break;
                case R.id.Fragment4:
                    selectedFragment = new BlankFragment4();
                    break;
                case R.id.Fragment5:
                    selectedFragment = new BlankFragment5();
                    break;

            }


            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        }
    };


}