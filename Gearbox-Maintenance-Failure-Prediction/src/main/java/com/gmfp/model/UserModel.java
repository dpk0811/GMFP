package com.gmfp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_list")
public class UserModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String username;
//    Integer Id;



    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

//    public Integer getId() {
//        return Id;
//    }

    //    public void setId(Integer id) {
//        Id = id;

    @Override
    public String toString() {
        return "UserModel{" +
                "username='" + username + '\'' +
                '}';
    }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(username, userModel.username) && Objects.equals(password, userModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
