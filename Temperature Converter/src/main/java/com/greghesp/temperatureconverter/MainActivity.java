package com.greghesp.temperatureconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {
    private EditText text;
    private TextView out;
    private TextView type;
    private Spinner spinner1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.valueInput);
        out = (TextView) findViewById(R.id.temperatureResult);
        type = (TextView) findViewById(R.id.temperatureType);

        addListenerOnSpinnerItemSelection();
    }

    public void addListenerOnSpinnerItemSelection() {

        if (text.getText().toString().length() == 0) {
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
            float inputValue = Float.parseFloat(text.getText().toString());

            if ("Fahrenheit".equals(tempValue)) {
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
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }

    }

}

