package com.example.tarunkapur.newtoncollegeapp;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tarunkapur on 07/01/18.
 */

public class AssignmentTestAdapter extends RecyclerView.Adapter<AssignmentTestAdapter.viewHolder> {
    private List<AssignmentTestModel> assignmentTestModelList;
    private Context context;

    public AssignmentTestAdapter(List<AssignmentTestModel> assignmentTestModelList, Context context) {
        this.assignmentTestModelList = assignmentTestModelList;
        this.context = context;
    }

    @Override
    public AssignmentTestAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_test_result,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(AssignmentTestAdapter.viewHolder holder, int position) {
        final AssignmentTestModel assignmentTestModel=assignmentTestModelList.get(position);
        holder.mainHead.setText(assignmentTestModel.getHeading());
        holder.assignmentDate.setText(assignmentTestModel.getDate());
        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager downloadManager=(DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
                Uri uri= Uri.parse(assignmentTestModel.getUrl());
                DownloadManager.Request request= new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long refrence=downloadManager.enqueue(request);
            }
        });


    }

    @Override
    public int getItemCount() {
        return assignmentTestModelList.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{

        private TextView mainHead;
        private TextView assignmentDate;
        private Button download;


        public viewHolder(View itemView) {


            super(itemView);
            mainHead=(TextView) itemView.findViewById(R.id.mainHead);
            assignmentDate=(TextView) itemView.findViewById(R.id.resultDate);
            download=(Button) itemView.findViewById(R.id.download_button);
        }
    }
}
