package myarithmetic.map;

import java.util.LinkedList;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-10-15 19:59
 */
public class LinkListMap {

    class Entry {

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        Object key;
        Object value;
    }


    LinkedList<Entry>[] tables = new LinkedList[998];

    private int size;

    public void put(Object key,Object value){
        Entry newEntry = new Entry(key, value);
        int hash = getHash(key);

        LinkedList<Entry> entryLinkedList = tables[hash];
        if (entryLinkedList==null) {
            // 数组中没有存放元素
            LinkedList<Entry> linkedList = new LinkedList<>();
            linkedList.add(newEntry);
            tables[hash] = linkedList;
        }else {
            for (Entry entry : entryLinkedList) {
                if (entry.key.equals(key)) {
                    // hash code 相同对象也相同
                    entry.value = value;
                }else {
                    // hash code 相同 对象不同
                    entryLinkedList.add(newEntry);
                }
            }
        }
        size++;
    }

    public int getHash(Object key) {
        int hashCode = key.hashCode();
        int hash = hashCode%tables.length;
        return hash;
    }

    public Object get(Object key) {
        return getEntry(key).value;
    }

    public Entry getEntry(Object key) {
        // hashCode
        int hash = getHash(key);
        LinkedList<Entry> listEntry = tables[hash];
        if (listEntry != null) {
            for (Entry entry : listEntry) {
                if (entry.key.equals(key)) {
                    return entry;
                }
            }
        }
        return null;
    }

}
