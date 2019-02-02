package com.example.janvi.CreditManagament;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class User9 extends AppCompatActivity {

    DataBase db;
    EditText id,credit;
    String cr;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user9);
        db=new DataBase(this);
        id=(EditText)findViewById(R.id.id);
        credit=(EditText)findViewById(R.id.credit);
        textView=findViewById(R.id.textView);
        view();
    }
    public void view()
    {
        Cursor cursor=db.view("9");
        String info="";
        while (cursor.moveToNext())
        {
            String id=cursor.getString(0);
            String name=cursor.getString(1);
            String surname=cursor.getString(2);
            String credit=cursor.getString(3);
            cr=credit;
            info=info+"ID :"+id+"\nName :"+name+"\nSurname :"+surname+"\nCredit :"+credit;
        }
        textView.setText(info);
    }
    public  void transferCredit(View view)
    {
        int newcr=0,oldcr=0;
        newcr=Integer.parseInt(credit.getText().toString());
        oldcr=Integer.parseInt(cr);
        if(newcr>oldcr) {
            Toast.makeText(getApplicationContext(), "Enter valid credit", Toast.LENGTH_SHORT).show();

        }
        else {
            db.addCredit(id.getText().toString(), credit.getText().toString());
            db.subCredit("9", credit.getText().toString());
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
