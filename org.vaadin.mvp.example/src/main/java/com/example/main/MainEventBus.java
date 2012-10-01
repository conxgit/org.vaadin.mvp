package com.example.main;

import com.example.mvp.ExampleUI;
import org.vaadin.mvp.eventbus.EventBus;
import org.vaadin.mvp.eventbus.annotation.Event;
import org.vaadin.mvp.presenter.BasePresenter;

import com.example.menu.MenuPresenter;
import com.vaadin.ui.Field.ValueChangeEvent;

public interface MainEventBus extends EventBus {

  @Event(handlers = { MainPresenter.class })
  public void start(ExampleUI app);

  @Event(handlers = { MenuPresenter.class })
  public void selectMenu(ValueChangeEvent event);

  @Event(handlers = { MainPresenter.class })
  public void openModule(Class<? extends BasePresenter<?, ? extends EventBus>> presenterClass);

}
