package com.ranzan.analysethefragmenttransactionmethods;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addA, addB, removeA, removeB, replaceAWithoutBackstack, replaceAWithBackstack, replaceB;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        addA = findViewById(R.id.addA);
        addB = findViewById(R.id.addB);
        removeA = findViewById(R.id.removeA);
        removeB = findViewById(R.id.removeB);
        replaceAWithoutBackstack = findViewById(R.id.replaceAWithB);
        replaceAWithBackstack = findViewById(R.id.replaceAWithBwithBackStack);
        replaceB = findViewById(R.id.replaceBWithA);
        addA.setOnClickListener(this);
        addB.setOnClickListener(this);
        removeA.setOnClickListener(this);
        removeB.setOnClickListener(this);
        replaceAWithoutBackstack.setOnClickListener(this);
        replaceAWithBackstack.setOnClickListener(this);
        replaceB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.addA:
                AddA();
                break;
            case R.id.addB:
                AddB();
                break;
            case R.id.removeA:
                RemoveA();
                break;
            case R.id.removeB:
                RemoveB();
                break;
            case R.id.replaceAWithBwithBackStack:
                ReplaceAWithBWithBackStack();
                break;
            case R.id.replaceAWithB:
                ReplaceAWithB();
                break;
            case R.id.replaceBWithA:
                ReplaceBWithA();
                break;


        }
    }

    private void ReplaceAWithBWithBackStack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();

        fragmentTransaction.replace(R.id.fContainer, fragmentB, "fragmentB").addToBackStack("FragmentB").commit();
    }

    private void ReplaceBWithA() {
        FragmentA fragmentA = new FragmentA();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fContainer, fragmentA, "fragmentA").commit();
    }

    private void ReplaceAWithB() {
        FragmentB fragmentB = new FragmentB();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fContainer, fragmentB, "fragmentB").commit();
    }


    private void AddB() {
        FragmentB fragmentB = new FragmentB();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fContainer, fragmentB, "fragmentB").commit();
    }

    private void AddA() {
        FragmentA fragmentA = new FragmentA();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fContainer, fragmentA, "fragmentA").commit();
    }

    private void RemoveA() {
        FragmentA fragmentA = new FragmentA();

        fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA).commit();
        }

    }

    private void RemoveB() {
        FragmentB fragmentB = new FragmentB();
        fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if (fragmentB != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB).commit();
        }

    }

}