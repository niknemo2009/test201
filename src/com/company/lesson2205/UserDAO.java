package com.company.lesson2205;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO implements DAO<User> {
    @Override
    public int create(User entity) throws SQLException {
        int result=0;
//         PreparedStatement statement=getConnection(null,null,null,null).prepareStatement();
//        String sql="INSERT INTO `test`.`user` (`age`, `login`, `password`, `email`, `name`) VALUES (?, ?, ?, ?, ?);";
//        statement.execute(sql);
//        ResultSet temp=statement.getGeneratedKeys();
//
//        while(temp.next()){
//            result=temp.getInt("id");
//        }
        return result;
    }

    @Override
    public boolean update(User updEntity) {
        return false;
    }

    @Override
    public boolean delete(int keyEntity) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
