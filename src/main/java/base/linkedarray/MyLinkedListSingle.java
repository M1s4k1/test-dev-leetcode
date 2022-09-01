package base.linkedarray;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 单链表实现
 */
public class MyLinkedListSingle<E> implements Iterable<E> {


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
     * 单链表节点
     */
    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    public MyLinkedListSingle() {
        // 首尾空节点占位,构造函数初始化头尾节点
        this.head = new Node<>(null);
        this.tail = new Node<>(null);

        //首尾节点相连
        head.next = tail;

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
        Node<E> preNode = size == 0 ? head : getNode(size - 1);

        // 与前一个节点连接
        preNode.next = curNode;

        // 与尾结点连接
        curNode.next = tail;

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

        // 与后一个节点连接
        curNode.next = head.next;

        // 与头结点连接
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

        // 如果是插入到末尾,特殊处理
        if (index == size) {
            addLast(element);
            return;
        }

        // 获取插入位置的前一个节点
        Node<E> preNode = getNode(index - 1);

        // 操作前后节点连接
        newNode.next = preNode.next;
        preNode.next = newNode;

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

        // 原节点垃圾回收
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

        // 删除节点的前节点
        // size-2 需要边界判断
        Node<E> curNode = size - 2 > 0 ? getNode(size - 2) : head;

        // 原节点垃圾回收
        E val = curNode.next.val;
        curNode.next.next = null;

        // 操作前后指针
        curNode.next = tail;

        // 更新size
        size--;

        return val;
    }

    /**
     * 指定index索引删除
     *
     * @param index 索引
     * @return 除的值
     */
    public E remove(int index) {

        // 获取索引位置前一个节点
        Node<E> preNode = index == 0 ? head : getNode(index - 1);

        // 原节点垃圾回收
        Node<E> curNode = preNode.next;
        Node<E> nextNode = curNode.next;
        curNode.next = null;

        // 操作前后指针
        preNode.next = nextNode;

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

        return getNode(size - 1).val;
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
     * size==0时,是特殊情况
     *
     * @param index 索引
     * @return 节点
     */
    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> curNode = head.next;
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
