package com.company.lesson2205;

public class User {
    private int id;
    private int age;
    private String login;
    private String password;
    private String emeil;
    private String name;

    public User(int age, String login, String password, String emeil, String name) {
        this.setAge(age);
        this.setLogin(login);
        this.setPassword(password);
        this.setEmeil(emeil);
        this.setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmeil() {
        return emeil;
    }

    public void setEmeil(String emeil) {
        this.emeil = emeil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", emeil='" + emeil + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
