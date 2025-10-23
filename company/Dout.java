package com.company;

import java.util.Scanner;

 class Circle {
    public float area , circumfer;
    public float pi;

    Circle(float rad){
        pi=3.14f;
        area=pi*rad*rad;
        circumfer=rad*2*pi;
    }
/*

     public float getArea(float radius){
         area =pi * radius*radius;
         return area;


     }
     public float getCircumfer(float rs ){
         circumfer=rs*2*pi;
         return circumfer;

     }*/
}
      class Cyclinder extends Circle{
        public float vol;
        public float area_cyc,circum_cyc;
         Cyclinder(float radi,float he){
             super(radi);
             area_cyc=area;
             circum_cyc=circumfer;
             area_cyc=1*area_cyc+circum_cyc*he;
             vol=area*he;
         }
//
//
//         public float getArea(float radius,float h) {
//             java.util.Scanner sc =new Scanner(System.in);
//             float area1 = getArea(radius);
////             float circumfer1 = getCircumfer(radius);
////             area1 = 2*area1+ circumfer1*h;
//
//             return area1;
//         }
//
//         public float getVol(float radius) {
//             java.util.Scanner sc =new Scanner(System.in);
//             System.out.println("enter the height of cylinder");
//             h = sc.nextFloat();
////             float area1 = getArea(radius);
//            vol= area*h;
//             return vol;
//         }
     }


public class Dout{
    public  static void main(String[] args) {
        /*  Circle c=new Circle();
        Cyclinder n1 = new Cyclinder();


        Scanner st=new Scanner(System.in);
        System.out.println("enter the of radius of the circle  ");
        float radius =st.nextFloat();
        int n;
        while (true){
            System.out.println("enter the choice");
            System.out.println("1. area of the circle");
            System.out.println("2. circum of the circle");
            System.out.println("3. area of the cydlinder");
            System.out.println("4. volume of the cylinder");
            System.out.println("5. exit");
           try{ n=st.nextInt();
               switch (n) {
                   case 1:
                       System.out.println("area is " + c.getArea(radius));
                       break;
                   case 2:
                       System.out.println("circumference is " + c.getCircumfer(radius));
                       break;
                   case 3:
                       System.out.println("enter the height of the cyclinder");
                       float he =st.nextFloat();
                       System.out.println("area of the cyclinder is " + n1.getArea(radius,he));
                       break;
                   case 4:
                       System.out.println("volume of the cyclindr is " + n1.getVol(radius));
                       break;
                   case 5:
                       System.out.println("exiting");
                       break;
                   default:
                       System.out.println("invaild choice");
                       break;
               }
               if (n==5){
                   break;
               }
           }
           catch (Exception e){
               System.out.println(e);
           }


        }*/
    }
}
