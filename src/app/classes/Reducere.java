package app.classes;

import app.interfaces.Reduceri;

    public class Reducere implements Reduceri {

        public static void reducere(double val){
            if(Restaurant.getTotalPlata() > 30 && Restaurant.getTotalPlata() < 60) {
                Restaurant.setTotalPlata(-5);
            }
            if(Restaurant.getTotalPlata() > 60) {
                Restaurant.setTotalPlata(-10);
            }
        };
}
