package com.example.main.view;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

public interface IMainView {

  public abstract void setMenu(Component menu);

  public abstract void setContent(Component content);

  public abstract HorizontalSplitPanel getSplitLayout();

  public abstract VerticalLayout getMainLayout();

}