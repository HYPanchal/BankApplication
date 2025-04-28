package com.Rushikesh.CreateBank.Services;

import com.Rushikesh.CreateBank.Entity.Bank;
import com.Rushikesh.CreateBank.ExceptionHandler.ResourceNotFoundException;
import com.Rushikesh.CreateBank.Repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudServices{

    @Autowired
    private BankRepo repo;

    @Autowired
    private BankCodeGenerater bcg;

    public Object getBankById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The Bank with id : " + id + " Not Found"));
    }

    public List<Bank> getAllBank(){
        return repo.findAll();
    }

    public Bank saveBank(Bank bank){
        bank.setCode(bcg.randomCodeGenerator());
        return repo.save(bank);
    }

    public Object updateBank(Bank bank)
    {
        Bank tempbank = (Bank) this.getBankById(bank.getId());

        if (tempbank != null) {
            this.setAttribute(tempbank, bank);
            repo.save(tempbank);
            return tempbank;
        } else {
            throw new ResourceNotFoundException("The Bank with id : "+bank.getId()+" Not Found");
        }
    }

    public Bank deleteBank(Bank bank){
        Bank tempbank = (Bank) this.getBankById(bank.getId());

        if(tempbank != null){
            repo.delete(bank);
            return tempbank;
        }
        else {
            throw new ResourceNotFoundException("The Bank with id : "+bank.getId()+" Not Found");
        }
    }

    private void setAttribute(Bank oldBank, Bank newBank){
        if(newBank.getAddress() != null){oldBank.setAddress(newBank.getAddress());}
        if(newBank.getContactEmail() != null){oldBank.setContactEmail(newBank.getContactEmail());}
        if(newBank.getContactPhone() != null){oldBank.setContactPhone(newBank.getContactPhone());}
        if(newBank.getStatus() != null){oldBank.setStatus(newBank.getStatus());}
    }
}
