package com.assignment.stack.controller;

import com.assignment.stack.exceptions.IndexOutOfBoundException;
import com.assignment.stack.exceptions.StackEmptyException;
import com.assignment.stack.exceptions.StackFullException;
import com.assignment.stack.service.StackService;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adarshbajpai
 * created 19/02/2021
 */
@RestController
public class StackController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StackService stackService;


    @Timed
    @RequestMapping(path = Endpoints.PUSH,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_HTML_VALUE},
            method = RequestMethod.POST)
    public ResponseEntity<Response> pushElement(@RequestParam("data") Integer element){
        try{
            LOG.info("New request received to push element "+element);
            stackService.pushElement(element);
            return new ResponseEntity<>(new Response(element),HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            LOG.error("wrong argument : ",e);
            return new ResponseEntity<>(new Response(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
        catch (StackFullException stackFullException){
            LOG.error("Error pushing element : ", stackFullException);
            return new ResponseEntity<>(new Response(stackFullException.getMessage()),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Timed
    @RequestMapping(path = Endpoints.POP,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_HTML_VALUE},
            method = RequestMethod.DELETE)
    public ResponseEntity<Response> popElement(){
        try {
            Integer ele = stackService.popElement();
            return new ResponseEntity<>(new Response(ele),HttpStatus.OK);
        }catch (StackEmptyException stackEmptyException){
            LOG.error("Error pop element : ", stackEmptyException);
            return new ResponseEntity<>(new Response(stackEmptyException.getMessage()),HttpStatus.NOT_ACCEPTABLE);
        }
    }



    @Timed
    @RequestMapping(path = Endpoints.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_HTML_VALUE},
            method = RequestMethod.GET)
    public ResponseEntity<Response> popElement(@RequestParam int index){
        try {
            Integer ele = stackService.getElement(index);
            return new ResponseEntity<>(new Response(ele),HttpStatus.OK);
        }catch (IndexOutOfBoundException indexOutOfBoundException){
            LOG.error("Error getting element : ", indexOutOfBoundException);
            return new ResponseEntity<>(new Response(indexOutOfBoundException.getMessage()),HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
