package com.firstproject.minorproject.attendancemanager;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.firstproject.minorproject.attendancemanager.R.id.semester;
import static com.firstproject.minorproject.attendancemanager.R.id.subject_name;

public class AddSubjectActivity extends Activity {
    EditText etSubjectName, etSemester, etTotalCount, etFirstEnroll;
    Button btnCreateClass;
    DatabaseHandler database;
    String subjectName, semesterName, totalCount, firstEnroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = new DatabaseHandler(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        etSubjectName = (EditText) findViewById(subject_name);
        etSemester = (EditText) findViewById(semester);
        etTotalCount = (EditText) findViewById(R.id.count_of_student);
        etFirstEnroll = (EditText) findViewById(R.id.first_enroll_number);
        btnCreateClass = (Button) findViewById(R.id.btn_create_class);




        btnCreateClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectName = etSubjectName.getText().toString();
                semesterName = etSemester.getText().toString();
                totalCount = etTotalCount.getText().toString();
                firstEnroll = etFirstEnroll.getText().toString();

                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute("add_info",subjectName,semesterName,totalCount,firstEnroll);

                /*SubjectObjectModel subjectinfo = new SubjectObjectModel(subjectName, Integer.parseInt(semesterName), Integer.parseInt(totalCount), firstEnroll);
                database.addSubject(subjectinfo);*/
                Toast.makeText(AddSubjectActivity.this,semesterName+"th_"+subjectName+"_"+totalCount+"_"+firstEnroll+" Class Created",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
