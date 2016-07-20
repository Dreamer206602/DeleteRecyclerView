package com.lezhian.deleterecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lezhian.deleterecyclerview.adapter.MyAdapter;
import com.lezhian.deleterecyclerview.mvp.testBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.codefalling.recyclerviewswipedismiss.SwipeDismissRecyclerViewTouchListener;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;


    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new MyAdapter(getDatas(10));

        mRecyclerView.setAdapter(mAdapter);

        SwipeDismissRecyclerViewTouchListener mViewTouchListener=
                new SwipeDismissRecyclerViewTouchListener.Builder(mRecyclerView, new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
                    @Override
                    public boolean canDismiss(int i) {
                        return true;
                    }

                    @Override
                    public void onDismiss(View view) {
                        int position = mRecyclerView.getChildPosition(view);
                        mAdapter.mDataset.remove(position);
                        mAdapter.notifyDataSetChanged();

                    }
                }).setIsVertical(false)
                        .setItemTouchCallback(
                                new SwipeDismissRecyclerViewTouchListener.OnItemTouchCallBack() {
                                    @Override
                                    public void onTouch(int index) {

                                    }
                                })
                        .create();


        if(mAdapter.getItemCount()>0){
            mRecyclerView.setOnTouchListener(mViewTouchListener);
        }

    }



    public List<testBean> getDatas(int pageIndex){
        List<testBean>mDatas=new ArrayList<>();
        for (int i = 0; i <pageIndex ; i++) {
            testBean bean=new testBean("lisi"+i,i,"男"+i);
            mDatas.add(bean);
        }
        return mDatas;

    }

}
