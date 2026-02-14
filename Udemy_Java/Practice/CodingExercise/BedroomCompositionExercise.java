package com.Udemy_Java.Practice.CodingExercise;

public class BedroomCompositionExercise {

}
class Lamp{
    private String style;
    private boolean battery;
    private int globRating;

    public Lamp(String style, boolean battery, int globRating) {
        this.style = style;
        this.battery = battery;
        this.globRating = globRating;
    }

    public void turnOn(){
        System.out.print("Lamp -> Turning on");
    }

    public String getStyle() {
        return style;
    }

    public boolean isBattery() {
        return battery;
    }

    public int getGlobRating() {
        return globRating;
    }
}
class Bed{
    /*
| Variable | Type   |
| -------- | ------ |
| style    | String |
| pillows  | int    |
| height   | int    |
| sheets   | int    |
| quilt    | int    |
*/
    private String style;
    private int pillows,height,sheets,quilt;

    public Bed(String style, int pillows, int height, int sheets, int quilt) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quilt = quilt;
    }
    public void make(){
        System.out.print("Bed -> Making | ");
    }

    public String getStyle() {
        return style;
    }

    public int getPillows() {
        return pillows;
    }

    public int getHeight() {
        return height;
    }

    public int getSheets() {
        return sheets;
    }

    public int getQuilt() {
        return quilt;
    }
}
class Ceiling{
    private int height,paintedColor;

    public Ceiling(int height, int paintedColor) {
        this.height = height;
        this.paintedColor = paintedColor;
    }

    public int getHeight() {
        return height;
    }

    public int getPaintedColor() {
        return paintedColor;
    }
}
class Wall{
    private String direction;

    public Wall(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
class Bedroom{
    /*
| Variable | Type    |
| -------- | ------- |
| name     | String  |
| wall1    | Wall    |
| wall2    | Wall    |
| wall3    | Wall    |
| wall4    | Wall    |
| ceiling  | Ceiling |
| bed      | Bed     |
| lamp     | Lamp    |
*/
     private String name;
     private Wall wall1,wall2,wall3,wall4;
     private Ceiling ceiling;
     private Bed bed;
     private Lamp lamp;

    public Bedroom(String name, Wall wall1, Wall wall2, Wall wall3, Wall wall4, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public void makeBed(){
         System.out.print("Bedroom -> Making bed | ");
         bed.make();
     }

    public Lamp getLamp() {
        return lamp;
    }
}