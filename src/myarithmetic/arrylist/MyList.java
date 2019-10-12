package myarithmetic.arrylist;

/**
 * @author zhzh_cheng
 * @create 2019-10-12 17:10
 */
public interface MyList<E> {
    public void add(E e);
    public void add(int index,E e);
    public void remove(int index);
    public void remove(E e);
    public int getSize();
    public Object get(int index);
}
