package com.company.lesson2205;

public class ControllerUser extends  Controller<User> {

    public ControllerUser(DAO<User> dao) {
        super(dao);
    }
     boolean registration(int age, String login, String password, String emeil, String name){
        boolean result=false;

        User temp=new User(age,login,password,emeil,name);
        if(validate(temp)==true){
           // int pkey=dao.create(temp);
           // temp.setId(pkey);
        }
       return result;
     }
    @Override
    boolean validate(User entity) {
        return false;
    }
}
