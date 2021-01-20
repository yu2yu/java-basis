package com.yy.design.adapter.objectAdapter;

import com.yy.design.adapter.classAdapter.Adapter;
import com.yy.design.adapter.classAdapter.Source;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/15
 */
public class ObjectAdapter {

    private Adapter adapter;

    public ObjectAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    public void preRequest(){
        System.out.println("适配接口中···");
        adapter.request();
    }

}
