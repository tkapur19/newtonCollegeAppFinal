package com.example.tarunkapur.newtoncollegeapp;

/**
 * Created by tarunkapur on 31/12/17.
 */

public class StudentDetails {
    private int rollNo;
    private String studentName;
    private String phoneNo;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public StudentDetails(){

    }

    public StudentDetails(int rollNo, String studentName, String phoneNo) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.phoneNo = phoneNo;
    }

    public int getRollNo() {
        return rollNo;
    }


    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
