package com.example.ls_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button signIn;
    TextView signUp;
    int counter = 2;
    ArrayList<Users> users;
    boolean isValid;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MongoClientURI mongoUri  = new MongoClientURI("mongodb://3122Riki@gmail.com:Ri123@ds047692.mongolab.com:47692");
//        MongoClient mongoClient = new MongoClient(mongoUri);
//        DB db = mongoClient.getDB("LS_Task");
//        Set<String> collectionNames = db.getCollectionNames();

//        Realm.init(this);
//        String realmName = "LS_Task";
//        RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).build();
//        Realm backgroundThreadRealm = Realm.getInstance(config);

        setupUI();
        setupListener();
    }

    private void setupUI() {
        email = findViewById(R.id.emailId);
        password = findViewById(R.id.passwordId);
        signIn = findViewById(R.id.signInId);
        signUp = findViewById(R.id.linkToSignUpId);
        users = new ArrayList<Users>();
//        users = Users.users;
//        users.add(new Users(1,"Dan","Choen","123456@gmail.com","Gm123456"));
//        users.add(new Users(2,"Yael","Levi","12345678@gmail.com","Gm12345678"));
    }

    private void setupListener() {

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
//        field1.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void afterTextChanged(Editable s) {}
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start,
//                                          int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start,
//                                      int before, int count) {
//                if(s.length() != 0)
//                    field2.setText("");
//            }
//        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayEmployees();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });
    }

    private void displayEmployees() {
        flag = false;
        getUsers();
        String emailValue = email.getText().toString();
        String passwordValue = password.getText().toString();
        for (Users user:users) {
            if(user.getEmail().equals(emailValue) && user.getPassword().equals(passwordValue)) {
                flag = true;
                Intent i = new Intent(MainActivity.this, EmployeesActivity.class);
                startActivity(i);
            }
        }
        if(!flag){
            Toast t = Toast.makeText(this, "Wrong email or password",Toast.LENGTH_SHORT);
            t.show();
            disableButton();
        }
    }

    private void enableButton() {
        if (!isEmpty(email) && !isEmpty(password)){
            checkUserName();
            if (isValid) {
                signIn.setEnabled(true);
            }
        }
        else {
            disableButton();
        }
    }

    private void disableButton() {
        signIn.setEnabled(false);
    }

    private void checkUserName() {
        isValid = true;

        if(isEmpty(email)){
            email.setError("You must enter email to login!");
            isValid = false;
        }
        else {
            if (!isEmail(email)) {
                email.setError("Enter valid email!");
                isValid = false;
                disableButton();
            }
        }

        if(isEmpty(password)){
            password.setError("You must enter password to login!");
            isValid = false;
        }
        else {
            if (password.getText().toString().length() < 8) {
                password.setError("Password must be at least 8 characters!");
                isValid = false;
                disableButton();
            }
        }

//        if (isValid) {

//        }
//        else {
//            Toast t = Toast.makeText(this, "Wrong email or password",Toast.LENGTH_SHORT);
//            t.show();

//            counter--;
//            if (counter == 0) {
//                signIn.setEnabled(false);
//                Toast t = Toast.makeText(this, "Wrong email or password",Toast.LENGTH_SHORT);
//                t.show();
//                finish();
//            }
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

    private void getUsers() {
        users = Users.getInstance().users;


//        RequestQueue requestQueue;
//        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
//        Network network = new BasicNetwork(new HurlStack());
//        requestQueue = new RequestQueue(cache, network);
//        requestQueue.start();
//
//        String url ="http://10.0.2.2:3000/users";
//        JSONObject obj = new JSONObject();
//        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, null,
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
