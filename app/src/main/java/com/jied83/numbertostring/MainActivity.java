package com.jied83.numbertostring;

import android.app.Activity;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText inputText;
    TextView textOutput;
    Button button;

    private NumberToString numberToString;

    private String[] mOneTwenty;
    private String[] mPoint;
    private String[] mTens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText) findViewById(R.id.editText);
        inputText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(15)});
        textOutput = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        // Get arrays from resource xml
        mOneTwenty = getResources().getStringArray(R.array.oneTwenty);
        mPoint = getResources().getStringArray(R.array.point);
        mTens = getResources().getStringArray(R.array.tens);

        // setup button action
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberToString = new NumberToString(mOneTwenty,mPoint,mTens);
                if (inputText.getText().toString().length() > 0) {
                    String translatedString = numberToString.translate(Long.parseLong(inputText.getText().toString()));
                    textOutput.setText(translatedString);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
