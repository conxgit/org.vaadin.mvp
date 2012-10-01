package com.example.main;

import com.example.mvp.ExampleUI;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import org.vaadin.mvp.eventbus.EventBus;
import org.vaadin.mvp.presenter.BasePresenter;
import org.vaadin.mvp.presenter.IPresenter;
import org.vaadin.mvp.presenter.IPresenterFactory;
import org.vaadin.mvp.presenter.annotation.Presenter;

import com.example.main.view.IMainView;
import com.example.main.view.MainView;
import com.example.menu.MenuPresenter;

@Presenter(view = MainView.class)
public class MainPresenter extends BasePresenter<IMainView, MainEventBus>{

  private ExampleUI application;
  
  private MenuPresenter menuPresenter;
  
  private IPresenter<?, ?extends EventBus> contentPresenter;
  
  public void onStart(ExampleUI exampleUI) {
    // keep a reference to the application instance
    this.application = exampleUI;
    
    // set the applications main windows (the view)
    this.application.setContent((ComponentContainer) this.view);
    
    // load the menu presenter
    IPresenterFactory pf = application.getPresenterFactory();
    this.menuPresenter = (MenuPresenter) pf.createPresenter(MenuPresenter.class);
    this.view.setMenu(this.menuPresenter.getView());
  }
  
  public void onOpenModule(Class<? extends BasePresenter<?, ? extends EventBus>> presenter) {
    // load the menu presenter
    IPresenterFactory pf = application.getPresenterFactory();
    this.contentPresenter = pf.createPresenter(presenter);
    this.view.setContent((Component) this.contentPresenter.getView());
  }
  
  public void onShowDialog(Window dialog) {
    this.application.addWindow(dialog);
  }
  
  @Override
  public void bind() {
    VerticalLayout mainLayout = this.view.getMainLayout();
    HorizontalSplitPanel layoutPanel = this.view.getSplitLayout();
    mainLayout.setExpandRatio(layoutPanel, 1.0f);

    layoutPanel.setSplitPosition(150, Sizeable.Unit.PIXELS);
  }
  
}
