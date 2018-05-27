package com.example.administrator.week03dome.ui.satin.Contract;

import com.example.administrator.week03dome.bean.SatinBean;
import com.example.administrator.week03dome.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/5/26.
 */

public interface SatinContract  {
    interface View  extends BaseContract.BaseView{
        void onSuccess(SatinBean satinBean);
    }
    interface  Presenter extends BaseContract.BasePresenter<View>{
        void getSatin();
    }
}
