package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllPaged(Pageable pageable) {
        Page<Employee> page = repository.findAll(pageable);
        return page.map(emp -> new EmployeeDTO(emp));
    }
}
