package com.bill.test.try100;

import java.util.ArrayList;  
import java.util.List;  
import java.util.EmptyStackException;  
 
public class MyStack<E extends Object> {  
   private List<E> pool = new ArrayList<E>();  
 
   public MyStack() {  
   }  
 
   public void clear() {  
       pool.clear();  
   }  
 
   public boolean isEmpty() {  
       return pool.isEmpty();  
   }  
 
   /** 
    * 获取栈顶元素 
    * */  
   public E getTopObjcet() {  
       if (isEmpty()) {return null;}  
       return pool.get(0);  
   }  
 
   /** 
    * 弹出栈操作 
    * */  
   public E pop() {  
       if (isEmpty()) {throw new EmptyStackException();}  
       return pool.remove(pool.size() - 1);  
   }  
 
   /** 
    * 压入栈 
    * */  
   public void push(E e) {  
       //if (isEmpty()) {throw new EmptyStackException();}  
       pool.add(e);  
   }  
 
   /** 
    * 获取当前栈大小 
    * */  
   public int getStatckSize() {  
       //if (isEmpty()) {throw new EmptyStackException();}  
       return pool.size();  
   }  
 
}  
