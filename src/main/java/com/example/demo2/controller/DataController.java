package com.example.demo2.controller;

import com.example.demo2.model.Data;
import com.example.demo2.model.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
public class DataController {

    private RestTemplate restTemplate;

    public DataController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        String title = "Index";
        String message = "Hello spring boot + jpa + mustache";
        String url = "http://localhost:8080/getAllData";

        Response<ArrayList<Data>> response = restTemplate.getForObject(url, Response.class);

        modelMap.addAttribute("title", title);
        modelMap.addAttribute("message", message);
        modelMap.addAttribute("data", response.getData());

        return "index";
    }

    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        String title = "Index - Add";
        String message = "Hello spring boot + jpa + mustache";

        modelMap.addAttribute("title", title);
        modelMap.addAttribute("message", message);

        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Data data, BindingResult result, ModelMap modelMap) {
        String title = "Index - Add - Result";
        String message = "Hello spring boot + jpa + mustache";
        String uri = "http://localhost:8080/saveData";

        modelMap.addAttribute("title", title);
        modelMap.addAttribute("message", message);

        if (data.getId() != 0)
            modelMap.addAttribute("messages", "Data success edited");
        else
            modelMap.addAttribute("messages", "Data success saved");

        if (result.hasErrors())
            return "add";

        Response<Data> response = restTemplate.postForObject(uri, data, Response.class);
        modelMap.addAttribute("data", response.getData());

        if (response.getData() == null)
            modelMap.addAttribute("messages", "Data failed saved");

        return "add-response";
    }

    @GetMapping("/edit/{id}")
    public String show(@PathVariable int id, ModelMap modelMap) {
        String title = "Index - Edit";
        String message = "Hello spring boot + jpa + mustache";
        String uri = "http://localhost:8080/getData/" + id;

        Response<Data> response = restTemplate.getForObject(uri, Response.class);

        modelMap.addAttribute("data", response.getData());
        modelMap.addAttribute("title", title);
        modelMap.addAttribute("message", message);

        return "add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        final String uri = "http://localhost:8080/deleteData/" + id ;
        restTemplate.delete(uri);

        return "redirect:/";
    }
}
