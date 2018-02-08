package com.lrn.dava.instance;


import java.util.EnumSet;
import java.util.Set;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by dava
 *
 * @author xh.d
 * @since 2018/2/8 14:38
 */
public abstract class Pizza {
    public enum Topping {}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addToping(Topping topping) throws Exception {
            if (null !=topping) {
                toppings.add(topping);
                return self();
            }else {
                throw new Exception();
            }
        }
        abstract Pizza build();
        //Subclasses must override this method to return "this"
        protected abstract T self();
    }
    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }
}
