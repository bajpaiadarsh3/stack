package com.assignment.stack.model;

import com.assignment.stack.exceptions.IndexOutOfBoundException;
import com.assignment.stack.exceptions.StackEmptyException;
import com.assignment.stack.exceptions.StackFullException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author adarshbajpai
 * @created 20/02/2021
 */

@RunWith(MockitoJUnitRunner.class)
public class SimpleStackTest {

    private SimpleStack<Integer> simpleStackMock;
    private final int capacity = 10;

    @Before
    public void createSetup(){
        simpleStackMock = new SimpleStack<>(capacity);
    }

    @Test
    public void pushSuccessTest() throws StackFullException, IndexOutOfBoundException {
        for(int i= 0; i < capacity; ++i){
            simpleStackMock.push(i);
        }
        for(int i = 0; i < capacity; ++i){
            Assert.assertEquals(new Integer(i),simpleStackMock.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void pushNullShouldFail() throws StackFullException {
            simpleStackMock.push(null);
    }

    @Test(expected = StackFullException.class)
    public void pushOnFullShouldFail() throws StackFullException {
        for(int i= 0; i < capacity+1; ++i){
            simpleStackMock.push(i);
        }
    }

    @Test
    public void popSuccess() throws StackFullException, StackEmptyException {
        for(int i= 0; i < capacity; ++i){
            simpleStackMock.push(i);
        }
        for(int i = capacity-1; i>=0; --i){ //ensure lifo ordering
            Assert.assertEquals(new Integer(i),simpleStackMock.pop());
        }
    }

    @Test(expected = StackEmptyException.class)
    public void popOnEmptyShouldFail() throws StackEmptyException {
       simpleStackMock.pop();
    }

    @Test
    public void getSuccess() throws StackFullException, IndexOutOfBoundException {
        for(int i= 0; i < capacity; ++i){
            simpleStackMock.push(i);
        }
        for(int i = 0; i< capacity;++i){
            Assert.assertEquals(new Integer(i),simpleStackMock.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundException.class)
    public void getNegativeIndexShouldFail() throws IndexOutOfBoundException {
       simpleStackMock.get(-1);
    }

    @Test(expected = IndexOutOfBoundException.class)
    public void getNotPushedIndexShouldFail() throws IndexOutOfBoundException {
        simpleStackMock.get(2);
    }
}