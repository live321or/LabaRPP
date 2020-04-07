package com.samoylov.gameproject;

import java.util.ArrayList;

public class Mob {
//Класс который описывает монстра с котром игрок может сражаться
//Моб:
//Имя
    private String name;
// лвл// опыт// домаг//
    private double lvl, exp, dmg, hp;
// Конструктор

//    список выподаемых предметов
    private ArrayList<Equipment> dropItems=new ArrayList<>();
    // добавление выподающего предмета
    public void addDropItem(Equipment dropItem){
        this.dropItems.add(0,dropItem);
    }
    //функция дропа предметов
    public Equipment getDropItem(){
        return dropItems.get(0);
    }
//    шанс выподения предмета? в мобе или в предмете?
//    локация?
//    агрессивность
//    тип поведения(Груповой/одиночка)

//геторы и сеторы

    public String getName() {
        return name;
    }

    public double getLvl() {
        return lvl;
    }

    public double getExp() {
        return exp;
    }

    public double getDmg() {
        return dmg;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
}
