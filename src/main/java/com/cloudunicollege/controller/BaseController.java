package com.cloudunicollege.controller;

/**
 * Created by u6031313 on 6/29/2015.
 * Content:
 */

import org.springframework.stereotype.Controller;
import org.slf4j.LoggerFactory;

@Controller
public class BaseController {

    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

}