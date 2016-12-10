package com.example.qosmio.todo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.qosmio.todo.Models.todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<todo> todoList = new ArrayList<todo>();
    public ListView lv;
    public static customList cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = new customList(this,R.layout.singletodo,todoList);


      lv = (ListView) findViewById(R.id.todo_list);

        lv.setAdapter(cl);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                todoList.remove(i);
                cl.notifyDataSetChanged();
            }
        });




    }


    public void addTodo(View v){

       customDialog dialog = new customDialog();


        dialog.show(getSupportFragmentManager(),"my_dialog");
    }
}
