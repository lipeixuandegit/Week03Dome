package com.example.administrator.week03dome.net;

import com.example.administrator.week03dome.bean.SatinBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/5/26.
 */

public interface SatinApiService {

    @GET("satinApi?type=1&page=1")
    Observable<SatinBean> getSatin();
}
