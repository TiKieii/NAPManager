package com.tikeii.napmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class mng_staff extends AppCompatActivity {
    ArrayList<String> msnv, hoten, chucvu;
    nap_database db;
    mng_staff_list_adapter adapter;

    ImageButton btn_add,btn_back_btn_find;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mng_staff);
        RecyclerView recyclerView;
        btn_add = findViewById(R.id.mng_staff_list_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mng_staff.this, mng_add_staff.class);
                startActivity(i);
            }
        });


        db = new nap_database(this);
        msnv = new ArrayList<>();
        hoten = new ArrayList<>();
        chucvu = new ArrayList<>();
        recyclerView = findViewById(R.id.mng_staff_list_rcv);
        adapter = new mng_staff_list_adapter(this, msnv,hoten,chucvu);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaystaff();
        Cursor cursor = db.getdata_staff_stafflist();
        if(cursor.getCount()==0) {
            Toast.makeText(getApplicationContext(), "Không có dữ liệu hiển thị", Toast.LENGTH_LONG).show();
        }


    }

    private void displaystaff() {
        Cursor cursor = db.getdata_staff_stafflist();
        while (cursor.moveToNext()) {
            msnv.add(cursor.getString(1));
            hoten.add(cursor.getString(0));
            chucvu.add(cursor.getString(2));
        }
    }
}