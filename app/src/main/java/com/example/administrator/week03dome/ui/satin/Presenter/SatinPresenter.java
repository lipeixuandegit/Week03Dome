package com.example.administrator.week03dome.ui.satin.Presenter;

import com.example.administrator.week03dome.bean.SatinBean;
import com.example.administrator.week03dome.net.SatinApi;
import com.example.administrator.week03dome.ui.base.BasePresenter;
import com.example.administrator.week03dome.ui.satin.Contract.SatinContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/26.
 */

public class SatinPresenter extends BasePresenter<SatinContract.View> implements SatinContract.Presenter {
    private SatinApi satinApi;

    @Inject
    public SatinPresenter(SatinApi satinApi) {
        this.satinApi = satinApi;
    }

    @Override
    public void getSatin() {
        satinApi.getSatin()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SatinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SatinBean satinBean) {
                        if (mView != null) {
                            mView.onSuccess(satinBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
