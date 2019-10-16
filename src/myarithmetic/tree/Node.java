package myarithmetic.tree;

import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.swing.*;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-10-16 15:06
 */
public class Node<T extends Comparable> {
    /**
     * 使用双亲定义树
     */
    T data;
    Node<T> leftChild;
    Node<T> rightChild;
    Node<T> parent;
    Node<T> root;
    int size ;
    public Node(T data){
        this.data = data;
        leftChild = null;
        rightChild = null;
        parent= null;
    }


    public Node put(T data){
        Node<T> newNode = new Node<>(data);
        if (root==null) {
            return root = newNode;
        }
        Node<T> parent = null;
        Node<T> node = root;

        while(node!=null){
            parent = node;
            if(parent.data.compareTo(data)>0){
                node = node.leftChild;
            }else if(parent.data.compareTo(data)<0){
                node = node.rightChild;
            }else {
                return node;
            }
        }

        if(parent.data.compareTo(data)>0){
            parent.leftChild = newNode;
        }else {
            parent.rightChild = newNode;
        }
        newNode.parent = parent;
        size++;
        return newNode;
    }

    public void middleOrderTraseval(Node<T> node){
        if (node==null) {
            return;
        }
        middleOrderTraseval(node.leftChild);
        System.out.println(node.data+" ");
        middleOrderTraseval(node.rightChild);
    }


}
