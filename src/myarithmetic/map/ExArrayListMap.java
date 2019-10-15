package myarithmetic.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-10-15 17:44
 */
public class ExArrayListMap<Key,Value> {
    List<Entry<Key,Value>> tables = new ArrayList<Entry<Key,Value>>();

    public void put(Key key,Value value){
        // 判断 key 是否重复
        Entry existEntry = getEntry(key);
    }

    public Entry getEntry(Key key) {
        for (Entry<Key, Value> entry : tables) {
            if(entry.key.equals(key)){
                return entry;
            }
        }
        return null;
    }

    class Entry<Key,Value>{

        Key key;

        Value value;

        public Entry(Key key,Value value){
            this.key = key;
            this.value = value;
        }
    }
}
