package n1e2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> llistaEnters = new ArrayList<Integer>();
        llistaEnters.add(0);
        llistaEnters.add(1);
        llistaEnters.add(1);
        llistaEnters.add(2);
        llistaEnters.add(3);
        llistaEnters.add(5);
        llistaEnters.add(8);

        List<Integer> llistaEntersCopia = new ArrayList<Integer>();

        ListIterator<Integer> it = llistaEnters.listIterator(llistaEnters.size());

        while (it.hasPrevious()) {
            int i = it.previous();
            llistaEntersCopia.add(i);
        }

        for (int i = 0; i < llistaEnters.size(); i++) {
            System.out.printf("Posició %d: %d --- %d\n", i, llistaEnters.get(i), llistaEntersCopia.get(i));
        }
    }
}
