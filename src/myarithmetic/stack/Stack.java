package myarithmetic.stack;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-10-16 13:32
 */
public class Stack {
    int arr[];
    int top;

    public Stack(){
        arr = new int[5];
        top = -1;
    }

    public Stack(int max){
        arr = new int[max];
        top = -1;
    }

    public void add(int value){
        arr[++top] = value;
    }

    public int pop(){
        return arr[top--];
    }

    public int peek(){
        return arr[top];
    }
}
