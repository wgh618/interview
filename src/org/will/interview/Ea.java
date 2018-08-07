package org.will.interview;

/**
 * ClassName:Ea
 * Description:EA(美国艺电公司)面试编程题
 *
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2018-08-07
 */
public class Ea<E> {
    private Node<E> head;

    /**
     * 题目：链表反转
     */
    public Node<E> reverseList(Node<E> head) {
        //链表为空或者仅1个数直接返回
        if (head == null || head.next == null) {
            return head;
        }

        Node<E> point = head;
        Node<E> newH = null;
        //一直迭代到链尾
        while (point != null) {
            //暂存p下一个地址，防止变化指针指向后找不到后续的数
            Node<E> tmp = point.next;
            //p->next指向前一个空间
            point.next = newH;
            //新链表的头移动到p，扩长一步链表
            newH = point;
            //p指向原始链表p指向的下一个空间
            point = tmp;
        }
        return newH;
    }

    class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    /**
     * 头插法
     * @param e
     */
    public void add(E e) {
        if (head == null) {
            head = new Node<>(e, null);
        } else {
            Node<E> node = head;
            head = new Node<>(e, node);
        }
    }

    /**
     * 头插法
     * @param e
     */
    public void show(Node<E> head) {
        Node<E> node = head;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Ea<String> ea = new Ea<>();
        ea.add("a");
        ea.add("b");
        ea.add("c");
        ea.add("d");
        ea.add("e");
        ea.show(ea.head);
        System.out.println();
        ea.show(ea.reverseList(ea.head));
    }
}
