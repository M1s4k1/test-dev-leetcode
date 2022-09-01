package base.linkedarray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
  关于数组:
    数组是可以再内存中连续存储多个元素的结构，在内存中的分配也是连续的，数组中的元素通过数组下标进行访问，数组下标从0开始

  数组的特性:
    创建: 需要给一个初始的数组容量
    增加: 在开始/末尾/任意增加,  在开始/任意位置增加,会涉及到数组的搬移
    读取: 可以根据数组下标读取
    修改: 可以根据数组下标修改
    删除: 根据数组下标修改,删除时需要会涉及到数组的搬移

  特性:
    1. 扩容, 当数组满的时候,需要扩容,新建一个数组 为原数组两倍大小,把原数组copy到新数组去
    2. 缩容, 数组空闲太多时,进行缩容,(扩容是两倍,缩容则是缩到1/2),缩到二分之一的时机,就是1/2 / 2 ,数组占用仅为1/4时
    3. 插入/删除 中间的元素时, 会涉及到数组的搬移

  校验:
    1. 是否需要扩容, 增加/插入
    2. 是否需要缩容, 删除元素
    3. 索引越界, 指定索引的操作
        1. 插入元素时,
    4. 删除,不能空数组删除



 */



/*
  其他相关的知识点:

    1.    System提供了一个静态方法arraycopy(),我们可以使用它来实现数组之间的复制。其函数原型是：

      public static native void arraycopy(Object src,int srcPos,Object dest, int destPos,int length)；

      @param src      the source array. 源数组
      @param srcPos   starting position in the source array. 源数组的起始位置
      @param dest     the destination array. 目标数组
      @param destPos  starting position in the destination data. 目标数组的起始位置
      @param length   the number of array elements to be copied. 复制的长度

      将array数组复制到新的数组中；
          int[] array = {1, 2, 3, 4, 5};
          int[] targetArr = new int[array.length];
          System.arraycopy(array,0,targetArr,0,array.length);
 */


/**
 * @param <E>
 */
public class MyArrayList<E> implements Iterable<E> {

    /**
     * 真正存储数据的底层数组
     */
    private E[] data;
    /**
     * 我们实现的数组的长度
     */
    private int size;

    /**
     *  默认初始容量, 没有给初始容量时候,默认给个
     */
    private static final int DEFAULT_INIT_CAP = 1;


    public MyArrayList() {
        this(DEFAULT_INIT_CAP);
    }


    public MyArrayList(int initCap) {
        this.data = (E[]) new Object[initCap];
        this.size = 0;
    }


    /**
     * 在末尾插入
     *
     * @param e 插入的元素
     */
    public void addLast(E e) {
        // 底层数组是否满了,如果满了需要扩容
        if (size == data.length) {
            // 扩到两倍
            resize(2 * size);
        }

        // 在末尾插入,增大size
        data[size] = e;
        size++;
    }


    /**
     * 在指定位置插入
     *
     * @param index 要插入的位置
     * @param e     插入的元素
     */
    public void add(int index, E e) {
        // 检查插入索引越界
        checkPositionIndex(index);

        // 底层数组是否满了,如果满了需要扩容
        if (size == data.length) {
            resize(2 * size);
        }

        // 搬移数据 data[index..] -> data[index+1..]
        System.arraycopy(data, index,
                data, index + 1,
                size - index);
        // 插入,增大size
        data[index] = e;
        size++;
    }


    /**
     * 在开始插入
     *
     * @param e 插入的元素
     */
    public void addFirst(E e) {
        // 特殊情况的指定位置插入
        add(0, e);
    }


    /**
     * 删除最后一个
     *
     * @return 删除的元素
     */
    public E removeLast() {
        // 空数组不能删除
        if (size == 0) {
            throw new NoSuchElementException();
        }
        // 是否可以缩容
        if (size == data.length / 4) {
            resize(size / 2);
        }

        E deletedVal = data[size - 1];
        // 删除最后一个元素, 要置为null, 否则不会被垃圾回收
        data[size - 1] = null;
        size--;

        return deletedVal;
    }

    /**
     * 删除index位置的元素
     *
     * @param index 索引
     * @return 删除的远古三
     */
    public E remove(int index) {
        // 检查索引越界
        checkElementIndex(index);

        int cap = data.length;
        // 可以缩容，节约空间
        if (size == cap / 4) {
            resize(cap / 2);
        }

        E deletedVal = data[index];
        // 搬移数据 data[index+1..] -> data[index..]
        System.arraycopy(data, index + 1,
                data, index,
                size - index - 1);

        // 置为null size--
        data[size - 1] = null;
        size--;

        return deletedVal;
    }

    /**
     * 删除第一个
     *
     * @return 删除的元素
     */
    public E removeFirst() {
        // 直接调用remove方法, index=0
        return remove(0);
    }


    /**
     * 修改index位置的元素
     *
     * @param index   索引
     * @param element 新元素
     * @return 旧元素
     */
    public E set(int index, E element) {
        // 检查索引越界
        checkElementIndex(index);
        // 修改数据
        E oldVal = data[index];
        data[index] = element;
        return oldVal;
    }


    /**
     * 查询index位置的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        // 检查索引越界
        checkElementIndex(index);

        return data[index];
    }

    // 工具方法
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 改变容量, 修改的是底层数组的长度, 和我们实现的数组无关, 是无感知的
     *
     * @param newCap 修改后的容量
     */
    private void resize(int newCap) {
        // 容量不能小于当前
        if (size > newCap) {
            return;
        }
        E[] temp = (E[]) new Object[newCap];

        // 搬运到新数组
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        // System.arraycopy(data, 0, temp, 0, size);
        data = temp;
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
            private int p = 0;

            @Override
            public boolean hasNext() {
                return p != size;
            }

            @Override
            public E next() {
                return data[p++];
            }
        };

    }


}



