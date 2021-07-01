package com.example.ls_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;


public class EmployeesActivity extends AppCompatActivity {
    ArrayList<Employee> employees;
//    ArrayList<Object> employeesObject;
    TextView textView1;
    ListView simpleList;
    ImageView backButton;
    ImageButton plusButton;
//    String url;
//    EventDelegate eventDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        setupUI();
        setupListener();
//        eventDelegate = new EventDelegate();
//        simpleList = (ListView) findViewById(R.id.simpleListView);
//        Employee.getEmployees(ListView simpleList);
        getEmployees();
    }

    private void setupListener() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EmployeesActivity.this, AddEmployee.class);
                startActivity(i);
            }
        });
    }

    private void setupUI() {
        simpleList = (ListView) findViewById(R.id.simpleListView);
        backButton = findViewById(R.id.backButtonId);
        plusButton = findViewById(R.id.plusIconId);
    }

    void getEmployees(){

//        url = "http://10.0.2.2:3000/employees";
//        eventDelegate.getHttp(url);
        Employee employee = Employee.getInstance();
        employees = employee.employees;
        EmployeeAdapter customAdapter = new EmployeeAdapter(getApplicationContext(), employees);
        simpleList.setAdapter(customAdapter);

//        RequestQueue requestQueue;
//        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
//        Network network = new BasicNetwork(new HurlStack());
//        requestQueue = new RequestQueue(cache, network);
//        requestQueue.start();
//
//        String url ="http://10.0.2.2:3000/employees";
//        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
////                        JSONObject employeesJson = response;
//                        employees = new ArrayList<Employee>();
//                        JSONArray employeesArray = new JSONArray();
//                        for (int i = 0; i < employeesArray.length(); i++) {
//                            employees.add(employeesArray.getJSONArray(i));
//                        }
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
