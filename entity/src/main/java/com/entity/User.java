package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by qny4i on 02.10.2016.
 *
 * Клас нужен для моделирования личного кабинета пользователя
 *
 * Содержит:
 * - логин пользователся
 * - пароль пользователся
 * - имя пользователся
 * - почту (возможно с подверждением +- статус подтверждение почты)
 * - его телефонный номер (возможно с подверждением +- статус подтверждение почты)
 * - пол человека( для определение кому КОГО предлагать:_))))
 * - и список всех заказов (выполненых, невыполненых, оплаченных)
 *
 * Все это должно выводится в кабинете пользователся
 */
@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "userLogin")
    private String userLogin;                      // логинаж пользователся

    @Column(name = "userPassword")
    private String userPassword;                 // пароль пользователся

    @Column(name = "userName")
    private String userName;                     // имя пользователся

    @Column(name = "mail")
    private String mail;                         // почта

    @Column(name = "phoneNamber")
    private int phoneNamber;                     // телефонный номер

    @Column(name = "gender")
    private boolean gender;                      // пол человека

    @OneToMany(mappedBy = "user")
    public List<Bill> bill = new ArrayList<>();

    public List<Bill> getBill() {
        return bill;
    }

    public void setBill(List<Bill> bill) {
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }


    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhoneNamber() {
        return phoneNamber;
    }

    public void setPhoneNamber(int phoneNamber) {
        this.phoneNamber = phoneNamber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public User(){

    }

    public User(String userLogin, String userPassword, String userName) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userName = userName;
//        this.fullOrders = fullOrders;
    }


    @Override
    public String toString() {
        return "com.entity.User{" +
                "id=" + id +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
