package com.example.demospring.Service;

import com.example.demospring.dto.EmployeDTO;

import java.util.List;

public interface EmployeService {
    EmployeDTO createEmploye(EmployeDTO employeDTO);
    EmployeDTO updateEmploye(Integer id, EmployeDTO newEmploye);
    void deleteEmploye(Integer id);
    EmployeDTO getEmployeById(Integer id);
    List<EmployeDTO>getAllEmployes();
}
