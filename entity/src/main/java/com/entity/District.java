package com.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by qny4i on 04.11.2016.
 *
 *
 * Класс для симуляции районов Города
 *
 */
@Entity
@Table(name = "com.entity.District")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nameDistrict")
    private String nameDistrict;            // имя района


    @OneToMany(mappedBy = "district")
    private List<Sauna> sauna;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    public List<Sauna> getSauna() {
        return sauna;
    }

    public void setSauna(List<Sauna> sauna) {
        this.sauna = sauna;
    }

    public District() {
    }

    public District(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    @Override
    public String toString() {
        return "com.entity.District{" +
                "nameDistrict='" + nameDistrict + '\'' +
                '}';
    }
}
