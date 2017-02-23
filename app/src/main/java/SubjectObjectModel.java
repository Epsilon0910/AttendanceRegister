package com.firstproject.minorproject.attendancemanager;

/**
 * Created by Charchit Joshi on 21-02-2017.
 */

public class SubjectObjectModel {

    int id;
    String subjectName;
    int semester;
    int totalCount;
    String firstEnroll;

    public SubjectObjectModel(int id, String subjectName, int semester, int totalCount, String firstEnroll) {
        this.id = id;
        this.subjectName = subjectName;
        this.semester = semester;
        this.totalCount = totalCount;
        this.firstEnroll = firstEnroll;
    }

    public SubjectObjectModel() {
    }

    public SubjectObjectModel(String subjectName, int semester, int totalCount, String firstEnroll) {
        this.firstEnroll = firstEnroll;
        this.semester = semester;
        this.totalCount = totalCount;
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getFirstEnroll() {
        return firstEnroll;
    }

    public void setFirstEnroll(String firstEnroll) {
        this.firstEnroll = firstEnroll;
    }
}
