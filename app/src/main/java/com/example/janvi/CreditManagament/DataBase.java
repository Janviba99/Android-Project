package com.example.janvi.CreditManagament;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.janvi.CreditManagament.Model.Users;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    public static final String Database_name="credit.db";
    public static final String Table_Name="user_table";
    public static final String col1="ID";
    public static final String col2="Name";
    public static final String col3="Surname";
    public static final String col4="Current_Credit";
    public DataBase(Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table_Name+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Surname TEXT,Current_Credit INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+Table_Name);

    }

    public boolean insert(String s1,String s2,int cr)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",s1);
        contentValues.put("Surname",s2);
        contentValues.put("Current_Credit",cr);
        long result=db.insert(Table_Name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    //list view
    public ArrayList<Users> getData()
    {
        ArrayList<Users> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * from "+Table_Name,null);
        while (cursor.moveToNext())
        {
            String ID=cursor.getString(0);
            String Name=cursor.getString(1);
            String Surname=cursor.getString(2);
            String cr=cursor.getString(3);
            Users users=new Users(ID,Name,Surname,cr);
            arrayList.add(users);
        }
        return arrayList;
    }
    public void addCredit(String id, String cr)
    {

        int temp=0,temp_cr=0;
        SQLiteDatabase db=this.getWritableDatabase();
        SQLiteDatabase mydb=this.getReadableDatabase();
        Cursor cursor=mydb.rawQuery("select Current_Credit from "+Table_Name+" where ID='"+id+"'", null);
        while (cursor.moveToNext())
            temp=Integer.parseInt(cursor.getString(0));
        temp_cr=Integer.parseInt(cr);
        temp_cr=temp_cr+temp;
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID",id);
        contentValues.put("Current_Credit",temp_cr);
        db.update(Table_Name,contentValues,"ID=?",new String[]{String.valueOf(id)});

    }

    //subtract credit in data
    public void subCredit(String id,String cr)
    {
        int temp=0,temp_cr=0;
        SQLiteDatabase db=this.getWritableDatabase();
        SQLiteDatabase mydb=this.getReadableDatabase();
        Cursor cursor=mydb.rawQuery("select Current_Credit from "+Table_Name+" where ID='"+id+"'",null);
        while (cursor.moveToNext())
            temp=Integer.parseInt(cursor.getString(0));
        temp_cr=Integer.parseInt(cr);
        temp=temp-temp_cr;
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID",id);
        contentValues.put("Current_Credit",temp);
        db.update(Table_Name,contentValues,"ID=?",new String[]{id});
    }

    //view data in textview
    public Cursor view(String id)
    {
        SQLiteDatabase mydb=this.getReadableDatabase();
        Cursor cursor=mydb.rawQuery("select * from "+Table_Name+" where ID='"+id+"'",null);
        return cursor;
    }
    /* simple update the data
    public void update(String id,String cr)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID",id);
        contentValues.put("Current_Credit",cr);
        db.update(Table_Name,contentValues,"ID=?",new String[]{id});
    }*/
}

