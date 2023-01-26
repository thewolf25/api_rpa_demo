package com.star.api_rpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.api_rpa.dto.DeclarationRpaDto;
import com.star.api_rpa.exception.DeclarationException;
import com.star.api_rpa.model.Declaration;
import com.star.api_rpa.repository.DeclarationRepository;


@Service
public class DeclarationServiceImpl implements DeclarationService {


    @Autowired
    DeclarationRepository repository;

    
    @Override
    public List<Declaration> findAllDeclarations() {

        // TODO Auto-generated method stub
        return  repository.findAll();
        
    }

    @Override
    public Declaration findDeclarationByID(Integer id) throws DeclarationException{
        // TODO Auto-generated method stub
        return repository.findById(id).orElseThrow(() -> new DeclarationException("Declaration avec id "+ id + " n'esiste pas"));
    }

    @Override
    public Declaration createDeclaration(Declaration declaration) {
        // TODO Auto-generated method stub
        return repository.save(declaration);
    }

    @Override
    public Declaration updateDeclaration(Integer id, Declaration declaration) throws DeclarationException {
        // TODO Auto-generated method stub


        Optional<Declaration> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Declaration existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            return repository.save(existingItem);
        } else 
             throw new DeclarationException( "Declaration avec id "+ id + " n'esiste pas");
    
    }

    @Override
    public void deleteDeclaration(Integer id) throws DeclarationException {
        
        // TODO Auto-generated method stub

        this.findDeclarationByID(id);
        repository.deleteById(id);
    }

    @Override
    public Declaration updateRpaDeclrationOutput(Integer id , DeclarationRpaDto declaration) throws DeclarationException {
        // TODO Auto-generated method stub


        Optional<Declaration> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Declaration existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            existingItem.setResultatRpaExpertise(declaration.getResultatRpaExpertise());
            existingItem.setResultatRpaOuveture(declaration.getResultatRpaOuveture());
            return repository.save(existingItem);
        } else 
             throw new DeclarationException( "Declaration avec id "+ id + " n'esiste pas");
    }
    
}
