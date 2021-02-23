package com.javastudio.cdi.service;

import com.javastudio.cdi.api.EmployeeService;
import com.javastudio.cdi.dao.EmployeeRepository;

import javax.inject.Inject;

public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeRepository repository;

    @Override
    public boolean ok() {
        return repository.ok();
    }
}
