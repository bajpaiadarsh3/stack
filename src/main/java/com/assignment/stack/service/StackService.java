package com.assignment.stack.service;

import com.assignment.stack.exceptions.IndexOutOfBoundException;
import com.assignment.stack.exceptions.StackEmptyException;
import com.assignment.stack.exceptions.StackFullException;
import com.assignment.stack.model.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static com.assignment.stack.service.Messages.INDEX_REQUIRED;
import static com.assignment.stack.service.Messages.PUSH_ELEMENT_NOT_PROVIDED;




@Service
public class StackService {

    @Autowired
    private Stack<Integer> stack;


    public void pushElement(Integer ele) throws StackFullException {
        Assert.notNull(ele,PUSH_ELEMENT_NOT_PROVIDED);
        stack.push(ele);
    }

    public Integer getElement(Integer index) throws IndexOutOfBoundException {
        Assert.notNull(index,INDEX_REQUIRED);
        return stack.get(index);
    }

    public Integer popElement() throws StackEmptyException {
        return stack.pop();
    }
}
