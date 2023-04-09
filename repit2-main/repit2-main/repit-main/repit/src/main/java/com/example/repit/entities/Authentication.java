package com.example.repit.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "authentication")
public class Authentication {

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @Column(name = "role")
    String  role;

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_user;

    public Authentication(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Authentication() {

    }

    public String getPassword() {
        return password;
    }
    public String get_login() {
        return login;
    }
    public int id_user() {
        return id_user;
    }
    public String getRole() {
       return role;
   }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
       this.role = role;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }


    @OneToOne(mappedBy = "authentication", cascade=CascadeType.ALL)
    private Tutor tutor;

    @OneToOne(mappedBy = "authentication", cascade=CascadeType.ALL)
    private Student student;


    @Override
    public String toString() {
        return "Authentication{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", id_user=" + id_user +
                '}';
    }
}
