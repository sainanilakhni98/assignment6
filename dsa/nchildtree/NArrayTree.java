package com.nagarro.dsa.nchildtree;
import java.util.ArrayList;
import java.util.List;
public class NArrayTree {

    public boolean insert(Node root, int parent, int key) {

        if (root.key == parent) {
            root.child.add(new Node(key));
            return true;
        }

        for (int i = 0; i < root.child.size(); i++) {
            if (root.child.get(i).key == parent) {
                root.child.get(i).child.add(new Node(key));
                return true;
            } else if (insert(root.child.get(i), parent, key))
                return true;
        }
        return false;
    }



    public boolean contains(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key) {
            return true;
        }

        for (int i = 0; i < root.child.size(); i++) {
            if (root.child.get(i).key == key) {
                return true;
            } else if (delete(root.child.get(i), key))
                return true;
        }
        return false;
    }
    private static boolean delete(Node root, int key) {

        if (root == null)
            return false;

        if (root.key == key) {
            root = null;
            return true;
        }
        for (int i = 0; i < root.child.size(); i++) {
            if (root.child.get(i).key == key) {
                root.child.set(i, null);
                return true;
            } else if (delete(root.child.get(i), key))
                return true;
        }
        return false;
    }
    public List<Node> getElementsByValue(Node root, int value) {
        if (root.key == value)
        {
            return root.child;
        }

        for (int i = 0; i < root.child.size(); i++) {
            if (root.child.get(i).key == value)
                return root.child.get(i).child;
            List<Node> list = getElementsByValue(root.child.get(i), value);
            if (list != null)
            {
                return list;
            }
        }
        return null;
    }
}
