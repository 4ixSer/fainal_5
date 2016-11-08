package com.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by qny4i on 04.11.2016.
 */
@Entity
@Table(name = "serviceType")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "typeService")
    private String type;


    @ManyToMany
    @JoinTable(name = "sauna_type",
            joinColumns = @JoinColumn(name = "sauna_id"),
            inverseJoinColumns = @JoinColumn(name = "serviceType_id"))
    private List<Sauna> saunas;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Sauna> getSaunas() {
        return saunas;
    }

    public void setSaunas(List<Sauna> saunas) {
        this.saunas = saunas;
    }


    public ServiceType() {
    }

    public ServiceType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "com.entity.ServiceType{" +
                "type='" + type + '\'' +
                '}';
    }
}

