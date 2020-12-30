package com.nari.pojo;

public class Menu {
    private Integer menuId;
    private String menuName;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Menu(){}                     //无参构造方法，没事干的时候就看部电影

    public Menu(Integer menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
