package com.entity;

import javax.persistence.*;

/**
 * Created by qny4i on 04.11.2016.
 *
 * Класс для симуляции номеров телефона
 *
 */
@Entity
@Table(name = "Phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "phoneNamber")
    private String phoneNamber;         //сам телефон

    @ManyToOne
    @JoinColumn(name="sauna_id")
    private Sauna sauna ;           // на кого он ссылаеться


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNamber() {
        return phoneNamber;
    }

    public void setPhoneNamber(String phoneNamber) {
        this.phoneNamber = phoneNamber;
    }

    public Sauna getSauna() {
        return sauna;
    }

    public void setSauna(Sauna sauna) {
        this.sauna = sauna;
    }

    public Phone() {
    }


    public Phone(String phoneNamber) {
        this.phoneNamber = phoneNamber;
    }

    @Override
    public String toString() {
        return "com.entity.Phone{" +
                "phoneNamber='" + phoneNamber + '\'' +
                '}';
    }
}
