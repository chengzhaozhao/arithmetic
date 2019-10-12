package myarithmetic.arrylist;

import java.util.Arrays;
import java.util.Calendar;

/**
 * @author zhzh_cheng
 * @create 2019-10-12 17:12
 */
public class MyArrayList<E> implements MyList<E> {
    // 保存数据的数组
    private transient Object[] elements;
    //arrayList 的实际数量
    private int size;

    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int initCapacity){
       if(initCapacity<0){
           throw new IllegalArgumentException("Illegal Capacity "+ initCapacity);
       }
       // 初始化容量
       elements = new Object[initCapacity];
    }

    @Override
    public void add(Object obj) {
        ensureExplicitCapacity(size+1);
        elements[size++] = obj;
    }

    public void ensureExplicitCapacity(int minCapacity) {
        if (size == elements.length) {
            int oldCapacity = elements.length;
            int newCapacity = oldCapacity +(oldCapacity>>1);
            if(newCapacity<minCapacity){
                newCapacity = minCapacity;
            }
            Arrays.copyOf(elements,newCapacity);
        }
    }

    @Override
    public void add(int index, Object obj) {
        rangeIndex(index);
        ensureExplicitCapacity(size+1);
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index] = obj;
        size++;
    }

    public void rangeIndex(int index) {
        if(index>=size){
            throw new IndexOutOfBoundsException("数组下标越界");
        }
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(E e) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }
}
