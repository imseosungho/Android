package com.example.shseo.listviewexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

public class EpgAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<EpgItem> arrayList;
    private LayoutInflater inflater;

    public EpgAdapter(Context context,ArrayList<EpgItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public EpgItem getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        EpgItem epg = arrayList.get(position);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.chnnelName);
        TextView numberTextView = (TextView) convertView.findViewById(R.id.chnnelNumber);

        nameTextView.setText(epg.getChannelName());
        numberTextView.setText(epg.getChannelNumber());

        Log.d("test","channel name : "+epg.getChannelName()+" , number : "+epg.getChannelNumber());

        return convertView;
    }
    /*

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mIcon = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mChannelName = (TextView) convertView.findViewById(R.id.textView);
            mViewHolder.mChannelNumber = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        //mViewHolder.mFlag.setImageResource(flags[position]);
        mViewHolder.mChannelName.setText(this.channelName);
        mViewHolder.mChannelNumber.setText(this.channelNumber);

        return convertView;
    }

    static class ViewHolder{
        ImageView mIcon;
        TextView mChannelName;
        TextView mChannelNumber;
    }
    */
};