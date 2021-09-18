package com.android.sadia.uniclubz;

public class User {
    public String name;
    public String dateOfBirth;
    public String nidNumber ;
    public String bloodGroup;
    public String universityName;
    public String departmentName;
    public String studentId;
    public String studyLevel;
    public String email;
    public String phoneNumber;

    public User(){

    }


    public User(String name, String dateOfBirth, String nidNumber, String bloodGroup,
                String universityName, String departmentName, String studentId, String studyLevel,
                String email, String phoneNumber) {

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nidNumber = nidNumber;
        this.bloodGroup = bloodGroup;
        this.universityName = universityName;
        this.departmentName = departmentName;
        this.studentId = studentId;
        this.studyLevel = studyLevel;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
