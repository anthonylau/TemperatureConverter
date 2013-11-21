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
    public EditText text;
    public Spinner spinner1;
    public MyPagerAdapter myPager;
    public CustomOnItemSelectedListener selectedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        myPager = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(myPager);
        selectedListener = new CustomOnItemSelectedListener();
        text = (EditText) findViewById(R.id.valueInput);
        selectedListener.text = text;
        addListenerOnSpinnerItemSelection();
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

