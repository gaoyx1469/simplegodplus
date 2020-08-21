package top.algorithm.structure;

/**
 * 环形单向链表数据结构
 *
 * @Author gaoyx1469
 * @Date 2020/8/21
 * @Version 1.0
 */
public class CircularLinkedList {

    SinglyLinkedNode firstNode;
    SinglyLinkedNode lastNode;

    boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * 添加节点
     *
     * @param node SinglyLinkedNode 要添加的节点
     */
    void addNode(SinglyLinkedNode node) {
        if (node == null)
            return;
        if (firstNode == null) {
            firstNode = node;
            lastNode = node;
            node.nextNode = node;
        } else {
            lastNode.nextNode = node;
            node.nextNode = firstNode;
            lastNode = node;
        }
    }

    
}
