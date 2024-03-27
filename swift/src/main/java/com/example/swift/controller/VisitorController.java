package com.example.swift.controller;

import com.example.swift.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VisitorController {
    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping("/visitorCount")
    @ResponseBody
    public int getVisitorCount() {
        return visitorService.getVisitorCount();
    }

    @GetMapping("/visit")
    public String visitEndpoint(@RequestHeader(value = "sec-ch-ua", defaultValue = "") String secChUa) {
        boolean isInIncognitoMode = secChUa.contains(";Incognito;");

            if (isInIncognitoMode) {
                visitorService.incrementVisitorCount(isInIncognitoMode);
                return "countedI";
            } else {
                try{
                visitorService.incrementVisitorCount();
                return "counted";}
                catch(Exception e){
                    return "countedE";
                }
            }
        }
    }

