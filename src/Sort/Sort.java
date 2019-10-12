package Sort;

import sun.tools.jar.Main;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-10-11 21:36
 */
public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{3,1,2,4,7,5};
        System.out.println("选择排序");
        selectSort(array);
        System.out.println("冒泡排序");
        bubbleSort(array);


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
    }


    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i]>array[j]) {
                    swap(array,i,j);
                }
            }
        }
    }

    private static void swap(int[] array, int index, int index2) {
        int temp = array[index];
        array[index] = array[index2];
        array[index2] = temp;
    }


    public static void bubbleSort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            boolean isSort = true;
            for (int j = 0; j <i ; j++) {
                if(array[i]>array[j]){
                    swap(array,i,j);
                    isSort = false;
                }
            }
            if(isSort){
                break;
            }
        }

    }




}
