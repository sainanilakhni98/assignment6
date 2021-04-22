package com.nagarro.dsa.hash;

// this class have main method and call the methods like insert and get.
public class HashTableArrayMap {
    public static void main(String[] args) {
        HashTableArray<String> hm = new HashTableArray<String>(10);
        hm.insert(11,"yogesh");
        hm.insert(12,"sainani");
        hm.insert(13,"Nagarro");
        hm.insert(23,"Company");
        hm.insert(43,"Company2");
        System.out.println(hm.get(23));
        System.out.println(hm.get(11));
        System.out.println(hm.get(12));
        System.out.println(hm.get(43));
    }
}
