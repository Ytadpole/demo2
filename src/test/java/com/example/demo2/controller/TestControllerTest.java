package com.example.demo2.controller;

import com.example.demo2.Demo2Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author yangs
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Demo2Application.class)
public class TestControllerTest {
    @Autowired
    private ApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }

    @Test
    public void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=bill")
            .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());

    }

    @Test
    public void user() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/user"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void userByName() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/jack"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void config() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/config"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("结果：" + result);
    }
}