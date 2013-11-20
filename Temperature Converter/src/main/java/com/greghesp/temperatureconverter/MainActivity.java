package com.greghesp.temperatureconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;



public class MainActivity extends Activity {
    private EditText text;
   // private TextView out;
   // private TextView type;
    private Spinner spinner1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = (EditText) findViewById(R.id.valueInput);
        //out = (TextView) findViewById(R.id.temperatureResult);
        //type = (TextView) findViewById(R.id.temperatureType);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        addListenerOnSpinnerItemSelection();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
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

    public void addListenerOnSpinnerItemSelection() {

        if (text.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number",
                    Toast.LENGTH_LONG).show();
        }
        else {
            spinner1 = (Spinner) findViewById(R.id.spinner1);
            spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        }
    }

    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            String tempValue = spinner1.getSelectedItem().toString();

            float inputValue;
            if(text.getText().length() == 0) {
                 inputValue = Float.parseFloat("10");
                 text.setText("10");
            }
            else {
                 inputValue = Float.parseFloat(text.getText().toString());
            }

           /* if ("Fahrenheit".equals(tempValue)) {
                out.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)) + " & " + String.valueOf(ConverterUtil.convertFahrenheitToKelvin(inputValue)));
                type.setText("Celsius + Kelvin");
               }
            if ("Celsius".equals(tempValue)) {
                out.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)) + " & " + String.valueOf(ConverterUtil.convertCelsiusToKelvin(inputValue)));
                type.setText("Fahrenheit + Kelvin");
            }
            if ("Kelvin".equals(tempValue)) {
                out.setText(String.valueOf(ConverterUtil.convertKelvinToCelsius(inputValue)) + " & " + String.valueOf(ConverterUtil.convertKelvinToFahrenheit(inputValue)));
                type.setText("Celsius + Fahrenheit");
            }*/
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos){
            switch(pos) {

                case 0: return resultFragment.newInstance("FirstFragment, Instance 1");
                case 1: return resultFragment.newInstance("SecondFragment, Instance 1");
                default: return resultFragment.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}

