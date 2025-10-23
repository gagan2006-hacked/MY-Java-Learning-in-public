package com.company;
import java.util.Scanner;
class sq{
    float l,h;
    float pi =3.14f;
    float area;
    float peri;

    void getrad(float r,float s){
        this.l=r;
        this.h=s;


    }
    float cal_area(){
        area= (2*pi*l*l)+2*pi*l*h;
        return area;

    }
    float cal_vol(){
        peri =l*l*pi*h;
        return peri;
    }
}

public class prclass {
    public static void main(String[] args) {
sq math =new sq();
Scanner sg=new Scanner(System.in);
        System.out.println("enter the length of the cyc");
        float le= sg.nextFloat();
        System.out.println("enter the height of cyc");
        float he=sg.nextFloat();
        math.getrad(le,he);
        float outare= math.cal_area();
        float out_pr= math.cal_vol();
        System.out.println("area of the cyc  is"+outare);
        System.out.println("volume  of the cyc is"+out_pr);
    }
}
