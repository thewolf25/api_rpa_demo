package com.star.api_rpa.model;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Declaration {
    @Id
    @Column(name="ID_DECLARATION")
    private Integer id;

    // temporaire pour test RPA
    @Column(name = "PROJECT_ID")
    private int project;

    // temporaire pour test RPA

    @Column(name ="PROCESS_SOURCE")
    private int processSource;
    @Column(name="CDL")
    private String cdl;
    @Column(name="NUM_DECLARATION")
    private String numDeclaration;
    @Column(name="CAUSE_DOMMAGE")
    private String causeDommage;
    @Column(name="TYPE_EXPERT")
    private String typeExpert;
    @Column(name="TYPE_MISSION")
    private String typeMission;
    @Column(name="CENTRE_EXPERTISE")
    private String centreExpertise;
    @Column(name="MOTIF")
    private String motif;
    @Column(name="NOTE")
    private String note;
    @Column(name="ETAT")
    private int etat;
    @Column(name="RESULTAT_RPA_OUVERTURE")
    private String resultatRpaOuveture;
    @Column(name="RESULTAT_RPA_EXPERTISE")
    private String resultatRpaExpertise;
    // private JSONPObject elem;
}
