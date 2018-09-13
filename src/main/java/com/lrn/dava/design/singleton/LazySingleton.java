package com.lrn.dava.design.singleton;

/**
 * 懒汉式,声明好.
 * */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            //懒汉式做法
            instance = new LazySingleton();
            return instance;
        }
        return instance;
    }
}
