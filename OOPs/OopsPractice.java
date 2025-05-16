package com.OOPs;

import java.util.Scanner;

public class OopsPractice {
    public static void main(String[] args) {
        Student []list=new Student[2];
        Scanner in=new Scanner(System.in);
       /* try {
            for (int i = 0; i < 2; i++) {
                System.out.println("enter the data of student in this order (rollno name marks) please");
                list[i] = new Student(in.nextInt(), in.next(), in.nextFloat());
            }
           *//* for (Student obj :list){
                System.out.println(obj);
                System.out.println("Roll no:"+obj.rollno);
                System.out.println("Name :"+obj.name);
                System.out.println("Marks:"+obj.marks);
                System.out.println();
            }*//*
//            System.out.println(Student.toString(list));

        } catch (Exception e) {
            System.out.println(e);
        }*/

        /*BoxOfUser box=new BoxOfUser();
        System.out.println(box.height);*/

        /*BoxOfUser boxOfUser=new BoxPrice();
        System.out.println(boxOfUser.getClass());*/

/*
        BoxWeight boxWeight;
        boxWeight = new BoxOfUser();
*/
        BoxOfUser boxPrice=new BoxPrice();
        boxPrice.ga();
    }
}
class Student {
    public int rollno;
    public String name;
    public float marks;

    public Student(int rollno, String name, float marks) {
        this.rollno = rollno;
        this.marks = marks;
        this.name = name;
    }

    public static String toString(Student []arr){
        String value="[";
        for (Student student:arr) {
            for (int i = 0; i <1 ; i++) {
                value+="{";
                value+=student.rollno+",";
                value+=student.name+",";
                value+=student.marks+"},";
            }
        }
        return value;
    }
}

  /*  @Override
    public String toString() {
        System.out.println("Roll no:"+rollno);
        System.out.println("Name :"+name);
        System.out.println("Marks:"+marks);
        System.out.println();
        return "";
    }*/
    class BoxOfUser {
        double length;
        double width;
        double height;
        double weight=-1;
        BoxOfUser(){
            length=-1;
            width=-1;
            height=-1;
        }
      BoxOfUser(double length, double width, double height){
          this.length=length;
          this.width=width;
          this.height=height;
      }
      BoxOfUser(BoxOfUser box){
          this.length=box.length;
          this.width=box.width;
          this.height=box.height;
      }
      static void ga(){
          System.out.println("k");
      }
    }
    class BoxWeight extends BoxOfUser {
        double weight;
        BoxWeight(){
            this.weight=-1;
        }

        public BoxWeight(double weight) {
            this.weight = weight;
        }

        public BoxWeight(BoxOfUser box, double weight) {
            super(box);
            this.weight = weight;
        }

        public BoxWeight(BoxWeight box) {
            super(box);
            this.weight = weight;
        }
        static void ga(){
            System.out.println("hi");
        }
    }

    class BoxPrice extends  BoxWeight{
        double price;
        BoxPrice(){
            this.price=0;
        }
        public BoxPrice(double price) {
            this.price = price;
        }
        static void ga(){
            System.out.println("kk");
        }
    }

