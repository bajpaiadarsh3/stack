package com.assignment.stack.model;

import com.assignment.stack.exceptions.IndexOutOfBoundException;
import com.assignment.stack.exceptions.StackEmptyException;
import com.assignment.stack.exceptions.StackFullException;

import java.io.Serializable;


/**
 * Stack interface provide infra for basic operations
 *
 * @param <T> generic type.
 */
public interface Stack<T extends Serializable> {


    /**
     * <p>
     *      push operation allows a new object to be pushed in memory
     *      and will always be at the top of the stack allowing LIFO
     *      structuring of the data.
     * </p>
     * <p>
     *     will throw a {@link StackFullException} if stack is full.
     * </p>
     * @param obj generic obj need to push
     */
    <S extends T> void push(S obj) throws StackFullException;

    /**
     * <p>
     *      pop operation will remove one element from top of the stack
     *      and will return the object to the user.
     * </p>
     * <p>
     *     will throw a {@link StackEmptyException} if pop is call on en empty stack
     * </p>

     *
     * @return generic object on the top
     */
    <S extends T> S pop() throws StackEmptyException;


    /**
     *<p>
     *     get operation will return the element present at a particular given index,
     *     it will not remove element from the stack.
     *</p>
     * <p>
     *     will throw a {@link IndexOutOfBoundException} if element not exists.
     * </p>
     *
     * @param index index of the element.
     * @return  generic object present at location index.
     * @throws IndexOutOfBoundException if element is not present at index.
     */
    <S extends T> S get(int index) throws IndexOutOfBoundException;
}
