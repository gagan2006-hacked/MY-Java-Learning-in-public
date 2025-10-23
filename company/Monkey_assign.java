package com.company;

 abstract class Monkey{
    abstract public void jump();
    public void bite(){
        System.out.println("bitting");
    }
}
interface Basic_animals{
     void eat();
     void sleep();
}
class Human extends Monkey implements Basic_animals {
    public void jump(){
        System.out.println("jumping");
    }
    @Override
    public void eat() {
        System.out.println("eating food ");
    }

    @Override
    public void sleep() {
        System.out.println("sleeping happily");
    }
}

public class Monkey_assign {
}
