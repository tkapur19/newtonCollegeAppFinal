package com.example.tarunkapur.newtoncollegeapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tarunkapur on 09/01/18.
 */

public class SubGalleryAdapter extends RecyclerView.Adapter<SubGalleryAdapter.viewHolder> {
    private List<SubMyImage> imageList;
    private Context context;

    public SubGalleryAdapter(List<SubMyImage> imageList, Context context) {
        this.imageList = imageList;
        this.context=context;

    }

    @Override
    public SubGalleryAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_gallery_card_view,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(SubGalleryAdapter.viewHolder holder, int position) {
        final SubMyImage myImage=imageList.get(position);
        Picasso.with(context).load(myImage.getPhotoUrl()).resize(200,200).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ImageViewer.class);
                intent.putExtra("photoUrl",myImage.getPhotoUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        Log.i("myMessage", "onBindViewHolder: ");


    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public viewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.sGalleryImage);
        }
    }
}

