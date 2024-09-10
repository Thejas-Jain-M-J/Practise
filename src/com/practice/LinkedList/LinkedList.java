package com.practice.LinkedList;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node insert(LinkedList list, int val) {
        Node node = new Node(val);
        if (list.head == null) {
            list.head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }
        return head;
    }

    void print(Node head) {
        Node temp = head;
        System.out.print(temp.data + " ");
        while (temp.next != null) {

            temp = temp.next;
            System.out.print(temp.data + " ");

        }
    }

    Node deleteHead(Node head) {
        Node temp = head;

        if (temp.next == null || temp == null) {
            head = null;
        }

        head = temp.next;
        return head;
    }

    Node deleteTail(Node head) {
        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    Node deleteNthElement(Node head, int k) {
        Node temp = head;
        Node prev = null;
        if (temp.data == k) {
            head = temp.next;
            return head;
        }
        while (temp != null) {
            if (temp.data == k) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;

        }
        return head;
    }

    Node insertHead(int val, Node head) {
        Node temp = new Node(val, head);
        return temp;
    }

    Node insertTail(Node head, int tail) {
        Node temp = head;

        if (head == null)
            return new Node(tail);

        while (temp.next != null) {
            temp = temp.next;

        }
        Node newTail = new Node(tail);
        temp.next = newTail;

        return head;
    }

    Node insertAtKthPosition(int val,int k,Node head)
    {
        if(head == null)
        {
            return new Node(val);
        }
        if(k == 1)
        {
            Node newNode = new Node(val);
            newNode.next = head.next;
            head.next = newNode;
            return head;
        }
        Node temp = head;
        int count = 1;
        while(temp != null)
        {
            if(count == (k-1))
            {
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            count++;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        Node head = list.insert(list, 0);
        head = list.insert(list, 1);
        head = list.insert(list, 2);
        head = list.insert(list, 3);
        head = list.insert(list, 4);
        head = list.insert(list, 5);

        list.print(head);

        System.out.println();
        System.out.println("After head deletion");
        head = list.deleteHead(list.head);
        list.print(head);

        System.out.println();
        System.out.println("After tail deletion");
        head = list.deleteTail(head);
        list.print(head);

        System.out.println();
        System.out.println("After K element deletion");
        head = list.deleteNthElement(head, 4);
        list.print(head);

        System.out.println();
        System.out.println("After inserting head");
        head = list.insertHead(0, head);
        list.print(head);

        System.out.println();
        System.out.println("After inserting tail");
        head = list.insertTail(head, 4);
        list.print(head);

        System.out.println();
        System.out.println("After inserting at kth position");
        head = list.insertAtKthPosition(8,1,head);
        list.print(head);

    }

}
