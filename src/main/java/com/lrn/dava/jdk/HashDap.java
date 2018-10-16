package com.lrn.dava.jdk;


public class HashDap extends AbstractDap {

    //定义数据结构
    static class Node{
        private String key;
        private String value;
        private int hash;
        private Node next;

        public Node(String key, String value, int hash, Node next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
