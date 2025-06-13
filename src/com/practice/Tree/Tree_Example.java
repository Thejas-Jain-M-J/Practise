package com.practice.Tree;

/**
 * 
 * Binary Tree
 * Definition: A binary tree is a tree data structure where each node can have
 * at most two children, referred to as the left child and the right child.
 * 
 * Key Characteristics:
 * 
 * No specific ordering is required for the node values.
 * The tree can be complete, full, perfect, or skewed depending on the
 * arrangement of nodes.
 * Can be used to represent hierarchical relationships (e.g., parse trees, file
 * systems).
 * Usage:
 * 
 * General hierarchical representation.
 * Expression evaluation trees.
 * Networking models.
 * Example Binary Tree:
 * markdown
 * Copy code
 * 1
 * / \
 * 2 3
 * / \
 * 4 5
 * 
 * ------------------------------------------------------------------------------------
 * 
 * Binary Search Tree (BST)
 * Definition: A BST is a special type of binary tree where the value of each
 * node follows specific rules:
 * 
 * All values in the left subtree of a node are less than or equal to the node's
 * value.
 * All values in the right subtree of a node are greater than the node's value.
 * Key Characteristics:
 * 
 * Ordered structure that allows efficient searching, insertion, and deletion.
 * Provides an average-case time complexity of 𝑂(log𝑛)
 * O(logn) for search operations.
 * Unbalanced BSTs may degrade to
 * 𝑂(𝑛)
 * O(n) complexity in the worst case (e.g., if the tree becomes skewed).
 * Usage:
 * 
 * Efficient searching and sorting.
 * Dynamic sets and lookups.
 * Implementations of maps and sets (e.g., TreeMap and TreeSet in Java).
 * Example Binary Search Tree:
 * markdown
 * Copy code
 * 5
 * / \
 * 3 7
 * / \ \
 * 2 4 8
 * In the BST above:
 * Left subtree of 5 has values ≤ 5.
 * Right subtree of 5 has values > 5.
 * Comparison Table
 * Aspect Binary Tree Binary Search Tree (BST)
 * Node Order No specific order of nodes. Nodes follow a specific ordering rule.
 * Efficiency Not optimized for search operations. Optimized for search,
 * insertion, deletion.
 * Applications General purpose, hierarchical data. Efficient searching,
 * sorting, and dynamic datasets.
 * Time Complexity Traversals:
 * 𝑂
 * (
 * 𝑛
 * )
 * O(n). Search:
 * 𝑂
 * (
 * log
 * ⁡
 * 𝑛
 * )
 * O(logn) (average),
 * 𝑂
 * (
 * 𝑛
 * )
 * O(n) (worst case).
 * Examples Expression trees, family trees. Dictionaries, databases, and index
 * structures.
 * 
 */
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

public class Tree_Example {
    public static void main(String[] args) {
        // Initialize and allocate memory for tree nodes
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
        thirdNode.right = sixthNode;
        thirdNode.right = seventhNode;

    }
}
