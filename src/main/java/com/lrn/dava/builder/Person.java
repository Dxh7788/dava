package com.lrn.dava.builder;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by dava
 *
 * @author xh.d
 * @since 2018/2/8 15:28
 */
public class Person {
    private String name;
    private String sex;
    private int year;
    private String city;
    private String state;
    private boolean isFemale;
    private boolean isEmployed;
    private boolean isHomeOwner;

    public Person(String name) {
        this.name = name;
    }

    public static class Builder{
        private String name;
        private String sex;
        private int year;
        private String city;
        private String state;
        private boolean isFemale;
        private boolean isEmployed;
        private boolean isHomeOwner;

        public Builder(String name) {
            this.name = name;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder isFemale(boolean female) {
            isFemale = female;
            return this;
        }

        public Builder isEmployed(boolean employed) {
            isEmployed = employed;
            return this;
        }

        public Builder isHomeOwner(boolean homeOwner) {
            isHomeOwner = homeOwner;
            return this;
        }

        public Person build(){
            Person person = new Person();
            person.name = name;
            person.sex = sex;
            person.year = year;
            person.city = city;
            person.state = state;
            person.isFemale = isFemale;
            person.isEmployed = isEmployed;
            person.isHomeOwner = isHomeOwner;

            return person;
        }
    }
    private Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", year=" + year +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", isFemale=" + isFemale +
                ", isEmployed=" + isEmployed +
                ", isHomeOwner=" + isHomeOwner +
                '}';
    }
}
