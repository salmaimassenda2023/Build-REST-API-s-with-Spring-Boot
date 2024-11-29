package com.example.demospring.Controller;
import com.example.demospring.Service.EmployeService;
import com.example.demospring.dto.EmployeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {
    private EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }
    // add Employee Rest Api
    @PostMapping
    public ResponseEntity<EmployeDTO>createEmploye(@RequestBody EmployeDTO employeDTO){

        return ResponseEntity.ok(employeService.createEmploye(employeDTO));

    }
    // get employe By Id Rest Api
    @GetMapping("/{id}")
    public ResponseEntity<EmployeDTO>getEmployeById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeService.getEmployeById(id));
    }
    // get all employe REST API
    @GetMapping
    public  ResponseEntity<List<EmployeDTO>>getAllEmployes(){
        return ResponseEntity.ok(employeService.getAllEmployes());
    }
    // update employee REST API
    @PutMapping("/{id}")
    public  ResponseEntity<EmployeDTO>updateEmploye(@PathVariable Integer id,@RequestBody EmployeDTO employeDTO){
        return ResponseEntity.ok(employeService.updateEmploye(id,employeDTO));
    }
    // remove employe Rest Api
    @DeleteMapping("/{id}")
    public ResponseEntity<String >deleteEmploye(@PathVariable Integer id){
        employeService.deleteEmploye(id);
        return ResponseEntity.ok("Employe is deleted successfuly ! ");
    }

}
