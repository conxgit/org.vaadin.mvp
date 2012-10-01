package com.example.mvp;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.vaadin.mvp.eventbus.EventBus;
import org.vaadin.mvp.eventbus.EventBusManager;
import org.vaadin.mvp.presenter.IPresenter;
import org.vaadin.mvp.presenter.IPresenterFactory;
import org.vaadin.mvp.presenter.PresenterFactory;

import com.example.main.MainEventBus;
import com.example.main.MainPresenter;

public class ExampleUI extends UI {

  /** Per application (session) event bus manager */
  private EventBusManager ebm = new EventBusManager();
  /** Per application presenter factory */
  private PresenterFactory presenterFactory;
  
  /** Main presenter */
  private IPresenter<?, ? extends EventBus> mainPresenter;

  @Override
  protected void init(VaadinRequest request) {
    this.presenterFactory = new PresenterFactory(ebm, getLocale());
    mainPresenter = this.presenterFactory.createPresenter(MainPresenter.class);
    MainEventBus eventBus = (MainEventBus) mainPresenter.getEventBus();
    eventBus.start(this);
  }

  public IPresenterFactory getPresenterFactory() {
    return this.presenterFactory;
  }

}
