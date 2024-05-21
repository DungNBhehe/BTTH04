package com.example.qlisinhvien;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtmalop,edttenlop,edtsiso;
    Button BtnNhap, BtnXoa, BtnCapnhat, BtnDulieu;
    ListView lv;
    ArrayList myList;
    ArrayAdapter myAdapter;
    SQLiteDatabase myDatabase;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtmalop = findViewById(R.id.edtMalop);
        edttenlop = findViewById(R.id.edtTenlop);
        edtsiso = findViewById(R.id.edtSiso);
        BtnNhap = findViewById(R.id.BtnNhap);
        BtnXoa = findViewById(R.id.BtnXoa);
        BtnCapnhat = findViewById(R.id.BtnCapnhat);
        BtnDulieu = findViewById(R.id.BtnDulieu);
        //Tạo listview
        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myList);
        lv.setAdapter(myAdapter);
        //Tạo và mở csdl
        myDatabase = openOrCreateDatabase("qlisinhvien.db",MODE_PRIVATE,null);



        });
    }
}