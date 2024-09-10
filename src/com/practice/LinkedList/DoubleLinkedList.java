package com.practice.LinkedList;

public class DoubleLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }

        Node(int data, Node next,Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    Node createDLL(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i=1;i<arr.length;i++)
        {
            Node temp = new Node(arr[i]);
            temp.prev = prev;
            prev.next = temp;
            prev = temp;
        }
        return  head;
    }

    void print(Node head) {
        if(head == null )
        {
            return;
        }
        Node temp = head;
        System.out.print(temp.data + " ");
        while (temp.next != null) {

            temp = temp.next;
            System.out.print(temp.data + " ");

        }
    }

    Node deleteHead(Node head)
    {
        if(head == null || head.next == null)
        {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        head.prev = null;
        return head;
    }

    Node deleteTail(Node head)
    {
        if(head == null || head.next == null)
        {
            return null;
        }
        Node temp = head;

        while(temp.next != null)
        {
            temp = temp.next;
        }
  
        Node prev = temp.prev;
        prev.next = null;
        temp.prev = null;
        return head;
    }

    Node removeKthNode(Node head,int k)
    {
        int count = 0;
        Node temp = head;
        while(temp != null)
        {
            count++;
            if(count == k)
            {

                if(temp.prev == null)
                {
                   return deleteHead(temp);

                }else if(temp.next == null)
                {
                    return deleteTail(temp);
                }

                Node back = temp.prev;
                Node front = temp.next;

                back.next = front;
                front.prev = back;
                temp.next = null;
                temp.prev = null;

                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    Node insertKthNode(Node head,int val,int k)
    {
        if(head == null )
            return null;

        Node temp = head;

        while(temp.data != k)
        {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        temp.next.prev = newNode;
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next =  newNode;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {0,5,10,15,20,25,30};

        DoubleLinkedList dl = new DoubleLinkedList();
        Node head = dl.createDLL(arr);
        dl.print(head);

        System.out.println();
        System.out.println("After deleting head in Doubly Linked List");
        head = dl.deleteHead(head);
        dl.print(head);

        System.out.println();
        System.out.println("After deleting tail in Doubly Linked List");
        head = dl.deleteTail(head);
        dl.print(head);

        // System.out.println();
        // System.out.println("After inserting at kth position in Doubly Linked List");
        // head = dl.insertKthNode(new Node(10),12,10);
        // dl.print(head);

        System.out.println();
        System.out.println("After deleting at kth position in Doubly Linked List");
        head = dl.removeKthNode(head,3);
        dl.print(head);


    }
}
