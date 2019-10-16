package myarithmetic.map;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-10-16 11:17
 */
public class ExHashMap<K,V> implements ExtMap<K,V>{

    Node<K, V>[] table = null;
    int size;
    float default_load_capacity = 0.75f;
    static int default_initial_capacity = 16;// table 默认长度的大小






    @Override
    public V put(K k, V v) {
        if (table==null) {
            table = new Node[default_initial_capacity];
        }
        if (size>=default_initial_capacity*default_load_capacity) {
            resize();
        }

        return null;
    }

    /**
     * 扩容
     */
    public void resize() {
        Node[] newTables = new Node[default_initial_capacity<<1];

        for (int i = 0; i <table.length ; i++) {
            Node<K,V> oldNode = table[i];
            while (oldNode!=null){
                table[i] = null;
                K oldKey =oldNode.key;
                int index = getIndex(oldKey,newTables.length);
                Node oldnext = oldNode.next;
                oldNode.next = newTables[index];
                oldNode = oldnext;
            }
        }
        table = newTables;
        default_initial_capacity = newTables.length;
        newTables = null;
    }

    public int getIndex(K k, int length) {
        int index = k == null ? 0 : k.hashCode()% length;
        return index;
    }

    @Override
    public V get(K k) {
        Node<K,V> node = getNode(table[getIndex(k,default_initial_capacity)],k);
        return node == null? null : node.value;
    }

    public Node<K,V> getNode(Node<K,V> node, K k) {
        while (node!=null) {
            if (node.getKey().equals(k)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    class Node<K,V> implements Entry<K,V>{
        private K key;
        private V value;
        private Node<K,V> next;

        public Node(K key,V value,Node<K,V> next){
            super();
            this.key = key;
            this.value = value;
            this.next = next;
        }



        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;

        }
    }


}
