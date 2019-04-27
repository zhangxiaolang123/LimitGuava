package com.zxl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zxl on 2019/4/27.
 */
@RestController
public class LimitGuavaController {
    private static final Logger logger = LoggerFactory.getLogger(LimitGuavaController.class);
    @RequestMapping(value = "getUserList", method = RequestMethod.GET)
    public String getUserList() {
        String result = null;
        try {
            result = "success";
        }catch (Exception e){
            logger.error("error", e);
            return result;
        }
        return result;
    }
}
