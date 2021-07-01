package com.example.ls_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflter;
    ArrayList<Employee> employees;

    public EmployeeAdapter(Context applicationContext, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }
//
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_view_employees, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageProfilId);
        TextView name = (TextView) view.findViewById(R.id.nameId);
        TextView companyName = (TextView) view.findViewById(R.id.rollId);
        TextView dateStart = (TextView) view.findViewById(R.id.dateStartId);
        TextView phone = (TextView) view.findViewById(R.id.phoneId);
        TextView address = (TextView) view.findViewById(R.id.addressId);
//        icon.setImageResource(employees.get(i).getPicture());
        name.setText(employees.get(i).getName());
        companyName.setText(employees.get(i).getCompanyId());
//        dateStart.setText(employees.get(i).getDateStart());
        phone.setText(employees.get(i).getPhone());
        address.setText(employees.get(i).getAddress());


        return view;
    }
}