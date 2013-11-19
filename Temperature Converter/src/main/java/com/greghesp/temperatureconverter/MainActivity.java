package com.greghesp.temperatureconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
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

    // this method is called at button click because we assigned the name to the
    // "OnClick property" of the button
   /* public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                //Give the radio buttons a name
                /*RadioButton fromCelsiusButton = (RadioButton) findViewById(R.id.fromCels);
                RadioButton fromFahrenheitButton = (RadioButton) findViewById(R.id.fromFahr);
                RadioButton fromKelvinButton = (RadioButton) findViewById(R.id.fromKel);

                RadioButton toCelsiusButton = (RadioButton) findViewById(R.id.toCels);
                RadioButton toFahrenheitButton = (RadioButton)findViewById(R.id.toFahr);
                RadioButton toKelvinButton = (RadioButton)   findViewById(R.id.toKel);




                //Get the value of text and store it as a float
                float inputValue = Float.parseFloat(text.getText().toString());

                //Celsius to Fahrenheit
               /* if (fromCelsiusButton.isChecked() && toFahrenheitButton.isChecked()) {
                    out.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    type.setText("Fahrenheit");
                }
                //Celsius to Kelvin
                else if (fromCelsiusButton.isChecked() && toKelvinButton.isChecked()) {
                    out.setText(String.valueOf(ConverterUtil.convertCelsiusToKelvin(inputValue)));
                    type.setText("Kelvin");
                }
                //Fahrenheit to Celsius
                else if (fromFahrenheitButton.isChecked() && toCelsiusButton.isChecked()){
                    out.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    type.setText("Celsius");
                }
                //Fahrenheit to Kelvin
                else if (fromFahrenheitButton.isChecked() && toKelvinButton.isChecked()) {
                    out.setText(String.valueOf(ConverterUtil.convertFahrenheitToKelvin(inputValue)));
                    type.setText("Kelvin");
                }
                //Kelvin to Celsius
                else if (fromKelvinButton.isChecked() && toCelsiusButton.isChecked()) {
                    out.setText(String.valueOf(ConverterUtil.convertKelvinToCelsius(inputValue)));
                    type.setText("Celsius");
                }
                //Kelvin to Fahrenheit
                else if (fromKelvinButton.isChecked() && toFahrenheitButton.isChecked()) {
                    out.setText(String.valueOf(ConverterUtil.convertKelvinToFahrenheit(inputValue)));
                    type.setText("Fahrenheit");
                }
                //Can't convert the same temperature
                else if (fromCelsiusButton.isChecked() && toCelsiusButton.isChecked() || fromFahrenheitButton.isChecked() && toFahrenheitButton.isChecked() || fromKelvinButton.isChecked() && toKelvinButton.isChecked()) {
                    Toast.makeText(this, "Sorry, you can't convert a temperature to the same type", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }*/

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
            float inputValue = Float.parseFloat(text.getText().toString());

            if ("Fahrenheit".equals(tempValue)) {
                out.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)) + " & " + String.valueOf(ConverterUtil.convertFahrenheitToKelvin(inputValue)));
                type.setText("Celsius + Kelvin");
               }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }

    }

}

