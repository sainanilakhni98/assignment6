package com.nagarro.dsa.hash;


//this class provides the methods for inserting and get the element in a key value form
public class HashTableArray<T> {
    Entry[] arrayHash;
    int size;
    public HashTableArray(int size){
        this.size = size;
        arrayHash = new Entry[size];
        for (int i=0;i<size;i++)
            arrayHash[i] = new Entry();
    }
    int getHash(int key){
        return key%size;
    }
    public void insert(int key, Object value){
        int HashIndex = getHash(key);
        Entry arrayValue = arrayHash[HashIndex];
        Entry newItem = new Entry(key,value);
//        while (arrayValue!=null){
//            arrayValue=arrayValue.next;
//        }
        newItem.next = arrayValue.next;
        arrayValue.next=newItem;
    }

    public T get(int key){
        T value = null;
        int HashIndex = getHash(key);
        Entry arrayValue = arrayHash[HashIndex];
        while (arrayValue!=null){
            if(arrayValue.getKey()==key){
                value = (T) arrayValue.getValue();
                break;
            }
            arrayValue = arrayValue.next;
        }
        return value;
    }

}

