package com.nagarro.dsa.queue;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

//This class contains all opertions that perform on Queue like insert, delete and all.
public class QueueOperations {
    Node front=null,rear=null;
    Scanner sc = new Scanner(System.in);

    //function for insert element
    public void enqueue(){
        int data;
        System.out.print("Enter data");
        data = sc.nextInt();
        Node newNode = new Node(data);
        if(rear==null){
            front=rear=newNode;
            return;
        }
        rear.next=newNode;
        rear = newNode;
    }

    //function for delete a node from queue
    public void dequeue(){
        if(front==null){
            System.out.println("Queue is empty .Deletion is not possible");
            return;
        }
        front=front.next;
        if(front==null)
            rear=null;

    }

    //function for check whether a element is present or not.
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

    //function for traverse
    public void traverse(){
        Node currentNode = front;
        if(front==null){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Element of Queue are --> ");
        while(currentNode!=null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    //function for check the size of the queue
    public void size() {
        int count = 0;
        while (front != null) {
            count++;
            front = front.next;
        }
        System.out.println("Size of the Queue is " + count);
    }

    //funtion for see the front element of the queue
    public void peek(){
        if(front==null){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Peek Element of the Queue is "+ front.data);
    }

    // function for reverse of the queue
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

}

