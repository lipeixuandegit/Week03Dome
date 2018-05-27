package com.example.administrator.week03dome.ui.satin.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.administrator.week03dome.R;
import com.example.administrator.week03dome.bean.SatinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/26.
 */

public class SatinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SatinBean.DataBean> list;
    private LayoutInflater inflater;
    private int Inters=0;
    private int THREAD=1;

    public SatinAdapter(Context context, List<SatinBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;

        if (viewType==Inters) {
            View view = inflater.inflate(R.layout.item1, parent, false);
            holder= new SatinViewHolder1(view);
        }else if (viewType==THREAD){
            View view = inflater.inflate(R.layout.item2, parent, false);
            holder= new SatinViewHolder2(view);

        }else {
            return null;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final SatinBean.DataBean dataBean = list.get(position);
        if (getItemViewType(position)==Inters) {
            final SatinViewHolder1 satinViewHolder1 = (SatinViewHolder1) holder;
            satinViewHolder1.img.setImageURI(dataBean.getProfile_image());
            satinViewHolder1.tv1.setText(dataBean.getText());
            satinViewHolder1.tv2.setText(dataBean.getPasstime());
            satinViewHolder1.video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        satinViewHolder1.video.setVideoURI(Uri.parse(dataBean.getVideouri()));
                        satinViewHolder1.video.start();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });



        }else {
            SatinViewHolder2 satinViewHolder2 = (SatinViewHolder2) holder;
            String profile_image = dataBean.getProfile_image();
            satinViewHolder2.img.setImageURI(profile_image);
            satinViewHolder2.tv1.setText(dataBean.getText());
        }





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class SatinViewHolder1 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView tv1;
        private final TextView tv2;
        private final VideoView video;

        public SatinViewHolder1(View view) {
            super(view);
            img = view.findViewById(R.id.img);
            tv1 = view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            video = view.findViewById(R.id.video);



        }
    }

    private class SatinViewHolder2 extends RecyclerView.ViewHolder {
        private final SimpleDraweeView img;
        private final TextView tv1;
        public SatinViewHolder2(View view) {
            super(view);
            img = view.findViewById(R.id.img);
            tv1 = view.findViewById(R.id.tv1);
        }
    }
    public int getItemViewType(int position){
        if (position%2==0){
            return Inters;
        }else {
            return THREAD;
        }
    }
}
