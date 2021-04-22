package com.nagarro.dsa.priorityqueue;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


public class PriorityQueueOperations {
        Scanner sc = new Scanner(System.in);
        Node front=null,rear=null;

    //this function insert the node in a PriorityQueue.
    public void enqueue(){
            System.out.print("Enter data : ");
            int data = sc.nextInt();
            System.out.print("Enter Priority : ");
            int priority = sc.nextInt();
            Node newNode = new Node(data,priority);
            if(front==null || front.priority<priority){
                newNode.next=front;
                if(front==null)
                    rear=newNode;
                front=newNode;
            }
            else{
                Node currentNode = front;
                while(currentNode.next!=null && currentNode.next.priority>priority)
                    currentNode=currentNode.next;
                newNode.next=currentNode.next;
                currentNode.next=newNode;
            }
        }

        //function for check the value that is present or not.
        public void contains(){
            int element;
            System.out.print("Enter Element");
            element = sc.nextInt();
            Node currentNode = front;
            AtomicBoolean flag= new AtomicBoolean(false);
            while(currentNode!=null){
                if(currentNode.data==element) {
                    flag.set(true);
                    break;
                }
                currentNode=currentNode.next;
            }
            if(flag.get()==true)
                System.out.println("Value is found");
            else
                System.out.println("Value is not found");
        }

        // this function traverse/print all the nodes
        public  void traverse(){
            Node current = front;

            if(front==null){
                System.out.println("Priority Queue is empty");
                return;
            }
            System.out.println("Priority Queue nodes are");
            while (current!=null){
                System.out.println(current.data + " " + current.priority);
                current=current.next;
            }
            System.out.println();
        }

        //function for check size of the priority queue
        public void size() {
            int count = 0;
            while (front != null) {
                count++;
                front = front.next;
            }
            System.out.println("Size of the Queue is " + count);
        }

        //function for reverse of the priority queue
        public void reverse(){
            Node currentNode=front, forward = null, previous = null;
            while (currentNode!=null){
                forward = currentNode.next;
                currentNode.next = previous;
                previous=currentNode;
                currentNode=forward;
            }
            front = previous;
        }
        //funtion for delete a node from priority queue
        public void dequeue(){

            if(front==null){
                System.out.println("Queue is empty .Deletion is not possible");
                return;
            }
            Node current =front;
            front=front.next;
            if(front==null)
                rear=null;
            current.next=null;
        }

        //function for check the peek element from the priority queue
        public void peek(){
            if(front==null){
                System.out.println("Priority Queue is empty");
                return;
            }
            System.out.println("Peek(top) element of the priority Queue is " + front.data + " with priority is " +front.priority);
        }
}
