package com.example.demo2.controller;

import com.example.demo2.model.Data;
import com.example.demo2.model.Response;
import com.example.demo2.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DataAPIController {

    private DataService dataService;

    @Autowired
    public DataAPIController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/getAllData")
    public Response<ArrayList<Data>> getAllData() {
        return new Response<>(HttpStatus.OK, dataService.getAllData());
    }

    @GetMapping("/getData/{id}")
    public Response<Data> getData(@PathVariable int id) {
        return new Response<>(HttpStatus.OK, dataService.getData(id));
    }

    @GetMapping("/getDataByNrp/{nrp}")
    public Response<Data> getDataByNrp(@PathVariable int nrp) {
        return new Response<>(HttpStatus.OK, dataService.getDataByNrp(nrp));
    }

    @PostMapping("/saveData")
    public Response<Data> saveData(@RequestBody Data data) {
        return new Response<>(HttpStatus.OK, dataService.saveData(data));
    }

    @DeleteMapping("/deleteData/{id}")
    public Response<Void> deleteData(@PathVariable int id) {
        dataService.deleteData(id);
        return new Response<>(HttpStatus.OK);
    }
}
