package com.example.demospring.Mapper;

import com.example.demospring.Entity.Employe;
import com.example.demospring.dto.EmployeDTO;

public class EmployeMapper {

    public static EmployeDTO mapToEmployeDTO(Employe employe){
        return new EmployeDTO(
                employe.getId(),
                employe.getFirstName(),
                employe.getLastName(),
                employe.getEmail()
        );
    }
    //
    public static Employe mapToEmploye(EmployeDTO employe){
        return new Employe(
                employe.getId(),
                employe.getFirstName(),
                employe.getLastName(),
                employe.getEmail()
        );
    }

}
