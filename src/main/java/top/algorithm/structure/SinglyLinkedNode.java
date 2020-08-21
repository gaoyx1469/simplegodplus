package top.algorithm.structure;

import com.fasterxml.jackson.databind.util.LinkedNode;

import java.io.Serializable;
import java.util.Objects;

/**
 * 单链表结点类
 *
 * @Author gaoyx1469
 * @Date 2020/8/21
 * @Version 1.0
 */
public class SinglyLinkedNode implements Serializable {
    int val;
    String str;
    SinglyLinkedNode nextNode;

    public SinglyLinkedNode() {
    }

    public SinglyLinkedNode(int val) {
        this.val = val;
    }

    public SinglyLinkedNode(String str) {
        this.str = str;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public SinglyLinkedNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(SinglyLinkedNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "SinglyLinkedNode{" +
                "val=" + val +
                ", str='" + str + '\'' +
                '}';
    }
}
