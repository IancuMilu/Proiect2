package app.classes;

import app.interfaces.Food;

public class Bauturi implements Food{

    public String numeBautura;
    public double pretBautura;
    private int inventarBautura;

    public Bauturi(){

    }

    public void numeFood(String numeBautura){
        this.numeBautura = numeBautura;
    };
    public void pretFood(double pretBautura){
        this.pretBautura = pretBautura;
    };
    public void inventarFood(int inventarBautura){
        this.inventarBautura = inventarBautura;
    };

    public int getInventarBautura(){
        return inventarBautura;
    }

    public void setInventarBautura(){
        inventarBautura --;
    }

    public boolean lipsaStoc(){
        if(getInventarBautura() < 1)
            return true;

        return false;
    }
}
