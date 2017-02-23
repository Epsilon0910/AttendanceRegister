package com.firstproject.minorproject.attendancemanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charchit Joshi on 21-02-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private  static final int DATABASE_VERSION = 6;
    private static  final String DATABASE_NAME = "database";

    //table names
    private static final String TABLE_SUBJECT_LIST = "subject_list_table";

    //subject list table column names
    private static final String S_ID = "s_id";
    private static final String S_NAME = "s_name";
    private static final String S_SEMESTER = "s_SEMESTER";
    private static final String S_STUDENT_COUNT = "s_student_count";
    private static final String S_STARTING_NUMBER = "s_starting_number";

    //create subject table
    String CREATE_SUBJECT_TABLE = "CREATE TABLE "
            +TABLE_SUBJECT_LIST
            + "("
            + S_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + S_NAME
            + " TEXT,"
            + S_SEMESTER
            + " int,"
            + S_STUDENT_COUNT
            + " int,"
            + S_STARTING_NUMBER
            + " TEXT"
            + ")";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        Log.d("Database Operations", "Database Created...");
    }

    /* here we need to write create table statements.
    This is called when database is created.*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SUBJECT_TABLE);
        Log.d("Database Operation", "Table Created...");
    }

    /* This method is called when database is upgraded
    like modifying the table structure, adding constraints to database etc.,*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_SUBJECT_LIST);

        //CREATE TABLE AGAIN
        onCreate(db);
    }

    //Add new subjects to subject_table
    public void addSubject(SubjectObjectModel subjectModel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();

        value.put(S_NAME, subjectModel.getSubjectName());
        value.put(S_SEMESTER, subjectModel.getSemester());
        value.put(S_STUDENT_COUNT, subjectModel.getTotalCount());
        value.put(S_STARTING_NUMBER, subjectModel.getFirstEnroll());

        //Inserting Row
        db.insert(TABLE_SUBJECT_LIST, null, value);
        Log.d("Database Operation", "One Row Inserted");
        db.close();
    }

    //Getting single subject from table
    public  SubjectObjectModel getSubject(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SUBJECT_LIST, new String[]{
                S_ID, S_NAME, S_SEMESTER, S_STUDENT_COUNT, S_STARTING_NUMBER
        }, S_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);

        if(cursor != null) cursor.moveToFirst();

        SubjectObjectModel subjectModel =
                new SubjectObjectModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                        Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4));

        //return object model
        return subjectModel;
        }

    //Getting All subjects from table
    /*public List<SubjectObjectModel> getAllSubjects() {
        List<SubjectObjectModel> subjectList = new ArrayList<SubjectObjectModel>();

        //select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SUBJECT_LIST;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all rows and adding to list
        if (cursor.moveToFirst()){
            do{
                SubjectObjectModel subjectObjectModel = new SubjectObjectModel();
                subjectObjectModel.setId(Integer.parseInt(cursor.getString(0)));
                subjectObjectModel.setSubjectName(cursor.getString(1));
                subjectObjectModel.setSemester(Integer.parseInt(cursor.getString(2)));
                subjectObjectModel.setTotalCount(Integer.parseInt(cursor.getString(3)));
                subjectObjectModel.setFirstEnroll(cursor.getString(3));

                //Adding subject to list
                subjectList.add(subjectObjectModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        //return subject list;
        return subjectList;
    }*/

    //Another method to retrive all subjects name from database
    public Cursor getAllSubjects(SQLiteDatabase db)
    {

        String[] projections = {S_ID, S_NAME, S_SEMESTER, S_STUDENT_COUNT, S_STARTING_NUMBER};
        Cursor cursor = db.query(TABLE_SUBJECT_LIST,projections,null, null, null, null, null);

        return cursor;
    }


    //Delete subject
    public void deleteSubject(SubjectObjectModel objectModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SUBJECT_LIST, S_ID + " = ?",
                new String[] { String.valueOf(objectModel.getId())});
        db.close();
    }
}