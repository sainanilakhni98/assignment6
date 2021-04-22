package com.nagarro.dsa.linkedlist;
import java.util.Scanner;

//This class contains all opertions that perform on linkedlist like insert, delete and all.
public class LinkedListOpertions {

    public Node start=null;
    public Node end=null;
    Scanner sc = new Scanner(System.in);
    int data;

    //this function insert the node in a linked list.
    public void insert(){
        System.out.print("Enter data : ");
        data = sc.nextInt();
        Node newNode = new Node(data);
        if(start==null){
            start = newNode;
            end = newNode;
        }
        else{
            end.next=newNode;
            end=newNode;
        }
    }

// this function traverse/print all the nodes
    public  void traverse(){
        Node current = start;

        if(start==null){
            System.out.println("linked list is empty");
            return;
        }
        System.out.println("Singly linked list nodes are");
        while (current!=null){
            System.out.println(current.data + " ");
            current=current.next;
        }
        System.out.println();
    }

    // Function for Delete Node where we delete our node based on the value.
    public void delete(){
        Node currentNode = start;
        System.out.print("Enter the value : ");
        int value = sc.nextInt();
        //if start node have the key to be deleted
        if(currentNode!=null && currentNode.data==value){
            start=currentNode.next;
            System.out.println(value + " found and deleted");
        }
        else{
            Node previous=null;
            while(currentNode != null && currentNode.data !=value){
                previous = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode!=null){
                previous.next=currentNode.next;
                System.out.println(value + " found and deleted");
            }
            else
                System.out.println("Value not found");
        }
        currentNode.next=null;
    }

    //function for count the numbers of nodes
    public int countNode(){
        Node currentNode = start;
        int counter=0;
        while(currentNode.next!=null){
            counter++;
            currentNode=currentNode.next;
        }
        return counter;
    }

    //function for delete the node based on the position
    public void deleteAtPosition(){
        Node currentNode=start;
        System.out.print("Enter the position : ");
        int position=sc.nextInt();
        if(position==1)
            start=start.next;
        else{
            int count=0;
            currentNode=currentNode.next;
            Node previous = start;
            while (position-2>count){
                previous=currentNode;
                currentNode=currentNode.next;
                count++;
            }
            previous.next=currentNode.next;
        }
        currentNode.next=null;
        currentNode=null;
    }

    //funtion for insert node based on position
    public void insertAtPosition(){

        System.out.print("Enter the value : ");
        int value = sc.nextInt();
        System.out.print("Enter the position : ");
        int position = sc.nextInt();
        int numberOfNodes = countNode();
        if(position>numberOfNodes+1 || position < 1)
            System.out.println("Please Enter a Valid Position");
        else{
            Node newNode = new Node(value);
            Node currentNode=null;
            if(position==1){
                newNode.next=start;
                start=newNode;
            }
            else{
                int count=0;
                currentNode=start;
                while (position-2>count){
                    currentNode = currentNode.next;
                    count++;
                }
                newNode.next=currentNode.next;
                currentNode.next=newNode;
            }
        }
    }

    //function for reverse a linked list
    public void reverse(){
        Node currentNode=start, forward = null, previous = null;
        while (currentNode!=null){
            forward = currentNode.next;
            currentNode.next = previous;
            previous=currentNode;
            currentNode=forward;
        }
        start = previous;
    }

    //funtion for find center element of the linked list
    public void center(){
        Node slowNode = start, fastNode = start;
        if(start != null){
            while (fastNode!=null && fastNode.next.next!=null){
                slowNode=slowNode.next;
                fastNode=fastNode.next.next;
            }
            System.out.println(" The middle element is " + slowNode.data);
        }
    }
}
