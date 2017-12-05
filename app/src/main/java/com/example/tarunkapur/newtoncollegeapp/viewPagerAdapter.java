package com.example.tarunkapur.newtoncollegeapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by tarunkapur on 06/12/17.
 */

public class viewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private int  images[]={R.drawable.newtoncover,R.drawable.newtonregistration,R.drawable.newtoncouncil};
    @Override
    public int getCount() {
        return images.length;
    }

    public viewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        ViewPager viewPager=(ViewPager) container;

        viewPager.addView(view,0);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager=(ViewPager) container;
        View view=(View) object;

        viewPager.removeView(view);
    }
}
