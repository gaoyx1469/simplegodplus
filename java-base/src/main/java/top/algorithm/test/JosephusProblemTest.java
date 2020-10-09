package top.algorithm.test;

import top.algorithm.realization.JosephusProblem;
import top.algorithm.structure.CircularLinkedList;
import top.algorithm.structure.SinglyLinkedNode;

/**
 * @Author gaoyx1469
 * @Date 2020/8/24
 * @Version 1.0
 */
public class JosephusProblemTest {
    public static void main(String[] args) {
        CircularLinkedList linkedList = new CircularLinkedList();
        linkedList.addNode(new SinglyLinkedNode(1));
        linkedList.addNode(new SinglyLinkedNode(2));
        linkedList.addNode(new SinglyLinkedNode(3));
        linkedList.addNode(new SinglyLinkedNode(4));
        linkedList.addNode(new SinglyLinkedNode(5));
        linkedList.addNode(new SinglyLinkedNode(6));
        linkedList.addNode(new SinglyLinkedNode(7));
        linkedList.addNode(new SinglyLinkedNode(8));
        linkedList.addNode(new SinglyLinkedNode(9));
        System.out.println(linkedList.showAllNode());
        System.out.println("----------------------");
        JosephusProblem.getJosephusProblemPath(linkedList, 7, 0).forEach(System.out::println);
        System.out.println("----------------------");
        System.out.println(linkedList.showAllNode());
    }
}
