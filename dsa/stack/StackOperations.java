package com.nagarro.dsa.stack;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

//This class contains all opertions that perform on Stack like insert, delete and all.
public class StackOperations {
    Node top = null;
    Scanner sc = new Scanner(System.in);

    //function foor insert an element in a stack
    public void push() {
        int data;
        System.out.print("Enter Data : ");
        data = sc.nextInt();
        Node newNode = new Node(data);
        if(newNode==null){
            System.out.println("Heap is full");
        }
        else if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    //function for delete a element from the top of the stack
    public void pop(){
        if(top==null){
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println(top.data + " is deleted");
        Node current = top;
        top = top.next;
        current.next=null;
    }

    //function for see the top element of the stack
    public void peek(){
        if(top==null){
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println(top.data + " is our top element");
    }

    //function for traverse/print the elements of the stack
    public void traverse(){
        Node currentNode = top;
        if(top==null){
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Element of Stack are --> ");
        while(currentNode!=null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    //function for reverse of the stack
    public void reverse()
    {
        Node previous, current, succ;
        current = previous = this.top;
        current = current.next;
        previous.next = null;
        while (current != null) {

            succ = current.next;
            current.next = previous;
            previous = current;
            current = succ;
        }
        this.top = previous;
    }

    //function for see the size of the stack
    public void size(){
        Node currentNode = top;
        if(top==null){
            System.out.println("Stack is Empty");
            return;
        }
        AtomicInteger count= new AtomicInteger();
        while(currentNode!=null){
            count.getAndIncrement();
            currentNode = currentNode.next;
        }
        System.out.println("Numbers of Nodes in a Stack is : " + count);
    }

    //function for check whether a element is present or not in a stack
    public void contains(){
        Node currentNode = top;
        AtomicBoolean flag= new AtomicBoolean(false);
        System.out.println("Enter Element");
        int element = sc.nextInt();
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
}
