package com.company;

interface TvRemote{
    void control();
    void change();
}
interface Smart_Tv_Remote extends TvRemote{
    @Override
    void change();

    @Override
    void control();
    void ir_signal();
}
class Tv implements TvRemote,Smart_Tv_Remote {
    @Override
    public void ir_signal() {
        System.out.println("signaling");
    }

    @Override
    public void control() {
        System.out.println("Control");
    }

    @Override
    public void change() {
        System.out.println("change the channel");

    }
}
public class Tv_pro {
}
