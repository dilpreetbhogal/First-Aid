package com.firstaid;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firstaid.util.customview.DatePickerDialogFragment;

import java.util.Locale;

/**
 * The type Sign up activity.
 */
public class SignUpActivity extends AppCompatActivity {

    private DatePickerDialogFragment mDatePickerDialogFragment;
    private EditText etDob;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    /**
     * Init.
     */
    private void init() {
        etDob = findViewById(R.id.etDob);

        //Click listener for top back button
        findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //this is the default method provided by super class
                onBackPressed();
            }
        });

        //Click listener for date of birth picker
        findViewById(R.id.etDob).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                showDatePickerDialog();
            }
        });

        //Click listener for register button
        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                //Thia is used for to clear all the back stack
                finishAffinity();
            }
        });
    }

    private void showDatePickerDialog() {
        //This is to check that dialog is already visible or not
        if (mDatePickerDialogFragment != null && mDatePickerDialogFragment.isVisible()) {
            mDatePickerDialogFragment.dismiss();
        }
        mDatePickerDialogFragment = new DatePickerDialogFragment(null, true, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(final DatePicker datePicker, final int year, final int month, final int dateOfMonth) {
                etDob.setText(String.format(Locale.US,"%d/%d%d/%d", dateOfMonth, month, 1, year));
            }
        });
        mDatePickerDialogFragment.show(getSupportFragmentManager(), null);
    }
}
