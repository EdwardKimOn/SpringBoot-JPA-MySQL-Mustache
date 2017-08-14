package com.example.demo2.repository;

import com.example.demo2.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Integer> {

    public Data findByNrp(int nrp);
}
