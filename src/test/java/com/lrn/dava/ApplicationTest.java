package com.lrn.dava;

import com.lrn.dava.instance.Calzone;
import com.lrn.dava.instance.Nutritions;
import org.junit.Test;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by dava
 *
 * @author xh.d
 * @since 2018/2/8 14:29
 */
public class ApplicationTest {

    @Test
    public void nutritionsTest(){
        Nutritions nutritions = new Nutritions.Builder(100,50).calories(10).corbohydrate(5).sodium(6).build();
    }
    @Test
    public void calzoneTest(){
        Calzone calzone = new Calzone.Builder().sauceInside(true).build();
    }
}
