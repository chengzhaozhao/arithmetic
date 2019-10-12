package Sort;

import java.util.*;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-10-12 8:25
 */
public class Exercise {

    public static final String STRING = "acdbesfasefseae";

    public static void main(String[] args) {
        strWithSort(STRING);
    }


    public static String strWithSort(String str){
        char[] arrayStr = STRING.toCharArray();
        Arrays.sort(arrayStr);
        System.out.println(arrayStr);

        Map<Character,Integer> map = new HashMap<Character, Integer>();

        for (char c : arrayStr) {
            if(map.get(c)==null){
                map.put(c,1);
            }else {
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }
        }

        Set<Character> characters = map.keySet();
        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()){
            Character key = iterator.next();
            System.out.println(key+" : " + map.get(key));
        }

        return null;
    }

}
