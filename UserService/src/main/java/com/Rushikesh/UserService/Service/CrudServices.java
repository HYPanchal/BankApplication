package com.Rushikesh.UserService.Service;

import com.Rushikesh.UserService.Entity.User;
import com.Rushikesh.UserService.ExceptionHandler.ResourceNotFoundException;
import com.Rushikesh.UserService.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudServices {
    @Autowired
    private UserRepo repo;

    public Object getUserById(int id){
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The User with id : " + id + " Not Found"));
    }

    public List<User> getAllUser(){
        return repo.findAll();
    }

    public User saveUser(User user){
        return repo.save(user);
    }

    public Object updateUser(User user){
        User tempuser = (User) this.getUserById(user.getId());

        if(tempuser != null){
            this.setAttribute(tempuser, user);
            repo.save(tempuser);
            return tempuser;
        }else {
            throw new ResourceNotFoundException("The User with id : "+user.getId()+" Not Found");
        }
    }

    public User deleteUser(User user){
        User tempuser = (User) this.getUserById(user.getId());

        if(tempuser != null){
            repo.delete(user);
            return tempuser;
        }else {
            throw new ResourceNotFoundException("The User with id : "+user.getId()+" Not Found");
        }
    }

    public User getUserByBankCode(String code){
        return repo.getBybankCode(code);
    }

    private void setAttribute(User oldUser, User newUesr){
        if(newUesr.getName() != null){oldUser.setName(newUesr.getName());}
        if(newUesr.getPassword() != null){oldUser.setPassword(newUesr.getPassword());}
        if(newUesr.getPhoneNumber() != null){oldUser.setPhoneNumber(newUesr.getPhoneNumber());}
        if(newUesr.getAddress() != null){oldUser.setAddress(newUesr.getAddress());}
        if(newUesr.getIsActive() != null){oldUser.setIsActive(newUesr.getIsActive());}
        if(oldUser.getBankCode() == null){oldUser.setBankCode(newUesr.getBankCode());}
    }
}
