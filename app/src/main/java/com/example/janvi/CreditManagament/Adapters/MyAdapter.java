package com.example.janvi.CreditManagament.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.janvi.CreditManagament.Model.Users;
import com.example.janvi.CreditManagament.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Users> arrayList;
    public MyAdapter(Context context,ArrayList<Users> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.mylistview,null);
        TextView id=(TextView) convertView.findViewById(R.id.textinput);
        TextView name=(TextView) convertView.findViewById(R.id.name);
        TextView surname=(TextView) convertView.findViewById(R.id.surname);
        TextView cr=(TextView) convertView.findViewById(R.id.cr);

        Users users=arrayList.get(position);
        id.setText(users.getId());
        name.setText(users.getName());
        surname.setText(users.getSurname());
        cr.setText(users.getCr());
        return convertView;
    }
}
