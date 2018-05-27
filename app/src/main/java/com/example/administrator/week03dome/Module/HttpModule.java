package com.example.administrator.week03dome.Module;

import com.example.administrator.week03dome.net.Api;
import com.example.administrator.week03dome.net.SatinApi;
import com.example.administrator.week03dome.net.SatinApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/26.
 */
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder providesOkhttpClientBuilder(){
        return new OkHttpClient.Builder()
                .writeTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS);
    }
    @Provides
    SatinApi provideSatinApi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        SatinApiService satinApiService = retrofit.create(SatinApiService.class);
        return SatinApi.getSatinApi(satinApiService);
    }

}
