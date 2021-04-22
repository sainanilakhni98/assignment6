package com.nagarro.dsa.nchildtree;

public class NChildTree {
        public static void main(String[] args) {

            Node root = new Node(-1);
            NArrayTree tree = new NArrayTree();
            tree.insert(root, -1, 6);
            tree.insert(root, -1, 5);
            tree.insert(root, 1, 33);
            tree.insert(root, 3, 42);

        }
    }
