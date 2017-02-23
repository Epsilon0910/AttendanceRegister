package com.firstproject.minorproject.attendancemanager;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SubjectsList extends AppCompatActivity {

    /*ListView subjectListView;
    List<SubjectObjectModel> subjectModelList;
    ArrayList<String> arrayList;
    ArrayAdapter<SubjectObjectModel> arrayAdapter;*/
    DatabaseHandler database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = new DatabaseHandler(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_list);
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_info");
        /*subjectListView = (ListView) findViewById(R.id.subject_list);
        subjectModelList = database.getAllSubjects();
        Log.d("SubjectList",subjectModelList.size()+"");
        arrayAdapter = new ArrayAdapter<SubjectObjectModel>(SubjectsList.this,android.R.layout.simple_list_item_1,subjectModelList);
        subjectListView.setAdapter(arrayAdapter);


        subjectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SubjectsList.this,(position+1)+"selected",Toast.LENGTH_SHORT).show();
                //SubjectObjectModel subjectObjectModel = subjectModelList.get(position);

            }
        });*/
    }


}
