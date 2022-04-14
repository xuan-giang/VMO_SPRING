package com.example.log4jexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class LogController {
    private static final Logger logger = LogManager.getLogger(LogController.class);

    private List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    @GetMapping("/")
    public String main(Model model) {

        logger.debug("Demo Log4j 2 - num : {}", () -> num);

        return "Running";
    }

}
