package com.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by qny4i on 09.11.2016.
 */
@Entity
@Table(name = "activesession")
public class ActiveSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sessionid")
    private Long sessionId;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "logintime")
    private Date loginTime;

    @Column(name = "token")
    private String token;

    public ActiveSession() {
    }

    public ActiveSession(User user, Date loginTime, String token) {
        this.user = user;
        this.loginTime = loginTime;
        this.token = token;
   }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ActiveSession{" +
                "user=" + user.getUserName() +
                ", loginTime=" + loginTime +
                ", token='" + token + '\'' +
                '}';
    }
}
