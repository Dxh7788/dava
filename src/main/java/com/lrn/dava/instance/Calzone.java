package com.lrn.dava.instance;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by dava
 *
 * @author xh.d
 * @since 2018/2/8 15:01
 */
public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder>{
        private boolean sauceInside;

        public Builder sauceInside(boolean sauceInside) {
            this.sauceInside = sauceInside;
            return this;
        }

        public Calzone build() {
            return new Calzone(this);
        }

        protected Builder self() {
            return this;
        }
    }
    private Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

}
