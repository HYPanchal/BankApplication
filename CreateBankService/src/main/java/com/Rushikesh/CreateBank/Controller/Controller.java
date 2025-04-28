package com.Rushikesh.CreateBank.Controller;

import com.Rushikesh.CreateBank.Entity.Bank;
import com.Rushikesh.CreateBank.Services.CrudServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/bank")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private CrudServices crud;

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getById(@PathVariable int id){
        return ResponseEntity.ok((Bank) crud.getBankById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Bank>> getAll(){
        return ResponseEntity.ok(crud.getAllBank());
    }

    @PostMapping()
    public ResponseEntity<Bank> save(@RequestBody Bank bank){
        return ResponseEntity.ok(crud.saveBank(bank));
    }

    @PutMapping()
    public ResponseEntity<Bank> update(@RequestBody Bank bank){
        return ResponseEntity.ok((Bank) crud.updateBank(bank));
    }

    @DeleteMapping()
    public ResponseEntity<Bank> delete(@RequestBody Bank bank){
        return ResponseEntity.ok(crud.deleteBank(bank));
    }
}
