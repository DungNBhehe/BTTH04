package com.example.qlisinhvien;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
        //Tạo table
        try
        {
                String sql = "CREATE TABLE tblop(malop TEXT primary key , tenlop TEXT, siso INTEGER)";
                myDatabase.execSQL(sql);
        }
        catch (Exception e) {
            Log.e("Error", "Table đã tồn tại");
        }
        BtnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtmalop.getText().toString();
                String tenlop = edttenlop.getText().toString();
                int siso = Integer.parseInt(edtsiso.getText().toString());
                ContentValues myvalue= new ContentValues();
                myvalue.put("malop",malop);
                myvalue.put("tenlop",tenlop);
                myvalue.put("siso",siso);
                String msg = "";
                if (myDatabase.insert("tblop",null,myvalue)==-1)
                {
                    msg = "Lỗi nhập";
                }
                else
                {
                    msg= "Nhập thành công";
                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        BtnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtmalop.getText().toString();
                int n = myDatabase.delete("tblop", "malop = ?", new String[]{malop});
                String msg = "";
                if (n == 0) {
                    msg = "Không có bản ghi nào xóa";
                } else {
                    msg = "Xóa thành công";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        BtnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int siso = Integer.parseInt(edtsiso.getText().toString());
                String malop = edtmalop.getText().toString();
                ContentValues myvalue = new ContentValues();
                myvalue.put("siso",siso);
                int n = myDatabase.update("tblop",myvalue,"malop = ?",new String[] {malop} );
                String msg = "";
                if (n ==0)
                {
                    msg = "Không có bản ghi nào cập nhật";
                }
                else {
                    msg = "Cập nhật thành công";
                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        BtnDulieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}