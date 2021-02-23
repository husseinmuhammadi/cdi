package com.javastudio.cdi.service;

import com.javastudio.cdi.api.EmployeeService;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@EnableWeld
public class EmployeeServiceTest {

    @WeldSetup
    WeldInitiator weldInitiator = WeldInitiator.from(EmployeeService.class, EmployeeServiceImpl.class).build();

    @Inject
    EmployeeService employeeService;

    @Test
    void test() {
        employeeService.ok();
    }
}
