package com.android.sadia.Project03;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "university_affiliation_table")
public class UniversityAffiliationList {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String university_name;
    private String department;
    private int student_id;
    private String study_level ;
    private String email;


    public UniversityAffiliationList(String university_name, String department,
                                     int student_id, String study_level, String email) {
        this.university_name = university_name;
        this.department = department;
        this.student_id = student_id;
        this.study_level = study_level;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public String getDepartment() {
        return department;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getStudy_level() {
        return study_level;
    }

    public String getEmail() {
        return email;
    }
}
