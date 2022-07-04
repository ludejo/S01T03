package n2e1;

import n1e1.Month;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurant> michelin = new HashSet<>();
        michelin.add(new Restaurant("Can Torra", 8));
        michelin.add(new Restaurant("Fam", 7));
        michelin.add(new Restaurant("Perdonats", 9));
        michelin.add(new Restaurant("Can Torra", 6));
        michelin.add(new Restaurant("Fam", 7));

        michelin.forEach(r -> System.out.printf("Restaurant: %s - Puntuació: %d\n", r.getNom(), r.getPuntuacio()));
        System.out.println(michelin.size());
    }
}
