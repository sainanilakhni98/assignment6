package com.nagarro.dsa.hash;

//this class provides default and parameterized constructer for intialized the array of hash table
public class Entry {
    int key;
    Object value;
    Entry next;
    public Entry(int key, Object value){
        this.key=key;
        this.value=value;
        next=null;
    }
    public Entry(){
        next=null;
    }
    public int getKey(){
        return key;
    }
    public Object getValue(){
        return value;
    }
}