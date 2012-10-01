package com.example.mvp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.spring.main.SpringMainPresenter;
import org.vaadin.mvp.presenter.spring.SpringMvpUI;

@Component("springMvpApp")
@Scope("prototype")
public class ExampleSpringApp extends SpringMvpUI {

  private SpringMainPresenter mainPresenter;

  @Override
  public void preInit() {
    this.presenterFactory.setLocale(getLocale());
  }

  @Override
  public void postInit() {
    mainPresenter = (SpringMainPresenter) presenterFactory.createPresenter("springMainPresenter");
    mainPresenter.getEventBus().start(this);
  }

}
