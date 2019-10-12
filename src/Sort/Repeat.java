package Sort;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhzh_cheng
 * @create 2019-10-12 15:02
 */
public class Repeat {

    public static void main(String[] args) {
        reapeatOfString("adfsfdsadfwetwfsdadwe");
    }

    /**
     * 字符串中重复个数的统计
     * @param str
     * @return
     */
    public static String reapeatOfString(String str){
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if(map.get(aChar)==null){
              map.put(aChar,1);
            }else{
                Integer intValue = map.get(aChar);
                intValue++;
                map.put(aChar,intValue);
            }
        }
        Iterator<Character> iterator =  map.keySet().iterator();
        while(iterator.hasNext()){
            Character key = iterator.next();
            Integer counts= map.get(key);
            System.out.println(key + " : " + counts);
        }
        return null;
    }


    /**
     * 正则表达式的使用
     * @param str
     * @return
     */
    public static boolean isNum(String str){
        String reg = "^[0-9]$";
        if (reg.matches(str)) {
            System.out.println("字符串中含有数字");
            return true;
        }else{
            System.out.println("字符串中没有数字");
            return false;
        }
    }


}
