package com.example.benbriggs.converter;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ConvertDialogFragment.ConvertDialogListener {
    EditText mEditText;
    Button mButton;
    TextView mOutput;
    TextView mConversionTypeTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
        mOutput = (TextView) findViewById(R.id.textView3);
        mConversionTypeTitle = (TextView) findViewById(R.id.textView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment convertDialogFragment = new ConvertDialogFragment();
                convertDialogFragment.show(getFragmentManager(), "ConvertDialogFragment");
            }
        });
    }

    @Override
    public void onClick(DialogFragment dialog, int i, String[] types){
        String userInput = mEditText.getText().toString();
        Distance distance = new Distance(this);
        if (userInput.isEmpty()) {
            Toast.makeText(this, "You did not enter a value", Toast.LENGTH_SHORT).show();
            return;
        }
        double entry = Double.parseDouble(userInput);
        switch (i){
            case 0: entry = distance.cmToInches(entry, mConversionTypeTitle, types[i]);
                break;
            case 1: entry = distance.inchesToCm(entry, mConversionTypeTitle, types[i]);
                break;
            case 2: entry = distance.mToFeet(entry, mConversionTypeTitle, types[i]);
                break;
            case 3: entry = distance.feetToM(entry, mConversionTypeTitle, types[i]);
                break;
            case 4: entry = distance.kmToMiles(entry, mConversionTypeTitle, types[i]);
                break;
            case 5: entry = distance.milesToKm(entry, mConversionTypeTitle, types[i]);
                break;
            default: entry = 0;
                mConversionTypeTitle.setText("Error");
                break;
        }
        mOutput.setText(Double.toString(entry));
        hideSoftKeyboard();
    }

    private void hideSoftKeyboard(){
        if(getCurrentFocus()!=null && getCurrentFocus() instanceof EditText){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
        }
    }
}
