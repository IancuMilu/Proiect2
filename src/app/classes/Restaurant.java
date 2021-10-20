package app.classes;

public class Restaurant{

    public String numeRestaurant;
    private static double totalPlata;
    public static String cosCumparaturi;

    public Restaurant(String numeRestaurant){
        this.numeRestaurant = numeRestaurant;
    }

    public Restaurant(){

    };

    public static void setTotalPlata(double pret) {
        totalPlata += pret;
    }

    public static double getTotalPlata(){
        return totalPlata;
    }

    public static void cosCumparaturi(String produs){
        cosCumparaturi += produs;
    }

    public static void stergereCosCumparaturi(){
        cosCumparaturi = "";
        totalPlata = 0;
    }
}
