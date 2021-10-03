package com.example.errorsreporting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ErrorsReportingController {


    @RequestMapping("/errors")
    public List<String> findCities() {
        return new LinkedList<>();
    }
}