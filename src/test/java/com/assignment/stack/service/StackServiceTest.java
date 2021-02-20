package com.assignment.stack.service;

import com.assignment.stack.exceptions.IndexOutOfBoundException;
import com.assignment.stack.exceptions.StackEmptyException;
import com.assignment.stack.exceptions.StackFullException;
import com.assignment.stack.model.SimpleStack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author adarshbajpai
 * @created 20/02/2021
 */
@RunWith(MockitoJUnitRunner.class)
public class StackServiceTest {

    @Mock
    private SimpleStack<Integer> simpleStack;

    @InjectMocks
    private StackService stackService;

    @Test
    public void pushElement() throws StackFullException {
        try {
            stackService.pushElement(null);
        }catch (IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(),Messages.PUSH_ELEMENT_NOT_PROVIDED);
        }
        doNothing().when(simpleStack).push(anyInt());
        doThrow(new StackFullException()).when(simpleStack).push(eq(2));
        try {
            stackService.pushElement(2);
        }catch (StackFullException e){
            Assert.assertEquals(e.getMessage(),StackFullException.ERROR_MESSAGE);
        }
        stackService.pushElement(1);
        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(simpleStack,times(2)).push(integerArgumentCaptor.capture());
        Assert.assertEquals(new Integer(2),integerArgumentCaptor.getAllValues().get(0));
        Assert.assertEquals(new Integer(1),integerArgumentCaptor.getAllValues().get(1));
    }

    @Test
    public void getElement() throws IndexOutOfBoundException {
        when(simpleStack.get(anyInt())).thenThrow(new IndexOutOfBoundException());
        try{
            stackService.getElement(null);
        }catch (IllegalArgumentException e){
            Assert.assertEquals(Messages.INDEX_REQUIRED,e.getMessage());
        }
        try{
            stackService.getElement(-1);
        }catch (IndexOutOfBoundException e){
            Assert.assertEquals(IndexOutOfBoundException.ERROR_MESSAGE,e.getMessage());
        }
        doReturn(10).when(simpleStack).get(anyInt());
        Integer res = stackService.getElement(2);
        Assert.assertEquals(new Integer(10),res);
        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(simpleStack,times(2)).get(integerArgumentCaptor.capture());
        Assert.assertEquals(new Integer(-1),integerArgumentCaptor.getAllValues().get(0));
        Assert.assertEquals(new Integer(2),integerArgumentCaptor.getAllValues().get(1));
    }

    @Test
    public void popElement() throws StackEmptyException {
        when(simpleStack.pop()).thenThrow(new StackEmptyException());
        try {
            stackService.popElement();
        }catch (StackEmptyException e){
            Assert.assertEquals(StackEmptyException.ERROR_MESSAGE,e.getMessage());
        }
        doReturn(5).when(simpleStack).pop();
        Integer res = stackService.popElement();
        Assert.assertEquals(new Integer(5),res);
        verify(simpleStack,times(2)).pop();
    }
}