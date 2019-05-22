package android.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView result;
    public EditText height;
    public EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
    }
    public void calculateBMI(View v)
    {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        float heightValue = Float.parseFloat(heightStr) / 100;
        float weightValue = Float.parseFloat(weightStr);
        float bmi = weightValue / (heightValue * heightValue);
        displayBMI(bmi);

    }
    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (bmi < 18.5)
        {
            bmiLabel = getString(R.string.underweight);
        }
        else if (bmi >= 18.5 && bmi < 25)
        {
            bmiLabel = getString(R.string.normal);
        }
         else if (bmi >= 25 && bmi < 30)
        {
            bmiLabel = getString(R.string.overweight);
        } else if (bmi >= 30)
        {
            bmiLabel = getString(R.string.obese);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}
