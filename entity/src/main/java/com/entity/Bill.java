package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by qny4i on 02.10.2016.
 *
 * Клас будет  нужен для получения чека за 1 посешение
 * в чеке может быть много услуг, serviceList будет хранить набор этих услуг
 * он подкреплен номером, датой
 * и статус оплаты (возможно)
 */


@Entity
@Table(name = "com.entity.Bill")
public class Bill {
    @Id
    @Column(name = "id_numberBill")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")

    public int numberBill;                               // номер счета (будет авто инкреминтроватся)

    @Column(name = "data")
    public String data;                                    // дата выдачи счета(передалать в норм класс)

//    public ArrayList<ServiceList> serviceList;           // лист заказов
    @Column(name = "fullCost")
    double fullCost;                                     // полная стоимость заказа

    @Column(name = "statusBill")
    boolean statusBill;                                  // статус уплаты счета

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bill(double fullCost, String data, boolean statusBill) {

        this.data=data;
//       this.serviceList = serviceList;
        this.fullCost = fullCost;
        this.statusBill = statusBill;
//        this.user=user;
    }

    public long getNumberBill() {
        return numberBill;
    }

    public void setNumberBill(int numberBill) {
        this.numberBill = numberBill;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getFullCost() {
        return fullCost;
    }

    public void setFullCost(double fullCost) {
        this.fullCost = fullCost;
    }

    public boolean isStatusBill() {
        return statusBill;
    }

    public void setStatusBill(boolean statusBill) {
        this.statusBill = statusBill;
    }

    public Bill(){

    }

    @Override
    public String toString() {
        return "com.entity.Bill{" +
                "numberBill=" + numberBill +
                ", data='" + data + '\'' +
                ", fullCost=" + fullCost +
                ", statusBill=" + statusBill +
                ", user=" + user +
                '}';
    }
}
