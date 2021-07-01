package com.example.ls_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class AddEmployee extends AppCompatActivity {

    ImageView backButton;
    EditText firstName;
    EditText lastName;
    EditText phone;
    EditText address;
    EditText roll;
    Button addButton;
    boolean isValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        setupUI();
        setupListener();
    }

    private void setupListener() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        firstName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                enableButton();
            }
        });
        lastName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                enableButton();
            }
        });
        phone.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                enableButton();
            }
        });
        address.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                enableButton();
            }
        });
        roll.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                enableButton();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmployee(firstName.getText().toString(), lastName.getText().toString(), phone.getText().toString(), address.getText().toString(), roll.getText().toString());
                Intent i = new Intent(AddEmployee.this, EmployeesActivity.class);
                startActivity(i);
            }
        });
    }

    private void addNewEmployee(String firstName, String lastName, String phone, String address, String roll) {
        Employee employee = Employee.getInstance();
        employee.employees.add(new Employee(employee.employees.size()+1 ,firstName, lastName, phone, address, roll));


//        RequestQueue requestQueue;
//        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
//        Network network = new BasicNetwork(new HurlStack());
//        requestQueue = new RequestQueue(cache, network);
//        requestQueue.start();
//
//        String url ="http://10.0.2.2:3000/employee";
//        JSONObject obj = new JSONObject();
//        try {
//            obj.put("name", firstName + " " + lastName)
//                    .put("address", address)
//                    .put("phone", phone)
//                    .put("companyId", roll);
//                   // .put("picture", picture);
//                    .put("dateStart", Calendar.getInstance().getTime());
//                   // .put("employeeType", employeeType);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, obj,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        System.out.print(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // Handle error
//                        System.out.print(error);
//                    }
//                });
//        objectRequest.setRetryPolicy(new DefaultRetryPolicy(
//                5000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestQueue.add(objectRequest);
    }

    private void setupUI() {
        backButton = findViewById(R.id.backButtonId);
        firstName = findViewById(R.id.firstNameId);
        lastName = findViewById(R.id.lastNameId);
        address = findViewById(R.id.addressId);
        phone = findViewById(R.id.phoneId);
        roll = findViewById(R.id.rollId);
        addButton = findViewById(R.id.addId);
    }

    private void enableButton() {
        if (!isEmpty(firstName) && !isEmpty(lastName) && !isEmpty(address) && !isEmpty(phone) && !isEmpty(roll)){
            checkDataEntered();
            if (isValid) {
                addButton.setEnabled(true);
            }
        }
        else {
            disableButton();
        }
    }

    private void disableButton() {
        addButton.setEnabled(false);
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        isValid = true;

        if(isEmpty(firstName)){
            firstName.setError("The first name is required!");
            isValid = false;
        }
        if(isEmpty(lastName)){
            lastName.setError("The last name is required!");
            isValid = false;
        }
        if(isEmpty(address)){
            address.setError("The address is required!");
            isValid = false;
        }
        if(isEmpty(phone)){
            phone.setError("The phone is required!");
            isValid = false;
        }
        else if (phone.getText().toString().length() != 10) {
            phone.setError("The phone must be 10 numbers!");
            disableButton();
            isValid = false;
        }
        else if (!phone.getText().toString().matches("0[0-9]{9}")){
            phone.setError("The phone isn't valid!");
            disableButton();
            isValid = false;
        }


//        if (isValid) {
////            String emailValue = email.getText().toString();
////            String passwordValue = password.getText().toString();
//                Intent i = new Intent(SignUp.this, EmployeesActivity.class);
//                startActivity(i);
//                this.finish();
//        }
    }
}
