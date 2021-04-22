package com.nagarro.dsa.nchildtree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int key;
    List<Node> child;

    public Node(int key) {
        this.key = key;
        child = new ArrayList<>();
    }
}

