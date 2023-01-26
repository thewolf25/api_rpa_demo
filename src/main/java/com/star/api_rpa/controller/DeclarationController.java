
package com.star.api_rpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.star.api_rpa.dto.DeclarationRpaDto;
import com.star.api_rpa.exception.DeclarationException;
import com.star.api_rpa.model.Declaration;
import com.star.api_rpa.repository.DeclarationRepository;
import com.star.api_rpa.service.DeclarationService;

@RestController
@RequestMapping("/declaration")
class DeclarationSourceControllerGenarated {

    @Autowired
    DeclarationRepository repository;

    
    @Autowired
    DeclarationService declarationService;

    @GetMapping
    public ResponseEntity<List<Declaration>> getAllDeclaration() {
        try {
            List<Declaration> items = declarationService.findAllDeclarations();

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Declaration> getDeclarationById(@PathVariable("id") String id) throws DeclarationException{
        return new ResponseEntity<>(declarationService.findDeclarationByID(Integer.parseInt(id)), HttpStatus.OK);

      
    }

    @PostMapping
    public ResponseEntity<Declaration> createDeclaration(@RequestBody Declaration item) {
        try {
            Declaration savedItem = declarationService.createDeclaration(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Declaration> updateDeclaration(@PathVariable("id") String id, @RequestBody Declaration item) {
        Optional<Declaration> existingItemOptional = repository.findById(Integer.parseInt(id));
        if (existingItemOptional.isPresent()) {
            Declaration existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDeclaration(@PathVariable("id") String id) throws NumberFormatException, DeclarationException {

            declarationService.deleteDeclaration(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     
       
    }

    @PutMapping("rpa/{id}")
    public ResponseEntity<Declaration> updateRpaField(@PathVariable("id") String id, @RequestBody DeclarationRpaDto item) throws DeclarationException{
                return new ResponseEntity<>(declarationService.updateRpaDeclrationOutput(Integer.parseInt(id),item), HttpStatus.OK);


        }
    



    @ExceptionHandler(DeclarationException.class)
    protected ResponseEntity<String> handleEntityNotFound(DeclarationException ex) {
        return new ResponseEntity<>(ex.getMessage() ,HttpStatus.NOT_FOUND );
    }
}