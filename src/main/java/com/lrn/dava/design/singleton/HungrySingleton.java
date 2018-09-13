package com.lrn.dava.design.singleton;

/**
 * 饿汉式,声明好.
 * */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static synchronized HungrySingleton getInstance(){
        return instance;
    }
}
