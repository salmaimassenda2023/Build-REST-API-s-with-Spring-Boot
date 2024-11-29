package com.example.demospring.Service.impl;
import com.example.demospring.Entity.Employe;
import com.example.demospring.Mapper.EmployeMapper;
import com.example.demospring.Repository.EmployeRepository;
import com.example.demospring.Service.EmployeService;
import com.example.demospring.dto.EmployeDTO;
import com.example.demospring.exception.RessourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepository employeRepository;

    @Autowired
    public  EmployeServiceImpl(EmployeRepository employeRepository){
        this.employeRepository=employeRepository;
    }

    @Override
    public EmployeDTO createEmploye(EmployeDTO employeDTO) {
        Employe employe = EmployeMapper.mapToEmploye(employeDTO);
        Employe employeSaved=employeRepository.save(employe);
        return EmployeMapper.mapToEmployeDTO(employeSaved);
    }

    @Override
    public EmployeDTO updateEmploye(Integer id, EmployeDTO newEmploye) {
        Employe employe = employeRepository.findById(id)
                .orElseThrow(()->new RessourceNotFoundException("Employee not found with ID: "+id));
        employe.setFirstName(newEmploye.getFirstName());
        employe.setLastName(newEmploye.getLastName());
        employe.setEmail(newEmploye.getEmail());

        Employe employeUpdated=employeRepository.save(employe);

        return EmployeMapper.mapToEmployeDTO(employeUpdated);
    }

    @Override
    public void deleteEmploye(Integer id) {
        Employe employeToDelete= employeRepository.findById(id)
                .orElseThrow( ()->new RessourceNotFoundException("Employee not found with ID: "+id));
        employeRepository.delete(employeToDelete);

    }

    @Override
    public EmployeDTO getEmployeById(Integer id) {
        Employe employe = employeRepository.findById(id)
                .orElseThrow( ()->new RessourceNotFoundException("Employee not found with ID: "+id));
        return EmployeMapper.mapToEmployeDTO(employe);
    }

    @Override
    public List<EmployeDTO> getAllEmployes() {
        List<Employe>employes=employeRepository.findAll();
        List<EmployeDTO>employeDTOS=employes.stream()
                .map( e -> EmployeMapper.mapToEmployeDTO(e)).collect(Collectors.toList());
        return employeDTOS;
    }
}
