package com.Rushikesh.UserService.Controller;

import com.Rushikesh.UserService.Entity.User;
import com.Rushikesh.UserService.Service.CrudServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class Controller {

    @Autowired
    private CrudServices crud;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id){
        return ResponseEntity.ok((User) crud.getUserById(id));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(crud.getAllUser());
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(crud.saveUser(user));
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok((User) crud.updateUser(user));
    }

    @DeleteMapping()
    public ResponseEntity<User> delete(@RequestBody User user){
        return ResponseEntity.ok(crud.deleteUser(user));
    }

    @GetMapping("/bankcode/{code}")
    public ResponseEntity<User> getByCode(@PathVariable String code){
        return ResponseEntity.ok(crud.getUserByBankCode(code));
    }
}