package com.company;

import com.company.IMenuOption;

public class Option {
    private String name;
    private IMenuOption menuOption;

    public Option(String name, IMenuOption menuOption) {
        this.name = name;
        this.menuOption = menuOption;
    }

    public Option() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IMenuOption getMenuOption() {
        return menuOption;
    }

    public void setMenuOption(IMenuOption menuOption) {
        this.menuOption = menuOption;
    }
}
