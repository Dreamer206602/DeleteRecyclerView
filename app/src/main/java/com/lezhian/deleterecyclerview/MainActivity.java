package com.lezhian.deleterecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.lezhian.deleterecyclerview.adapter.MyAdapter;
import com.lezhian.deleterecyclerview.mvp.testBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;


    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter=new MyAdapter(getDatas(10));

        mRecyclerView.setAdapter(mAdapter);


    }



    public List<testBean> getDatas(int pageIndex){
        List<testBean>mDatas=new ArrayList<>();
        for (int i = 0; i <pageIndex ; i++) {
            testBean bean=new testBean("lisi",12,"男");
            mDatas.add(bean);
        }
        return mDatas;

    }









}
