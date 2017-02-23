package com.firstproject.minorproject.attendancemanager;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InstructActivity extends AppCompatActivity {
    Button takeAttendance;
    Button addSubject;
    Button viewAttendance;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruct);


        takeAttendance = (Button) findViewById(R.id.btn_take_attendance);
        addSubject = (Button) findViewById(R.id.btn_add_subject);
        viewAttendance = (Button) findViewById(R.id.btn_view_previous_attendance);

        takeAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructActivity.this, SubjectsList.class);
                startActivity(intent);
                InstructActivity.this.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
        addSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructActivity.this, AddSubjectActivity.class);
                startActivity(intent);
                InstructActivity.this.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
            }
        });
        viewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructActivity.this, SubjectsList.class);
                startActivity(intent);
                InstructActivity.this.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
