package com.practice.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree_Traversal {

    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(6);
        Node seventhNode = new Node(7);

        // Connect binary tree nodes
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        secondNode.right = fifthNode;
        thirdNode.left = sixthNode;
        thirdNode.right = seventhNode;

        System.out.println("InOrder 4 2 5 1 6 3 7");
        inOrder(firstNode);
        System.out.println();
        System.out.println("preOrder 1 2 4 5 3 6 7");
        preOrder(firstNode);
        System.out.println();
        System.out.println("postOrder 4 5 2 6 7 3 1");
        postOrder(firstNode);
        System.out.println();
        System.out.println("preOrder Iterative approach 1 2 4 5 3 6 7");
        iterativePreOrder(firstNode);
        System.out.println();
        System.out.println("InOrder Iterative approach 4 2 5 1 6 3 7");
        iterativeInOrder(firstNode);
        System.out.println();
        System.out.println("postOrder Iterative approach 4 5 2 6 7 3 1");
        iterativePostOrder(firstNode);
    }

    static void inOrder(Node tNode) {
        if (tNode == null)
            return;

        inOrder(tNode.left);
        System.out.print(tNode.data + " ");
        inOrder(tNode.right);
    }

    static void preOrder(Node tNode) {
        if (tNode == null) {
            return;
        }

        System.out.print(tNode.data + " ");
        preOrder(tNode.left);
        preOrder(tNode.right);
    }

    static void postOrder(Node tNode) {
        if (tNode == null) {
            return;
        }

        postOrder(tNode.left);
        postOrder(tNode.right);
        System.out.print(tNode.data + " ");
    }

    static void iterativePreOrder(Node tNode) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stk = new Stack<>();

        stk.push(tNode);
        while (!stk.isEmpty()) {
            Node tmp = stk.pop();
            if (tmp != null) {
                System.out.print(tmp.data + " ");
                stk.push(tmp.right);
                stk.push(tmp.left);
            }

        }
    }

    static void iterativeInOrder(Node tNode) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stk = new Stack<>();

        Node tmp = tNode;
        while (true) {
            if (tmp != null) {
                stk.push(tmp);
                tmp = tmp.left;
            } else {
                if (stk.isEmpty())
                    break;
                tmp = stk.pop();
                System.out.print(tmp.data + " ");
                tmp = tmp.right;
            }
        }
    }

    static void iterativePostOrder(Node tNode)
    {
        Stack<Node> stk = new Stack<>();
        Node temp1;
        Node cur = tNode;
        stk.push(cur);
        cur = cur.left;
        while(cur != null || !stk.isEmpty())
        {

            if(cur != null)
            {
                stk.push(cur);
                cur = cur.left;
            }else{
                temp1 = stk.peek().right;

                if(temp1 == null)
                {
                    temp1 = stk.peek();
                    stk.pop();
                    System.out.print(temp1.data +" ");
                    while(!stk.isEmpty() && temp1 == stk.peek().right)
                    {
                        temp1 = stk.pop();
                        System.out.print(temp1.data +" ");
    
                    }
                    
                }else{
                    cur = temp1;
                }
            }
        }
    }

}
