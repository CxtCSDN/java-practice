package MyStackText;

import ExpetionText.StackException;

public class MyStack {
    public void setSize(int size) {
        this.size = size;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
    private void check_capacity(){
        if(this.size == this.capacity){
            Object[] newVal = new Object[this.capacity*2];
            System.arraycopy(this.val,0,newVal,0,this.size);
            this.val = newVal;
            this.capacity *= 2;
            System.out.println("扩容成功");
        }
    }
    public void push(Object val){
        check_capacity();
        this.val[size] = val;
        this.size++;
        System.out.println("入栈成功");
    }
    public Object pop() throws StackException {
        if(this.size == 0){
            throw new StackException("当前栈中无元素");
        }
        Object ret = val[size-1];
        this.size--;
        System.out.println("出栈成功");
        return ret;
    }
    public Object peek() throws StackException{
        if(this.size == 0){
            throw new StackException("当前栈中无元素");
        }
        return val[size-1];
    }
    public boolean empty(){
        return this.size == 0;
    }
    private int size;
    private int capacity;
    private Object[] val;
    public MyStack(){
        this.size = 0;
        this.capacity = 4;
        val = new Object[4];
    }
    public MyStack(int capacity){
        this.size = 0;
        this.capacity = capacity;
        val = new Object[capacity];
    }

}
