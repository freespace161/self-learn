/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类UserAction.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年9月25日 下午4:05:57
 */
@Controller
@RequestMapping(value = "/user")
public class UserAction {

    @RequestMapping(value = "/login", method = { RequestMethod.GET })
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("user/user");

        mav.addObject("user", "hello");
        return mav;
    }
}
