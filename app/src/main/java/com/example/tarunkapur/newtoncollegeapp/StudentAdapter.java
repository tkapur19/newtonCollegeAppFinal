package com.example.tarunkapur.newtoncollegeapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarunkapur on 31/12/17.
 */

/*
Adapter for RecyclerView of enrolled students in a particular batch
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.viewHolder> {
    private List<StudentDetails> list=new ArrayList<>();
    private Context context;

    public StudentAdapter(List<StudentDetails> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_details,parent,false);
        return new viewHolder(v);

    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        final StudentDetails studentDetails=list.get(position);
        holder.studentName.setText(studentDetails.getStudentName());
        holder.rollNo.setText(String .valueOf(studentDetails.getRollNo()));


        //in some cases, it will prevent unwanted situations
        holder.presentMark.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        holder.presentMark.setChecked(studentDetails.isSelected());

        holder.presentMark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                studentDetails.setSelected(isChecked);
                Log.i("myMessage", "onCheckedChanged: ");
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView rollNo;
        private TextView studentName;
        private CheckBox presentMark;
        public viewHolder(View itemView) {
            super(itemView);
            rollNo=(TextView) itemView.findViewById(R.id.roll_number);
            studentName=(TextView) itemView.findViewById(R.id.student_name);
            presentMark=(CheckBox) itemView.findViewById(R.id.present_mark);
        }
    }
    public List<StudentDetails> getAbsenteeList() {
        List<StudentDetails> absenteeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected() == false) {
                absenteeList.add(list.get(i));
                Log.i("myMessage", "getAbsenteeList: ");
            }
        }
        return absenteeList;
    }
}
