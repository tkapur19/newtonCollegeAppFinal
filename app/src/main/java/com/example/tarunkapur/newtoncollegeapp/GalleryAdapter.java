package com.example.tarunkapur.newtoncollegeapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by tarunkapur on 08/01/18.
 */

/*
        Adapter class for loading images of main newtonGalley.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.viewHolder> {
    private List<MyImage> imageList;
    private Context context;

    public GalleryAdapter(List<MyImage> imageList, Context context) {
        this.imageList = imageList;
        this.context=context;

    }

    @Override
    public GalleryAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card_view,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.viewHolder holder, int position) {
        final MyImage myImage=imageList.get(position);
        holder.textView.setText(myImage.getPhotoName());
        Picasso.with(context).load(myImage.getPhotoUrl()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,SubGallery.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);




                intent.putExtra("myMessage",myImage.getPhotoName());
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
        private TextView textView;

        public viewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.gallery_Image);
            textView=(TextView) itemView.findViewById(R.id.image_name);
        }
    }
}

