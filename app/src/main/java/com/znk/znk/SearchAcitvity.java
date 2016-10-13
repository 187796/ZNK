package com.znk.znk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Krystian on 2016-10-09.
 */
public class SearchAcitvity extends Activity {


    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter<String> adapter ;
    private ArrayList<String> employeesList;
    private TextView employee;
    private Intent intentSingleEmployee;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_screen_activity);

        searchView = (SearchView) findViewById(R.id.searchViewWidget);
        listView = (ListView) findViewById(R.id.searchListView);

        final String employees[] = {"Jerzy Dokimuk", "Dominik Sankowski", "PPerek", "Radosław Adamus", "MarKras"};


        employeesList = new ArrayList<String>();
        employeesList.addAll( Arrays.asList(employees) );

        adapter = new ArrayAdapter<String>(this,R.layout.single_employee, employeesList);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                intentSingleEmployee = new Intent(getApplicationContext(), SingleEmployeeActivity.class);
                intentSingleEmployee.putExtra("name",employeesList.get(position));
                startActivity(intentSingleEmployee);
            }
        });


        //***setOnQueryTextListener***
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                employeesList.clear();
                for(String employee:employees){
                    if(employee.toLowerCase().contains(query.toLowerCase())){
                        employeesList.add(employee);
                    }
                }

                return false;
            }


            @Override
            public boolean onQueryTextChange(String query) {


                if(query.isEmpty()){
                    employeesList.clear();
                    employeesList.addAll( Arrays.asList(employees) );
                }else {
                    for(String employee:employees){
                        if(employee.toLowerCase().contains(query.toLowerCase())){
                            employeesList.add(employee);
                        }
                    }
                }

                return true;
            }

        });



    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        searchView.setQuery("",false);
        searchView.setIconified(true);
    }
}

