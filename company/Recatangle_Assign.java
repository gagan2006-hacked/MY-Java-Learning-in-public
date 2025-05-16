package com.company;

class Rectangle{
    public float length,bridth;

    public float getBridth() {
        return bridth;
    }

    public void setBridth(float bridth) {
        this.bridth = bridth;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
    public float area_rect(){
        System.out.println("out will be on the perivious input if no new input is given");
        float aera_rec=length*bridth;
        return aera_rec;
    }
    public float permi_rect(){
        System.out.println("out will be on the perivious input if no new input is given");
        float per=2*(length+ bridth);
        return per;
    }
}
class Cuboid extends Rectangle{
//    Rectangle rectangle=new Rectangle();
    public String area_cuboid(float height,float leng,float bridth){
       float aera=2*(leng*height+leng*bridth+bridth*height);
      float vol=vol_cuboid(height,leng,bridth);
      String aer_per=" "+aera+ " is the aera and  "+vol+" is the vol of cuboid ";// Not Recommend for industry uses only edu
       return aer_per;
    }
    public float vol_cuboid(float height,float leng ,float bridth){
        float vol=leng*height*bridth;
        return vol;
    }

}
public class Recatangle_Assign {

}
