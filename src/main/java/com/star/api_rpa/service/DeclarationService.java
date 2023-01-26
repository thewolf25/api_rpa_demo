package com.star.api_rpa.service;

import java.util.List;
import java.util.Optional;

import com.star.api_rpa.dto.DeclarationRpaDto;
import com.star.api_rpa.exception.DeclarationException;
import com.star.api_rpa.model.Declaration;

public interface DeclarationService {


    public List<Declaration>  findAllDeclarations();

    public Declaration findDeclarationByID(Integer id) throws DeclarationException;

    public Declaration createDeclaration(Declaration declaration );

    public Declaration updateDeclaration( Integer id ,Declaration declaration ) throws DeclarationException;


    public void deleteDeclaration(Integer id) throws DeclarationException;

    public Declaration updateRpaDeclrationOutput(Integer id , DeclarationRpaDto declaration) throws DeclarationException;

}
