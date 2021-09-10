package com.android.sadia.Project03;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "university_affiliation_table")
public class UniCluBzList {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String university_name;
    private String department;
    private int student_id;
    private String study_level ;
    private String email;
    private String tags;
    private int phone_numbers;


    public UniCluBzList(String university_name, String department, int student_id,
                        String study_level, String email, String tags, int phone_numbers)
    {
        this.university_name = university_name;
        this.department = department;
        this.student_id = student_id;
        this.study_level = study_level;
        this.email = email;
        this.tags = tags;
        this.phone_numbers = phone_numbers;
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

    public String getTags() {
        return tags;
    }

    public int getPhone_numbers() {
        return phone_numbers;
    }
}
