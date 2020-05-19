package com.vipin.recipeapp.controllers;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping({"", "/", "index"})
    public String index(){
        return "index";
    }
}
