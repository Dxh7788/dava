package com.lrn.dava.instance;

/**
 * 当构造器参数过多时考虑使用建造者方式
 * Consider a builder when faced with many constructor parameters
 * */
public class Nutritions {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int corbohydrate;

    public Nutritions(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.corbohydrate = builder.corbohydrate;
    }


    public static class Builder{
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int corbohydrate = 0;

        public Builder calories(int value){
            calories = value;
            return this;
        }

        public Builder fat(int value){
            fat =value;
            return this;
        }

        public Builder sodium(int value){
            sodium = value;
            return this;
        }

        public Builder corbohydrate(int value){
            corbohydrate = value;
            return this;
        }
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Nutritions build(){
            return new Nutritions(this);
        }
    }
}
