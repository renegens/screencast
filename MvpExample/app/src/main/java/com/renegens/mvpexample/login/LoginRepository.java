package com.renegens.mvpexample.login;

public interface LoginRepository {

    UserModel getUser();

    void saveUser(UserModel userModel);
}
