package com.renegens.retrofitexample.root;

import com.renegens.retrofitexample.MainActivity;
import com.renegens.retrofitexample.http.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);

}
