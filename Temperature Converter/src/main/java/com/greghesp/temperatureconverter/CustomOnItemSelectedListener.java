package com.greghesp.temperatureconverter;

import android.view.View;
import android.widget.AdapterView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
public EditText text;
public Spinner spinner1;
    public String degree;

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        String tempValue = spinner1.getSelectedItem().toString();

        float inputValue = 0f;
        if(text.getText().length() == 0) {
            inputValue = Float.parseFloat("0");
            text.setText("0");
        }
        else {
            inputValue = Float.parseFloat(text.getText().toString());
        }

        degree = "jobby";

           /*if ("Fahrenheit".equals(tempValue)) {
                out.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)) + " & " + String.valueOf(ConverterUtil.convertFahrenheitToKelvin(inputValue)));
                //type.setText("Celsius + Kelvin");
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
