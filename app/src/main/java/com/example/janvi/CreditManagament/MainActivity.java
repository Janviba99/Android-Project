package com.example.janvi.CreditManagament;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.janvi.CreditManagament.Adapters.MyAdapter;
import com.example.janvi.CreditManagament.Model.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBase mydb;
    ListView l1;
    ArrayList<Users> arrayList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1=(ListView) findViewById(R.id.listView);
        mydb=new DataBase(this);
        arrayList=new ArrayList<>();
        loadDataInListView();

    }
    private void loadDataInListView() {
        arrayList=mydb.getData();
        myAdapter=new MyAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
    public void user1(View view)
    {
        Intent intent=new Intent(this,User1.class);
        startActivity(intent);

    }
    public void user2(View view)
    {
        Intent intent=new Intent(this,User2.class);
        startActivity(intent);

    }
    public void user3(View view)
    {
        Intent intent=new Intent(this,User3.class);
        startActivity(intent);

    }
    public void user4(View view)
    {
        Intent intent=new Intent(this,User4.class);
        startActivity(intent);

    }
    public void user5(View view)
    {
        Intent intent=new Intent(this,User5.class);
        startActivity(intent);

    }
    public void user6(View view)
    {
        Intent intent=new Intent(this,User6.class);
        startActivity(intent);

    }
    public void user7(View view)
    {
        Intent intent=new Intent(this,User7.class);
        startActivity(intent);

    }
    public void user8(View view)
    {
        Intent intent=new Intent(this,User8.class);
        startActivity(intent);

    }
    public void user9(View view)
    {
        Intent intent=new Intent(this,User9.class);
        startActivity(intent);

    }
    public void user10(View view)
    {
        Intent intent=new Intent(this,User10.class);
        startActivity(intent);

    }
}
