package top.algorithm.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 环形单向链表数据结构
 *
 * @Author gaoyx1469
 * @Date 2020/8/21
 * @Version 1.0
 */
public class CircularLinkedList {

    SinglyLinkedNode firstNode;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 添加节点
     *
     * @param node SinglyLinkedNode 要添加的节点
     */
    public void addNode(SinglyLinkedNode node) {
        if (node == null)
            return;
        if (firstNode == null) {
            firstNode = node;
            node.nextNode = node;
        } else {
            SinglyLinkedNode curr = firstNode;
            for (int i = 1; i < size; i++) {
                curr = curr.nextNode;
            }
            node.nextNode = firstNode;
            curr.nextNode = node;
        }
        size++;
    }


    /**
     * @param n   每n个数删除一个元素
     * @param num 最后留存元素个数
     * @return List<SinglyLinkedNode> 删除顺序列表
     */
    public List<SinglyLinkedNode> josephusProblemDelete(int n, int num) {
        List<SinglyLinkedNode> list = new ArrayList<>();
        if (size != 0) {
            SinglyLinkedNode lastNode = firstNode;
            for (int i = 0; i < size - 1; ++i) {
                lastNode = lastNode.nextNode;
            }
            while (size > num) {
                for (int i = 1; i < n; ++i) {
                    lastNode = lastNode.nextNode;
                }
                //lastNode是要删除的结点的上一节点
                if (size > 1) {
                    list.add(lastNode.nextNode);
                    if (firstNode == lastNode.nextNode) {
                        firstNode = lastNode.nextNode.nextNode;
                    }
                    lastNode.nextNode = lastNode.nextNode.nextNode;
                } else {
                    list.add(lastNode);
                    firstNode = null;
                }
                size--;
            }
        }
        return list;
    }

    /**
     * 显示全部元素
     *
     * @return String
     */
    public String showAllNode() {
        SinglyLinkedNode curr = firstNode;
        if (curr == null)
            return "[]";
        StringBuilder sb = new StringBuilder("[").append("\n");
        for (int i = 0; i < size; ++i) {
            sb.append(curr.val).append("|").append(curr.str).append(",").append("\n");
            curr = curr.nextNode;
        }
        sb.deleteCharAt(sb.length() - 2).append("]");
        return sb.toString();
    }
}
