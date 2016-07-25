package com.renegens.mvpexample.login;

public class MemoryRepository implements LoginRepository {

    private UserModel userModel;

    @Override
    public UserModel getUser() {

        if (userModel == null ) {
            UserModel user = new UserModel();
            user.setFirstName("Fox");
            user.setLastName("Mulder");
            user.setId(0);
            return user;
        }else {
            return userModel;
        }




    }

    @Override
    public void saveUser(UserModel userModel) {

        this.userModel = userModel;

    }
}
