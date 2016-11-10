package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qny4i on 03.11.2016.
 *
 *
 * Обшая база данных саун
 *
 */
@Entity
@Table(name = "sauna_bd")
public class Sauna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nameSauna")
    private String name;                        // Имя заведения

    @Column(name = "price")
    private int price;                           //ЦЕНА за час

    @Column(name = "capacity")
    private int capacity;                           //Вместимость

    @ManyToMany(mappedBy = "saunas")
    private List<ServiceType> type;                      //список типов бань

    @ManyToOne
    @JoinColumn(name="district_id")
    private District district;                  // сслыка дистрикта

    @Column(name = "address")
    private String address;                     //адресс

    @OneToMany(mappedBy = "sauna")
    public List<Phone> phones = new ArrayList<>();      //набор телефонов

    @Column(name = "urlPage")
    private String urlPage ;                    //url страницы

    @Column(name = "rating")
    private int rating;                             //рейтинг сауны

    @Column(name = "aboutSauna")
    private String about;                           //описание сауны


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ServiceType> getType() {
        return type;
    }

    public void setType(List<ServiceType> type) {
        this.type = type;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getUrlPage() {
        return urlPage;
    }

    public void setUrlPage(String urlPage) {
        this.urlPage = urlPage;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    public Sauna() {
    }

    public Sauna(String name, int price, int capacity, int rating) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Sauna{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
//                ", type=" + type +
//                ", district=" + district +
                ", address='" + address + '\'' +
                ", phones=" + phones +
                '}';
    }
}
