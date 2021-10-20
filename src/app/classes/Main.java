package app.classes;

import app.gui.FirstWindow;
import app.gui.SecondWindow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        String[] Mancare = {"Sandwich cu snitel de pui", "Sandwich cu ton", "Sandwich cu salam si cascaval", "Sandwich cu ou", "Felie de pizza"};
        String[] Bautura = {"Apa", "Cola", "Fanta", "Sprite", "Redbull"};

        int[] PretMancaruri = {15, 12, 10, 9, 10};
        int[] PretBauturi = {4, 5, 5, 5, 10};

        int[] InventarMancaruri = {1, 10, 10, 10, 10};
        int[] InventarBauturi = {20, 20, 20, 20, 20};

        Mancaruri[] M = new Mancaruri[5];
        Bauturi[] B = new Bauturi[5];
        Restaurant R = new Restaurant("Proiect Restaurant");

        for (int i = 0; i < 5; ++i) {
            M[i] = new Mancaruri();
        }
        for (int i = 0; i < 5; ++i) {
            M[i].numeFood(Mancare[i]);
        }
        for (int i = 0; i < 5; ++i) {
            M[i].pretFood(PretMancaruri[i]);
        }
        for (int i = 0; i < 5; ++i) {
            M[i].inventarFood(InventarMancaruri[i]);
        }

        for (int i = 0; i < 5; ++i) {
            B[i] = new Bauturi();
        }
        for (int i = 0; i < 5; ++i) {
            B[i].numeFood(Bautura[i]);
        }
        for (int i = 0; i < 5; ++i) {
            B[i].pretFood(PretBauturi[i]);
        }
        for (int i = 0; i < 5; ++i) {
            B[i].inventarFood(InventarBauturi[i]);
        }

        Restaurant.cosCumparaturi = "";

        System.out.println("Bine ati venit la " + R.numeRestaurant);

        new FirstWindow();

        String meniu = """
        Ce doriti sa comandati?:
        1. Mancaruri
        2. Bauturi
        3. Finalizare plata
        4. Exit
        """;

        System.out.println(meniu);

        Scanner obj = new Scanner(System.in);
        int alegere = obj.nextInt();

        while (alegere != 4){
            switch (alegere){
                case 1:{
                    for(int i = 0; i < 5; ++i) {
                        System.out.println(i+1 + ". " + M[i].numeMancare + " " + M[i].pretMancare + "lei");
                    }
                    System.out.println("6. Finalizare comanda.");
                    System.out.println("7. Stergere cos.");
                    System.out.println("8. Inapoi.");
                    int alegere2 = obj.nextInt();
                    while (alegere2 != 8)
                    {
                        switch (alegere2){
                            case 1:{
                                if(M[0].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(M[0].pretMancare);
                                    M[0].setInventarMancare();
                                    Restaurant.cosCumparaturi(M[0].numeMancare + "\n");
                                    break;
                                }
                            }
                            case 2:{
                                if(M[1].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(M[1].pretMancare);
                                    M[1].setInventarMancare();
                                    Restaurant.cosCumparaturi(M[1].numeMancare + "\n");
                                    break;
                                }
                            }
                            case 3:{
                                if(M[2].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(M[2].pretMancare);
                                    M[2].setInventarMancare();
                                    Restaurant.cosCumparaturi(M[2].numeMancare + "\n");
                                    break;
                                }
                            }
                            case 4:{
                                if(M[3].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(M[3].pretMancare);
                                    M[3].setInventarMancare();
                                    Restaurant.cosCumparaturi(M[3].numeMancare + "\n");
                                    break;
                                }
                            }
                            case 5:{
                                if(M[4].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(M[4].pretMancare);
                                    M[4].setInventarMancare();
                                    Restaurant.cosCumparaturi(M[4].numeMancare + "\n");
                                    break;
                                }
                            }
                            case 6:{
                                try {
                                    FileWriter myWriter = new FileWriter("Chitanta.txt");
                                    myWriter.write(Restaurant.cosCumparaturi + "\nTotal plata: " + Restaurant.getTotalPlata());

                                    if(Restaurant.getTotalPlata() > 30 && Restaurant.getTotalPlata() < 60){
                                        myWriter.write("\nA fost aplicata o reducere de 5 Lei.");
                                    }
                                    else if(Restaurant.getTotalPlata() > 60){
                                        myWriter.write("\nA fost aplicata o reducere de 10 Lei.");
                                    }
                                    else{
                                        myWriter.write("\nNu a fost aplicata nici o reducere.");
                                    }
                                    Reducere.reducere(Restaurant.getTotalPlata());
                                    myWriter.write("\nTotal plata: " + Restaurant.getTotalPlata());
                                    myWriter.close();
                                    System.out.println("Chitanta a fost tiparita.");
                                } catch (IOException e) {
                                    System.out.println("Eroare in timpul tiparirii.");
                                    e.printStackTrace();
                                }
                                System.exit(0);
                            }
                            case 7:{
                                Restaurant.stergereCosCumparaturi();
                                System.out.println("Cosul a fost sters.");
                                break;
                            }
                            default:
                                System.out.println("Optiune nevalida.");
                        }

                        System.out.println(Restaurant.cosCumparaturi);
                        System.out.println("Total plata: " + Restaurant.getTotalPlata());
                        alegere2 = obj.nextInt();

                    }
                    break;
                }
                case 2:{
                    for(int i = 0; i < 5; ++i) {
                        System.out.println(i+1 + ". " + B[i].numeBautura + " " + B[i].pretBautura + "lei");
                    }
                    System.out.println("6. Finalizare comanda.");
                    System.out.println("7. Stergere cos.");
                    System.out.println("8. Inapoi.");
                    int alegere3 = obj.nextInt();
                    while (alegere3 != 8){
                        switch (alegere3){
                            case 1:{
                                if(B[0].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(B[0].pretBautura);
                                    B[0].setInventarBautura();
                                    Restaurant.cosCumparaturi(B[0].numeBautura + "\n");
                                    break;
                                }
                            }
                            case 2:{
                                if(B[1].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(B[1].pretBautura);
                                    B[1].setInventarBautura();
                                    Restaurant.cosCumparaturi(B[1].numeBautura + "\n");
                                    break;
                                }
                            }
                            case 3:{
                                if(B[2].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(B[2].pretBautura);
                                    B[2].setInventarBautura();
                                    Restaurant.cosCumparaturi(B[2].numeBautura + "\n");
                                    break;
                                }
                            }
                            case 4:{
                                if(B[3].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(B[3].pretBautura);
                                    B[3].setInventarBautura();
                                    Restaurant.cosCumparaturi(B[3].numeBautura + "\n");
                                    break;
                                }
                            }
                            case 5:{
                                if(B[4].lipsaStoc()) {
                                    System.out.println("Produsul nu se mai afla in stoc.");
                                    break;
                                }
                                else {
                                    Restaurant.setTotalPlata(B[4].pretBautura);
                                    B[4].setInventarBautura();
                                    Restaurant.cosCumparaturi(B[4].numeBautura + "\n");
                                    break;
                                }
                            }
                            case 6:{
                                try {
                                    FileWriter myWriter = new FileWriter("Chitanta.txt");
                                    myWriter.write(Restaurant.cosCumparaturi + "\nTotal plata: " + Restaurant.getTotalPlata());

                                    if(Restaurant.getTotalPlata() > 30 && Restaurant.getTotalPlata() < 60){
                                        myWriter.write("\nA fost aplicata o reducere de 5 Lei.");
                                    }
                                    else if(Restaurant.getTotalPlata() > 60){
                                        myWriter.write("\nA fost aplicata o reducere de 10 Lei.");
                                    }
                                    else{
                                        myWriter.write("\nNu a fost aplicata nici o reducere.");
                                    }
                                    Reducere.reducere(Restaurant.getTotalPlata());
                                    myWriter.write("\nTotal plata: " + Restaurant.getTotalPlata());
                                    myWriter.close();
                                    System.out.println("Chitanta a fost tiparita.");
                                } catch (IOException e) {
                                    System.out.println("Eroare in timpul tiparirii.");
                                    e.printStackTrace();
                                }
                                System.exit(0);
                            }
                            case 7:{
                                Restaurant.stergereCosCumparaturi();
                                System.out.println("Cosul a fost sters.");
                                break;
                            }
                            default:
                                System.out.println("Optiune nevalida.");
                        }

                        System.out.println(Restaurant.cosCumparaturi);
                        System.out.println("Total plata: " + Restaurant.getTotalPlata());
                        alegere3 = obj.nextInt();

                    }
                    break;
                }
                case 3:{
                    try {
                        FileWriter myWriter = new FileWriter("Chitanta.txt");
                        myWriter.write(Restaurant.cosCumparaturi + "\nTotal plata: " + Restaurant.getTotalPlata());

                        if(Restaurant.getTotalPlata() > 30 && Restaurant.getTotalPlata() < 60){
                            myWriter.write("\nA fost aplicata o reducere de 5 Lei.");
                        }
                        else if(Restaurant.getTotalPlata() > 60){
                            myWriter.write("\nA fost aplicata o reducere de 10 Lei.");
                        }
                        else{
                            myWriter.write("\nNu a fost aplicata nici o reducere.");
                        }
                        Reducere.reducere(Restaurant.getTotalPlata());
                        myWriter.write("\nTotal plata: " + Restaurant.getTotalPlata());
                        myWriter.close();
                        System.out.println("Chitanta a fost tiparita.");
                    } catch (IOException e) {
                        System.out.println("Eroare in timpul tiparirii.");
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
                default:
                    System.out.println("Optiune nevalida.");
            }
            System.out.println(meniu);
            alegere = obj.nextInt();
        }


    }
}

