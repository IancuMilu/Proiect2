package app.classes;

import app.interfaces.Food;

public class Mancaruri implements Food {

    public  String numeMancare;
    public  double pretMancare;
    private int inventarMancare;

    public Mancaruri(){

    }

    public  void numeFood(String numeMancare){
        this.numeMancare = numeMancare;
    };
    public  void pretFood(double pret){
        this.pretMancare = pret;
    };
    public void inventarFood(int inventar){
        this.inventarMancare = inventar;
    };

    public int getInventarMancare(){
        return inventarMancare;
    }

    public  void setInventarMancare(){
        inventarMancare--;
    }

    public boolean lipsaStoc(){
        if(getInventarMancare() < 1)
            return true;

        return false;
    }
}
