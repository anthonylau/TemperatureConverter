package com.greghesp.temperatureconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends FragmentActivity {
    //Define Components
    public EditText text;
    public Spinner spinner1;
    //Define Adapters
    public MyPagerAdapter myPager;
    //Define Event Listeners
    public CustomOnItemSelectedListener selectedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the master layout file
        setContentView(R.layout.activity_main);
        //***Not sure***
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        //***Not sure***
        myPager = new MyPagerAdapter(getSupportFragmentManager());
        //***Not sure***
        pager.setAdapter(myPager);
        //***Not sure***
        selectedListener = new CustomOnItemSelectedListener();
        //Assign the text variable to the layout element
        text = (EditText) findViewById(R.id.valueInput);
        //Call this class
        addListenerOnSpinnerItemSelection();
        //Set text in selectedListener equal to the text definition in here
        selectedListener.text = text;
        //Set selectedListener in myPager equal to the definition in here
        myPager.selectedListener = selectedListener;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public void addListenerOnSpinnerItemSelection() {
            spinner1 = (Spinner) findViewById(R.id.spinner1);
            spinner1.setOnItemSelectedListener(selectedListener);
            selectedListener.spinner1 = spinner1;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this, About.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

