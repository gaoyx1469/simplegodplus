package top.algorithm.realization;

import top.algorithm.structure.CircularLinkedList;
import top.algorithm.structure.SinglyLinkedNode;

import java.util.List;

/**
 * 约瑟夫问题实现
 * <p>
 * 约瑟夫问题，又称为丢手帕问题，在一个环形链表中，从表头开始，每隔N个，删除一个节点，直到链表为空，返回节点删除轨迹
 *
 * @Author gaoyx1469
 * @Date 2020/8/21
 * @Version 1.0
 */
public class JosephusProblem {
    /**
     * @param linkedList CircularLinkedList 环形链表的表头
     * @param skipNum    int 每多少个节点删除一个节点，要求输入大于等于1
     * @param retainNum  int 最后保留多少节点结束，要求输入大于等于0
     * @return List<SinglyLinkedNode>
     */
    public static List<SinglyLinkedNode> getJosephusProblemPath(CircularLinkedList linkedList, int skipNum, int retainNum) {

        //校验输入
        if (linkedList == null)
            throw new IllegalArgumentException("输入的链表为空");
        if (skipNum < 1)
            throw new IllegalArgumentException("输入的skipNum不合法");
        if (retainNum < 0)
            throw new IllegalArgumentException("输入的retainNum不合法");

        //校验完毕，开始处理
        return linkedList.josephusProblemDelete(skipNum, retainNum);
    }
}
