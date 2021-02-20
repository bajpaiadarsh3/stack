package com.assignment.stack.model;

import com.assignment.stack.exceptions.IndexOutOfBoundException;
import com.assignment.stack.exceptions.StackEmptyException;
import com.assignment.stack.exceptions.StackFullException;
import org.springframework.util.Assert;

import java.io.Serializable;



public class SimpleStack<T extends Serializable> implements Stack<T>{

    private final int capacity;
    private int top=-1;
    private final Object[] elements;

    public SimpleStack(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    /**
     * <p>
     * push operation allows a new object to be pushed in memory
     * and will always be at the top of the stack allowing LIFO
     * structuring of the data.
     * </p>
     * <p>
     * will throw a {@link StackFullException} if stack is full.
     * </p>
     *
     * @param obj generic obj need to push
     */
    @Override
    public <S extends T> void push(S obj) throws StackFullException {
        Assert.notNull(obj,"Object to push in stack is required");
        if(top == capacity-1){
            throw new StackFullException();
        }
        synchronized (this){
            elements[++top] = obj;
        }
    }

    /**
     * <p>
     * pop operation will remove one element from top of the stack
     * and will return the object to the user.
     * </p>
     * <p>
     * will throw a {@link StackEmptyException} if pop is call on en empty stack
     * </p>
     *
     * @return generic object on the top
     */
    @Override
    @SuppressWarnings("unchecked")
    public <S extends T> S pop() throws StackEmptyException {
        if(top == -1) {
            throw new StackEmptyException();
        }
        synchronized (this){
            return (S) elements[top--];
        }
    }

    /**
     * <p>
     * get operation will return the element present at a particular given index,
     * it will not remove element from the stack.
     * </p>
     * <p>
     * will throw a {@link ArrayIndexOutOfBoundsException} if element not exists.
     * </p>
     *
     * @param index index of the element.
     * @return generic object present at location index.
     * @throws ArrayIndexOutOfBoundsException if element is not present at index.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <S extends T> S get(int index) throws IndexOutOfBoundException {
        if(index < 0 || index > top){
            throw new IndexOutOfBoundException();
        }
        return (S) elements[index];
    }
}
