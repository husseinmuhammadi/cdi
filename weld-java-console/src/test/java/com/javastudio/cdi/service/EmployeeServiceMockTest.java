package com.javastudio.cdi.service;

import com.javastudio.cdi.api.EmployeeService;
import com.javastudio.cdi.dao.EmployeeRepository;
import org.jboss.weld.junit.MockBean;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;

@EnableWeld
public class EmployeeServiceMockTest {

    @WeldSetup
    WeldInitiator weldInitiator = WeldInitiator
            .from(EmployeeService.class, EmployeeServiceImpl.class)
            .addBeans(mockEmployeeRepository())
            .build();

    static Bean<?> mockEmployeeRepository() {
        return MockBean.builder()
                .types(EmployeeRepository.class)
                .scope(ApplicationScoped.class)
                .create(
                        ctx -> Mockito.when(Mockito.mock(EmployeeRepository.class).ok()).thenReturn(false).getMock()
                ).build();
    }

    @Inject
    EmployeeService employeeService;

    @Test
    void test() {
        System.out.println(employeeService.ok());
    }
}
