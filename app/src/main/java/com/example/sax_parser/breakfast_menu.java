package com.example.sax_parser;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "breakfast_menu")
public class breakfast_menu {

    @ElementList(inline = true)
    protected List<food> food;

    public List<com.example.sax_parser.food> getFood() {
        return food;
    }

    public void setFood(List<com.example.sax_parser.food> food) {
        this.food = food;
    }
}
