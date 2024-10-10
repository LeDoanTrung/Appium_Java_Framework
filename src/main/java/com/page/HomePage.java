package com.page;

import com.constant.MenuBarConstant;

public class HomePage extends BasePage {
    protected MenuBar _menuBar;

    public HomePage() {
        _menuBar = new MenuBar();
    }

    public MyAccountPage goToMyAccountPage() {
        _menuBar.clickMenuBar();
        _menuBar.clickOnSection(MenuBarConstant.MY_ACCOUNT);
        return new MyAccountPage();
    }
}
