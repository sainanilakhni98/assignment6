package com.nagarro.dsa.priorityqueue;

//Node class will initialize the Priority Queue node.
public class Node {
        int data;
        int priority;
        Node next;
        public Node(int data,int priority){
            this.data=data;
            this.next=null;
            this.priority=priority;
        }
    }

