package com.assignment.stack.controller;

import com.assignment.stack.IntegrationTest;
import com.assignment.stack.exceptions.IndexOutOfBoundException;
import com.assignment.stack.exceptions.StackEmptyException;
import com.assignment.stack.exceptions.StackFullException;
import org.assertj.core.internal.bytebuddy.matcher.EqualityMatcher;
import org.assertj.core.internal.bytebuddy.matcher.StringMatcher;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author adarshbajpai
 * @created 20/02/2021
 */
@SpringBootTest
@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StackControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    HttpHeaders headers = new HttpHeaders();

    @Test
    @Order(1)
    public void pushElementSuccess() throws Exception {
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        RequestBuilder requestBuilder = post(Endpoints.PUSH)
                .queryParam("data","2")
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
        this.mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
        this.mockMvc.perform(requestBuilder).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(matchErrorMessage(StackFullException.ERROR_MESSAGE));
    }

    @Test
    public void pushElementWrongContentType() throws Exception {
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
        RequestBuilder requestBuilder = post(Endpoints.PUSH)
                .queryParam("data","2")
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));
    }

    @Test
    public void pushElementNoContentType() throws Exception {
        RequestBuilder requestBuilder = post(Endpoints.PUSH)
                .queryParam("data","2")
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));
    }

    @Test
    public void popElementWrongContentType() throws Exception {
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
        RequestBuilder requestBuilder = delete(Endpoints.POP)
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));
    }

    @Test
    public void popElementNoContentType() throws Exception {
        RequestBuilder requestBuilder = delete(Endpoints.POP)
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));
    }

    @Test
    @Order(2)
    public void getElementSuccess() throws Exception {
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        RequestBuilder requestBuilder = get(Endpoints.GET)
                .param("index","0")
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$['data']",new EqualityMatcher<>(2)).exists());
    }

    @Test
    public void getElementWrongIndex() throws Exception {
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        RequestBuilder requestBuilder = get(Endpoints.GET)
                .param("index","-1")
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is(HttpStatus.NOT_ACCEPTABLE.value()))
                .andExpect(matchErrorMessage(IndexOutOfBoundException.ERROR_MESSAGE));
        requestBuilder = get(Endpoints.GET)
                .param("index","10")
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is(HttpStatus.NOT_ACCEPTABLE.value()))
                .andExpect(matchErrorMessage(IndexOutOfBoundException.ERROR_MESSAGE));
    }

    ResultMatcher matchErrorMessage(String value){
        return jsonPath("$['errorMessage']",new StringMatcher(value, StringMatcher.Mode.CONTAINS)).exists();
    }
    @Test
    @Order(3)
    public void popElement() throws Exception {
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        RequestBuilder requestBuilder = delete(Endpoints.POP)
                .headers(headers);
        this.mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
        this.mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
        this.mockMvc.perform(requestBuilder).andExpect(status().is(HttpStatus.NOT_ACCEPTABLE.value()))
        .andExpect(matchErrorMessage(StackEmptyException.ERROR_MESSAGE));
    }

}