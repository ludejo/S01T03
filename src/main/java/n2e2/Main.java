package n2e2;

import n2e1.Restaurant;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Comparator<Restaurant> antonEgo = Comparator.comparing(Restaurant::getNom).thenComparing(Restaurant::getPuntuacio, Comparator.reverseOrder());
        TreeSet<Restaurant> michelin = new TreeSet<>(antonEgo);

        michelin.add(new Restaurant("Can Torra", 8));
        michelin.add(new Restaurant("La Traca", 8));
        michelin.add(new Restaurant("Fam", 7));
        michelin.add(new Restaurant("La Traca", 8));
        michelin.add(new Restaurant("Perdonats", 9));
        michelin.add(new Restaurant("Can Torra", 6));

        michelin.forEach(r -> System.out.printf("Restaurant: %s - Puntuació: %d\n", r.getNom(), r.getPuntuacio()));

    }
}
