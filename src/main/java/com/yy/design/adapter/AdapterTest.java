package com.yy.design.adapter;

import com.yy.design.adapter.classAdapter.Adapter;
import com.yy.design.adapter.classAdapter.Source;
import com.yy.design.adapter.classAdapter.Target;
import com.yy.design.adapter.objectAdapter.ObjectAdapter;
import org.junit.Test;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/15
 */
public class AdapterTest {


    @Test
    public void testClassAdapter(){
        Target source = new Adapter();
        source.preRequest();
    }

    @Test
    public void testObjectAdapter(){
        Adapter adapter = new Adapter();
        ObjectAdapter source = new ObjectAdapter(adapter);
        source.preRequest();
    }

}
