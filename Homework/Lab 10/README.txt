/*
 * Rajat Kuthiala
 * LAB-10
 * CSC-172
 * TA: Shuyang Liu
 * Partner: Jordy
 * 
 * I affirm that I have not given 
 * or received any unauthorized help 
 * on this assignment, and that this 
 * work is my own.
 */

README:

For this lab we created our own Binary Search Tree with insert, deletion, lookup and traversal methods. The insert method compared the data inputted and data of the node and either traversed left or right of the tree until it hit a null point where a new node with the data was created. The deletion method was the most complicated because deleting a node had three different cases: the node was a leaf (no children), the node had one child and the node had two children. The latter being the most difficult. For the leaf, you just set that parent’s child to null. For one child, you set the parent’s child to the current node’s child and the current node’s child to the parent. The last case required creating a method that found the leftmost value of the right subtree, duplicating it and setting the current node to that duplication. Afterwards, deleting that duplication by just using the method from either Case 1: a leaf node. 