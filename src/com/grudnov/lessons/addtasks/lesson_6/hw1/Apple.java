package com.grudnov.lessons.addtasks.lesson_6.hw1;

public class Apple {
    private int age;
    private boolean fresh;
    private boolean onTree;

    public Apple(int age, boolean fresh, boolean onTree) {
        if(age < 0 || age > 30) {
            throw new IllegalArgumentException("age must be in range 0...30");
        }
        if(!fresh) {
            throw new IllegalArgumentException("fresh must be true");
        }
        if(!onTree) {
            throw new IllegalArgumentException("onTree must be true");
        }
        this.age = age;
        this.fresh = fresh;
        this.onTree = onTree;
    }

    public void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("age must be more than 0");
        }
        this.age = age;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public void setOnTree(boolean onTree) {
        this.onTree = onTree;
    }

    public int getAge() {
        return age;
    }

    public boolean isFresh() {
        return fresh;
    }

    public boolean isOnTree() {
        return onTree;
    }

    void fallFromTree() {
        this.onTree = false;
    }
    void spoil() {
        this.fresh = false;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "age=" + age +
                ", fresh=" + fresh +
                ", onTree=" + onTree +
                '}';
    }
}
