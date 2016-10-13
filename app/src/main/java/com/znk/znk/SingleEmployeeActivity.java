package com.znk.znk;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Krystian on 2016-10-09.
 */

public class SingleEmployeeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String employeeName = intent.getStringExtra("name");
        setContentView(R.layout.single_employee_activity);
        TextView employeeNameTextView = (TextView) findViewById(R.id.employeeName);
        employeeNameTextView.setText(employeeName);

        Spinner spinner = (Spinner) findViewById(R.id.consultationSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.constultation_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ImageView employeePhoto = (ImageView) findViewById(R.id.employeePhoto);

        int imageResource = getResources().getIdentifier("@drawable/default_pic", null, getPackageName());

        Drawable res = getResources().getDrawable(imageResource);
        employeePhoto.setImageDrawable(res);
    }
}
