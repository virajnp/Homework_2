package com.csuf.cpsc411.homework_2.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.csuf.cpsc411.homework_2.StudDetails;
import com.csuf.cpsc411.homework_2.R;
import com.csuf.cpsc411.homework_2.model.Student;
import java.util.ArrayList;

public class CustomList extends BaseAdapter {

    private final Context context;
    private ArrayList<Student> dataSet;


    public CustomList(ArrayList<Student> data , Context context) {
        this.context = context;
        dataSet = data;

    }

    static class ViewHolder {

        TextView fname,lname;
        LinearLayout ll_customlist;

    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (view == null) {
            view = inflater.inflate(R.layout.layout_customlist, null);
            holder = new ViewHolder();
            holder.fname = (TextView) view.findViewById(R.id.fname);
            holder.lname = (TextView) view.findViewById(R.id.lname);
            holder.ll_customlist = (LinearLayout) view.findViewById(R.id.ll_customlist);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.fname.setText(dataSet.get(position).getFirstName());
        holder.lname.setText(dataSet.get(position).getLastName());

        holder.ll_customlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), StudDetails.class);
                i.putExtra("cwid",dataSet.get(position).getCWID());
                i.putExtra("fname",dataSet.get(position).getFirstName());
                i.putExtra("lname",dataSet.get(position).getLastName());
                i.putExtra("pos",position);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        });

        return view;

    }
}
