package com.tikeii.napmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class mng_staff_in4 extends AppCompatActivity {
    TextView hoten,manv,gioitinh,ngaysinh,sdt,diachi,ngaylamviec,luongcb, trinhdo,chucvu,phongban;

    Button back,xl,cc,del;
    nap_database db = new nap_database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mng_staff_in4);
        hoten = findViewById(R.id.staff_in4_name);
        manv = findViewById(R.id.staff_in4_MANV);
        gioitinh = findViewById(R.id.staff_in4_sex);
        ngaysinh = findViewById(R.id.staff_in4_date);
        sdt = findViewById(R.id.staff_in4_phone);
        diachi = findViewById(R.id.staff_in4_address);
        ngaylamviec = findViewById(R.id.staff_in4_workday);
        luongcb = findViewById(R.id.staff_in4_salary);
        trinhdo = findViewById(R.id.staff_in4_level);
        chucvu = findViewById(R.id.staff_in4_rank);
        phongban = findViewById(R.id.staff_in4_room);

        Intent i = getIntent();
        String id = i.getStringExtra("MANV_INPUT");

        Cursor cursor = db.getdata_staff_with_ID(id);
        while (cursor.moveToNext()) {
            hoten.setText(cursor.getString(0));
            manv.setText(cursor.getString(1));
            gioitinh.setText(cursor.getString(2));
            ngaysinh.setText(cursor.getString(3));
            sdt.setText(cursor.getString(4));
            diachi.setText(cursor.getString(5));
            ngaylamviec.setText(cursor.getString(6));
            chucvu.setText(cursor.getString(8));
            luongcb.setText(cursor.getString(7));
            phongban.setText(cursor.getString(9));
            trinhdo.setText(cursor.getString(10));

        }
    }

    private void del_dialog(String manv) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.mng_staff_del_dialog);
        dialog.setCanceledOnTouchOutside(false);
        nap_database db = new nap_database(this);

        Button yes,no;
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean kq = db.deleteNHANVIEN(manv);
                if (kq == true) {
                    Toast.makeText(getApplicationContext(),)
                }
            }
        });
    }

}