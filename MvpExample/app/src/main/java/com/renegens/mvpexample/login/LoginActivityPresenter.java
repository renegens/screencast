package com.renegens.mvpexample.login;

import android.support.annotation.Nullable;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginRepository repository;
    private UserModel userModel;





    @Override
    public void setView(LoginActivityMVP.View view) {

        this.view = view;

    }

    @Override
    public void loginButtonClicked() {

        if (view != null) {
            String fname = view.getFirstName();
            String lname = view.getLastName();

            repository.saveUser(new UserModel());
        }



    }

    @Override
    public void getCurrentUser() {

        UserModel userModel = repository.getUser();

        if (view != null) {
            view.setFirstName(userModel.getFirstName());
            view.setLastName(userModel.getLastName());
        }

    }
}
