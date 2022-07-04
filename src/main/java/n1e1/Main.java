package n1e1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("SPRINT 01 - TASCA 01 - NIVELL 1 - EXERCICI 1");
        ArrayList<Month> calendari = new ArrayList<>();
        calendari.add(new Month("Gener"));
        calendari.add(new Month("Febrer"));
        calendari.add(new Month("Març"));
        calendari.add(new Month("Abril"));
        calendari.add(new Month("Maig"));
        calendari.add(new Month("Juny"));
        calendari.add(new Month("Juliol"));
        calendari.add(new Month("Setembre"));
        calendari.add(new Month("Octubre"));
        calendari.add(new Month("Novembre"));
        calendari.add(new Month("Desembre"));

        // Afegim mes nº8 a posició 7
        calendari.add(7, new Month("Agost"));

        // Comprovem que l'ordre es manté
        System.out.println("\nRecorregut amb for:");
        for (Month i : calendari) {
            System.out.println(i.getName());
        }

        // Recorrem amb iterator
        System.out.println("\nRecorregut amb iterador:");
        Iterator<Month> calendariIter = calendari.iterator();
        while (calendariIter.hasNext()) {
            System.out.println(calendariIter.next().getName());
        }

        // Convertim a HashSet
        HashSet<Month> calendariSet = new HashSet<>(calendari);
        System.out.println("Mida hashset pre: " + calendariSet.size());

        // Al haver sobreescrit equals/hashcode, la comparació ja no es fa per objecte sinó pel camp name
        // La cardinalitat del conjunt es manté
        Month gener = new Month("Gener");
        calendariSet.add(gener);
        System.out.println("Mida hashset post: " + calendariSet.size());

    }
}