package com.example.ls_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUp extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    Button signUp;
    TextView signIn;
    EditText password;
    EditText verifiedPassword;
    boolean isValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setupUI();
        setupListener();
    }

    private void setupUI() {
        firstName = findViewById(R.id.firstNameId);
        lastName = findViewById(R.id.lastNameId);
        email = findViewById(R.id.emailId);
        signIn = findViewById(R.id.linkToSignInId);
        signUp = findViewById(R.id.signUpId);
        password = findViewById(R.id.passwordId);
        verifiedPassword = findViewById(R.id.verifiedPasswordId);
    }

    private void setupListener() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString());
                Intent i = new Intent(SignUp.this, EmployeesActivity.class);
                startActivity(i);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    isValidPassword(password);
                    if (isValidPassword(password) && !isEmpty(verifiedPassword) && !isEmpty(password)){
                        isVerifiedPassword(password);
                    }
                }
            }
        });

        verifiedPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    isValidPassword(verifiedPassword);
                    if (isValidPassword(verifiedPassword) && !isEmpty(password)  && !isEmpty(verifiedPassword)){
                        isVerifiedPassword(verifiedPassword);
                    }
                }
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
        email.addTextChangedListener(new TextWatcher() {

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
        password.addTextChangedListener(new TextWatcher() {

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
        verifiedPassword.addTextChangedListener(new TextWatcher() {

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
    }

    void checkDataEntered() {
        isValid = true;

        if(isEmpty(firstName)){
            firstName.setError("First name is required!");
            isValid = false;
        }
        if(isEmpty(lastName)){
            lastName.setError("Last name is required!");
            isValid = false;
        }
        if(isEmpty(email)){
            email.setError("You must enter email to sign up!");
            isValid = false;
        }
        else {
            if (!isEmail(email)) {
                email.setError("Enter valid email!");
                isValid = false;
                disableButton();
            }
        }

        isValidPassword(password);
        isValidPassword(verifiedPassword);
        isVerifiedPassword(password);


//        if (isValid) {
////            String emailValue = email.getText().toString();
////            String passwordValue = password.getText().toString();
//                Intent i = new Intent(SignUp.this, EmployeesActivity.class);
//                startActivity(i);
//                this.finish();
//        }
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isValidPassword(EditText currentPassword) {

//        Pattern pattern;
//        Matcher matcher;
//
//        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
//
//        pattern = Pattern.compile(PASSWORD_PATTERN);
//        matcher = pattern.matcher(password);
//
//        return matcher.matches();

//        String passwordVal = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)$";
//        Patterns patterns;
//        patterns = Patterns.compile(passwordVal);

        if(isEmpty(currentPassword)){
            currentPassword.setError("You must enter password to sign up!");
            return isValid = false;
        }
        else {
            if (currentPassword.getText().toString().length() < 8) {
                currentPassword.setError("Password must be at least 8 characters!");
                disableButton();
                return isValid = false;

            }
            else {
//                if(!passwordVal.matches(currentPassword.getText().toString())) {
////                if (!currentPassword.getText().toString().matches(passwordVal)){
//                    currentPassword.setError("The password is too weak");
//                    return isValid = false;
//                }
//                else return true;
                return true;
            }
        }
    }

    boolean isVerifiedPassword(EditText currentPassword){
        if (currentPassword.equals(password) && !verifiedPassword.getText().toString().equals(currentPassword.getText().toString())){
            verifiedPassword.setError("Please enter the same paswword in the two fields");
            disableButton();
            return isValid = false;
        }
        else if (currentPassword.equals(verifiedPassword) && !password.getText().toString().equals(currentPassword.getText().toString())) {
            password.setError("Please enter the same paswword in the two fields");
            disableButton();
            return isValid = false;
        }
        else return true;
    }

    private void enableButton() {
        if (!isEmpty(firstName) && !isEmpty(lastName) && !isEmpty(email) && !isEmpty(password) && !isEmpty(verifiedPassword)){
            checkDataEntered();
            if (isValid) {
                signUp.setEnabled(true);
            }
        }
        else {
            disableButton();
        }
    }

    private void disableButton() {
        signUp.setEnabled(false);
    }

    private void addNewUser(String firstName, String lastName, String email, String password) {
            Users users = Users.getInstance();
            users.users.add(new Users(users.users.size()+1 ,firstName,lastName,email,password));


//        RequestQueue requestQueue;
//        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
//        Network network = new BasicNetwork(new HurlStack());
//        requestQueue = new RequestQueue(cache, network);
//        requestQueue.start();
//
//        String url ="http://10.0.2.2:3000/users";
//        JSONObject obj = new JSONObject();
//        try {
//            obj.put("firstName", firstName)
//                    .put("lastName", lastName)
//                    .put("email", email)
//                    .put("password", password);
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
}
