package com.practice.Tree;

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class Boundary_Traversal {
    Node root;

     void printLeftBoundary(Node root)
    {
        Node curr = root.left;
        while(curr != null)
        {
            if(curr.left != null || curr.right != null)
            {
                System.out.println(curr.data);
            }

            if(curr.left != null) curr= curr.left;
            else curr = curr.right;
        }
    }

    void printLeaves(Node root)
    {
        Node curr = root;
        if(curr == null)
            return;

        if( (curr.left == null && curr.right ==null))
        {
            System.out.println(curr.data);
            return;
        }

        printLeaves(curr.left);
        printLeaves(curr.right);
    }

    void rightTree(Node root)
    {
        Node curr = root;

        if(curr == null)
        {
            return;
        }
        
        if(curr.right != null) rightTree(curr.right);
        else rightTree(curr.left);
        
        if(curr.left != null || curr.right != null)
            System.out.println(curr.data);
    }

    public static void main(String[] args) {
        Boundary_Traversal tree = new Boundary_Traversal();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(5);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.root.right.right.right = new Node(35);

        if(tree.root != null || (tree.root.left != null || tree.root.right != null))
        System.out.println(tree.root.data);
        tree.printLeftBoundary(tree.root);
        tree.printLeaves(tree.root);
        tree.rightTree(tree.root.right);
    }
}
