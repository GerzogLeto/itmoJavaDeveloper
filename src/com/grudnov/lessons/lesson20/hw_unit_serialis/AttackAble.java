package com.grudnov.lessons.lesson20.hw_unit_serialis;

public interface AttackAble {
    // метод без реализации
    void attack(BattleUnit unit);

    // метод с реализацией
    default void run(){
        System.out.println("run AttackAble");
    }
}
