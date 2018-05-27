package com.example.administrator.week03dome.ui.satin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.administrator.week03dome.Component.DaggerHttpComponent;
import com.example.administrator.week03dome.MainActivity;
import com.example.administrator.week03dome.Module.HttpModule;
import com.example.administrator.week03dome.R;
import com.example.administrator.week03dome.bean.SatinBean;
import com.example.administrator.week03dome.ui.base.BaseActivity;
import com.example.administrator.week03dome.ui.satin.Adapter.SatinAdapter;
import com.example.administrator.week03dome.ui.satin.Contract.SatinContract;
import com.example.administrator.week03dome.ui.satin.Presenter.SatinPresenter;

public class SatinActivity extends BaseActivity<SatinPresenter> implements SatinContract.View, View.OnClickListener {

    /**
     * 跳转
     */
    private Button mBtn;
    private RecyclerView mRlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        initView();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_satin;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);

    }

    @Override
    public void onSuccess(SatinBean satinBean) {
        SatinAdapter satinAdapter = new SatinAdapter(this, satinBean.getData());
        mRlv.setAdapter(satinAdapter);

    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
        mRlv.setLayoutManager(gridLayoutManager);
        mPresenter.getSatin();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                Intent intent = new Intent(SatinActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
