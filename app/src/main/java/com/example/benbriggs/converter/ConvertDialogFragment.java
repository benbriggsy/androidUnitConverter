package com.example.benbriggs.converter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by benbriggs on 12/09/2016.
 */
public class ConvertDialogFragment extends DialogFragment{

    public interface ConvertDialogListener {
        void onClick(DialogFragment dialog, int i, String[] types);
    }

    // Use this instance of the interface to deliver action events
    ConvertDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (ConvertDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    private String[] mConversions = {
            "cm to inches",
            "inches to cm",
            "Metre to Foot",
            "Foot to Metre",
            "KM to Miles",
            "Miles to KM"
    };

    public ConvertDialogFragment(){
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Simple Dialog");
        builder.setItems(mConversions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onClick(ConvertDialogFragment.this, i, mConversions);
            }
        });
        return builder.create();
    }
}
