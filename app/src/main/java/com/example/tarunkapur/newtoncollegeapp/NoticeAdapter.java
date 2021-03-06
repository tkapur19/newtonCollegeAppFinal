package com.example.tarunkapur.newtoncollegeapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tarunkapur on 05/12/17.
 */

/*
Adapter class for Main Notice Board on the parent/Lanch Activity.
 */

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.viewHolder> {

    private List<listOfNotice> myList;
    String TAG="myMessage";

    public NoticeAdapter(List<listOfNotice> myList) {
        this.myList = myList;

    }

    @Override
    public NoticeAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(NoticeAdapter.viewHolder holder, int position) {

        listOfNotice listOfNotice=myList.get(position);
        holder.mainText.setText(listOfNotice.getNotice());
        holder.dateText.setText(listOfNotice.getDate());
        Log.i(TAG, "onBindViewHolder: yes");





    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private TextView mainText;
        private TextView dateText;

        public viewHolder(View itemView) {
            super(itemView);
            mainText=(TextView) itemView.findViewById(R.id.mainNotice);
            dateText=(TextView) itemView.findViewById(R.id.noticeDate);
        }
    }
}