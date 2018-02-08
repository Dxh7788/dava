package com.lrn.dava.instance;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by dava
 *
 * @author xh.d
 * @since 2018/2/8 14:56
 */
public class NyPizza extends Pizza {
    public enum Size {}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }

        protected Builder self() {
            return this;
        }
    }
    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
