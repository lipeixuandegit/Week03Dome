package com.example.administrator.week03dome.ui.music;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.week03dome.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.net.URL;

/**
 * Created by Administrator on 2018/5/26.
 */

public class MusciView extends LinearLayout {
    String Url="http://pic.sc.chinaz.com/files/pic/pic9/201205/xpic5086.jpg";
    private SimpleDraweeView img;
    private ObjectAnimator objectAnimator;


    public MusciView(Context context) {
        super(context);
    }

    public MusciView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.music_list, this);
        img = view.findViewById(R.id.img);

        img.setImageURI(Url);
    }

    public  void start(){
        objectAnimator = ObjectAnimator.ofFloat(img, View.ROTATION,0,360);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);

    }
    public void stop(){
        objectAnimator.end();
    }
}
