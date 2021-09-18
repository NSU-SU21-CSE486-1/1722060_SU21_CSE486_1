package com.android.sadia.uniclubz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private FirebaseAuth mAuth;

    private EditText nameEditText;
    private EditText dobEditText;
    private EditText nidEditText;
    private EditText bloodGroupEditText;
    private Spinner uniNameEditText;
    private Spinner departmentEditText;
    private EditText studentIdEditText;
    private Spinner studyLevelEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText passwordEditText;
    DatePickerDialog.OnDateSetListener setListener;

    private TextView login;
    private Button singUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        nameEditText = findViewById(R.id.input_name);
        dobEditText = findViewById(R.id.input_DoB);
        nidEditText = findViewById(R.id.input_NID);
        bloodGroupEditText = findViewById(R.id.input_blood_group);
        emailEditText = findViewById(R.id.input_email);
        phoneEditText= findViewById(R.id.input_phone);
        studentIdEditText = findViewById(R.id.input_student_id);
        passwordEditText = findViewById(R.id.input_password);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dobEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        SignupActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        dobEditText.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });



        uniNameEditText = findViewById(R.id.spinner_university);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.university_list, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        uniNameEditText.setAdapter(adapter1);
        uniNameEditText.setOnItemSelectedListener(this);

        departmentEditText = findViewById(R.id.spinner_department);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.department_list, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentEditText.setAdapter(adapter2);
        departmentEditText.setOnItemSelectedListener(this);



        studyLevelEditText = findViewById(R.id.spinner_study_level);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.study_level_list, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studyLevelEditText.setAdapter(adapter3);
        studyLevelEditText.setOnItemSelectedListener(this);

        login = findViewById(R.id.log_in);
        login.setOnClickListener(this);

        singUpButton = findViewById(R.id.signup_button);
        singUpButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.log_in:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.signup_button:
                registerUser();
                break;
        }

    }

    private void registerUser() {
        String name= nameEditText.getText().toString().trim();
        String dateOfBirth = dobEditText.getText().toString().trim();
        String nidNumber = nidEditText.getText().toString().trim();
        String bloodGroup = bloodGroupEditText.getText().toString().trim();
        String universityName = uniNameEditText.getSelectedItem().toString().trim();
        String departmentName = departmentEditText.getSelectedItem().toString().trim();
        String studentId = studentIdEditText.getText().toString().trim();
        String studyLevel = studyLevelEditText.getSelectedItem().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phoneNumber = phoneEditText.getText().toString().trim();
        String pass = passwordEditText.getText().toString().trim();

        if(name.isEmpty()){
            nameEditText.setError("Name Required!");
            nameEditText.requestFocus();
            return;
        }

        if(dateOfBirth.isEmpty()){
            dobEditText.setError("Date of Birth Required!");
            dobEditText.requestFocus();
            return;
        }
        if(nidNumber.isEmpty()){
            nidEditText.setError("NID Number Required!");
            nidEditText.requestFocus();
            return;
        }
        if(bloodGroup.isEmpty()){
            bloodGroupEditText.setError("Blood Group Required!");
            bloodGroupEditText.requestFocus();
            return;
        }

        if(studentId.isEmpty()){
            studentIdEditText.setError("Student ID Required!");
            studentIdEditText.requestFocus();
            return;
        }

        if(email.isEmpty()){
            emailEditText.setError("Email Address Required!");
            emailEditText.requestFocus();
            return;
        }
        if(phoneNumber.isEmpty()){
            phoneEditText.setError("Phone Number Required!");
            phoneEditText.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            passwordEditText.setError("Password Required!");
            passwordEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please Provide Valid Email");
            emailEditText.requestFocus();
            return;
        }
        if(pass.length() < 6){
            passwordEditText.setError("Password Cannot be Less than 6 Characters");
            passwordEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(name, dateOfBirth, nidNumber, bloodGroup, universityName,
                             departmentName, studentId, studyLevel, email, phoneNumber);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast toast = Toast.makeText(SignupActivity.this,
                                                "User Register Successful!", Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                    else{
                                        Toast toast = Toast.makeText(SignupActivity.this,
                                                "User Register Unsuccessful", Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                }
                            });

                        }else{
                            Toast toast = Toast.makeText(SignupActivity.this,
                                    "User Register Unsuccessful", Toast.LENGTH_LONG);
                            toast.show();
                        }


                    }
                });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}