package myarithmetic.array;

/**
 * @author zhzh_cheng
 * @create 2019-10-12 15:32
 * 手写数组
 */
public class MyArray {

    private int[] data;
    private int size;

    /**
     * @param capacity 数组容量
     */
    public MyArray(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造器,初始化数组的容量
     */
    public MyArray(){
        this(10);
    }

    /**
     * 获取容器中元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取容器的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回的数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个元素
     * @param e
     */
    public void addLast(int e){
        add(size,e);
    }

    /**
     * 向所有元素前添加一个元素
     * @param e
     */
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 在 第 index 的 位置插入一个新元素
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if(size == data.length){
            throw new IllegalArgumentException("Add index failed,because array is full!");
        }
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add index failed,because index required >=0 &&　<= size");
        }
        // 给所要插入的元素腾位置
        for(int i=size-1;i>index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取 index 位置索引的元素
     * @param index
     * @return
     */
    int get(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add index failed,because index required >=0 &&　<= size");
        }
        return data[index];
    }

    /**
     * 修改 index 索引位置的元素
     * @param index
     * @param e
     * @return
     */
    int set(int index,int e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add index failed,because index required >=0 &&　<= size");
        }
        return data[index] = e;
    }

    /**
     * 查找数组中是否包含当前元素
     * @param e
     * @return
     */
    public boolean contains(int e){
        for (int i = 0; i <size ; i++) {
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素 e 在数组中的索引
     * @param e
     * @return
     */
    public int find(int e){
        for (int i = 0; i <size ; i++) {
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除索引位置的元素并且返回当前删除的元素
     * @param index
     * @return
     */
    public int remove(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add index failed,because index required >=0 &&　<= size");
        }
        int ret = data[index];
        // 诺坑
        for (int i = index+1;i<size;i++) {
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }

    public int removeFirst(){
       return remove(0);
    }

    public int removeLast(){
        return remove(size-1);
    }

    /**
     * 删除数组中的元素
     * @param e
     */
    public void removeElement(int e){
        int index = find(e);
        if(index!=-1){
            remove(index);
        }
    }
}
