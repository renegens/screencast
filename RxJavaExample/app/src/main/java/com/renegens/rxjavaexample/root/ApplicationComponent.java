package com.renegens.rxjavaexample.root;

import com.renegens.rxjavaexample.MainActivity;
import com.renegens.rxjavaexample.http.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);

}
