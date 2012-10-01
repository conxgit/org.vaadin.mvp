package com.example.main.view;

import com.vaadin.ui.*;
import org.vaadin.mvp.uibinder.IUiBindable;
import org.vaadin.mvp.uibinder.annotation.UiField;

public class MainView extends VerticalLayout implements IMainView, IUiBindable {

  @UiField
  VerticalLayout mainLayout;
  
  @UiField
  HorizontalSplitPanel splitLayout;

  public MainView() {
    this.setHeight("100%");
    this.setWidth("100%");
  }

  @Override
  public void setMenu(Component menu) {
    splitLayout.setFirstComponent(menu);
  }

  @Override
  public void setContent(Component content) {
    splitLayout.setSecondComponent(content);
  }

  @Override
  public HorizontalSplitPanel getSplitLayout() {
    return splitLayout;
  }
  
  @Override
  public VerticalLayout getMainLayout() {
    return mainLayout;
  }
  
}
