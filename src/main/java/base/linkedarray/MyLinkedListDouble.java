package base.linkedarray;



/*
    关于链表:
        链表是物理存储单元上非连续的、非顺序的存储结构，数据元素的逻辑顺序是通过链表的指针地址实现，每个元素包含两个结点，一个是存储元素的数据域 (内存空间)，另一个是指向下一个结点地址的指针域。根据指针的指向，链表能形成不同的结构，例如单链表，双向链表，循环链表等。

    链表的特性:
        创建:
        增加: 在开始/末尾/任意增加, 增加时,涉及到前后节点指针的断开和重新连接
        读取: 根据索引读取,需要从头节点遍历过去
        修改: 根据索引修改,需要从头节点遍历过去,涉及到前后节点指针的断开和重新连接
        删除: 根据索引删除,需要从头节点遍历过去,涉及到前后节点指针的断开和重新连接

    特性:
        1. 不能直接使用索引下标操作数据
        2. 操作中间的元素时,需要从头节点遍历过去,涉及到前后节点指针的断开和重新连接

    校验:
        1. 不能在空链表时删除
        2. 根据索引操作时,越界校验
           按照索引插入时,如果使用抽取的getNode()方法,需要单独处理插入到最后的情况,通用的getNode不能处理index==size的场景

 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双链表实现
 */
public class MyLinkedListDouble<E> implements Iterable<E> {


    /**
     * 虚拟头尾节点
     * 直接定义出头尾的空节点进行占位,避免掉一些复杂的端点情况处理
     */
    final private Node<E> head, tail;

    /**
     * 我们定义的链表长度
     */
    private int size;

    /**
     * 双链表节点
     */
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    // 构造函数初始化头尾节点
    public MyLinkedListDouble() {
        // 首尾空节点占位
        this.head = new Node<>(null);
        this.tail = new Node<>(null);

        //首尾节点相连
        head.next = tail;
        tail.prev = head;

        // 初始链表长度
        this.size = 0;
    }


    /**
     * 在末尾增加节点
     *
     * @param e 增加的节点的value
     */
    public void addLast(E e) {

        // 要插入的节点
        Node<E> curNode = new Node<>(e);

        // 增加的前一个节点
        Node<E> preNode = tail.prev;
        // 与前一个节点连接
        preNode.next = curNode;
        curNode.prev = preNode;

        // 与尾结点连接
        curNode.next = tail;
        tail.prev = curNode;

        // 修改长度
        size++;

    }

    /**
     * 在开始插入
     *
     * @param e 增加的节点的value
     */
    public void addFirst(E e) {

        // 要插入的节点
        Node<E> curNode = new Node<>(e);

        // 增加的后一个节点
        Node<E> nextNode = head.next;
        // 与后一个节点连接
        nextNode.prev = curNode;
        curNode.next = nextNode;

        // 与头结点连接
        curNode.prev = head;
        head.next = curNode;

        // 修改长度
        size++;

    }


    /**
     * 在index位置插入
     *
     * @param index   索引
     * @param element 插入的节点的value
     */
    public void add(int index, E element) {
        // 检查插入索引越界
        checkPositionIndex(index);

        // 要插入的节点
        Node<E> newNode = new Node<>(element);

        // 插入到最后的情况, 使用getNode()不能处理 index == size
        if (index == size) {
            addLast(element);
            return;
        }

//        // 临时节点
//        Node<E> curNode = head.next;
//        // 遍历到索引位置
//        for (int i = 0; i < index; i++) {
//            curNode = curNode.next;
//        }

        // 遍历到索引位置
        Node<E> curNode = getNode(index);


        // 与索引前节点连接
        Node<E> preNode = curNode.prev;
        preNode.next = newNode;
        newNode.prev = preNode;

        // 与原索引节点连接
        newNode.next = curNode;
        curNode.prev = newNode;

        // 更新长度
        size++;

    }


    /**
     * 删除首个
     *
     * @return 删除的值
     */
    public E removeFirst() {

        // 空链表
        if (size < 1) {
            throw new NoSuchElementException();
        }

        // 删除的节点
        Node<E> curNode = head.next;

        // 操作前后指针
        head.next = curNode.next;
        curNode.next.prev = head;

        // 原节点垃圾回收
        curNode.prev = null;
        curNode.next = null;

        // 更新size
        size--;

        return curNode.val;

    }

    /**
     * 删除末尾
     *
     * @return 删除的值
     */
    public E removeLast() {

        // 空链表
        if (size < 1) {
            throw new NoSuchElementException();
        }

        // 删除的节点
        Node<E> curNode = tail.prev;

        // 操作前后指针
        curNode.prev.next = tail;
        tail.prev = curNode.prev;

        // 原节点垃圾回收
        curNode.prev = null;
        curNode.next = null;

        // 更新size
        size--;

        return curNode.val;

    }

    /**
     * 获取index位置的节点值
     *
     * @param index 索引
     * @return 节点值
     */
    public E get(int index) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<E> p = getNode(index);

        return p.val;
    }

    /**
     * 获取第一个节点值
     *
     * @return 节点值
     */
    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }

        return head.next.val;
    }

    /**
     * 获取最后一个节点值
     *
     * @return 节点值
     */
    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }

        return tail.prev.val;
    }

    /**
     * 指定index索引删除
     *
     * @param index 索引
     * @return 除的值
     */
    public E remove(int index) {

        // 获取索引位置节点
        Node<E> curNode = getNode(index);

        // 操作前后指针
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;

        // 原节点垃圾回收
        curNode.prev = null;
        curNode.next = null;

        // 更新size
        size--;

        return curNode.val;

    }


    /**
     * 修改index索引的节点值
     *
     * @param index 索引
     * @param val   值
     * @return 旧的值
     */
    public E set(int index, E val) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<E> curNode = getNode(index);

        // 更新值
        E oldVal = curNode.val;
        curNode.val = val;

        return oldVal;
    }


    /**
     * 链表长度
     *
     * @return 链表长度
     */
    public int size() {
        return size;
    }

    /**
     * 空链表判断
     *
     * @return 空?
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 按索引获取节点
     *
     * @param index 索引
     * @return 节点
     */
    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> curNode = head.next;
        // TODO: 可以优化，通过 index 判断从 head 还是 tail 开始遍历
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }


    /**
     * 检查索引位置是否可以添加元素 (索引越界)
     * 插入时,是在index位置插入,index之后的移动一位
     * 并且index 可以==size (如空的数组,可以在index=0 位置插入)
     * 则 0<= index <= size
     *
     * @param index 索引
     */
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }


    /**
     * 检查索引位置是否可以存在元素 (索引越界)
     * 常规检查, 0 <= index < size
     */
    private void checkElementIndex(int index) {
        if (index >= 0 && index < size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }

}
