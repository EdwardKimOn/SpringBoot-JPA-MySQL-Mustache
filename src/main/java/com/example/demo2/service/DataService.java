package com.example.demo2.service;

import com.example.demo2.model.Data;
import com.example.demo2.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataService {

    private DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public ArrayList<Data> getAllData() {
        return new ArrayList<>(dataRepository.findAll());
    }

    public Data getData(int id) {
        return dataRepository.findOne(id);
    }

    public Data getDataByNrp(int nrp) {
        return dataRepository.findByNrp(nrp);
    }

    public Data saveData(Data data) {
        return dataRepository.save(data);
    }

    public void deleteData(int id) {
        dataRepository.delete(id);
    }
}
