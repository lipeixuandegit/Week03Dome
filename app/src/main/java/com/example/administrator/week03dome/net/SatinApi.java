package com.example.administrator.week03dome.net;

import com.example.administrator.week03dome.bean.SatinBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/5/26.
 */

public class SatinApi {
    private static  SatinApi satinApi;
    private SatinApiService satinApiService;

    public SatinApi(SatinApiService satinApiService) {
        this.satinApiService = satinApiService;
    }
    public static SatinApi getSatinApi(SatinApiService satinApiService){

        if (satinApi==null){
            satinApi=new SatinApi(satinApiService);
        }
        return satinApi;
    }
    public Observable<SatinBean> getSatin(){
        return satinApiService.getSatin();
    }
}
