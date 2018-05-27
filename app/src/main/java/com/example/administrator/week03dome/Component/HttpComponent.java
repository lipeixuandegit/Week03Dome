package com.example.administrator.week03dome.Component;

import com.example.administrator.week03dome.Module.HttpModule;
import com.example.administrator.week03dome.ui.satin.SatinActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/26.
 */
@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(SatinActivity satinActivity);

}
