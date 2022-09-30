package com.neodevs.checkurb.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CheckPoint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar horario;

    //ambiente
    @ManyToOne
    @JoinColumn(name = "ambienteId")
    private Ambiente ambiente;

    //hospede
    @ManyToOne
    @JoinColumn(name = "hospedeId")
    private Hospede hospede;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getHorario() {
        return horario;
    }

    public void setHorario(Calendar horario) {
        this.horario = horario;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    
}
