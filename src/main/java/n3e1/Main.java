package n3e1;

import java.util.List;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String[]> llista = lectorCSV.llegirCSV("C:\\Users\\oriol\\OneDrive\\Desktop\\ciutadans.txt");
        // TODO similar a python::unpack en java?
        // TODO alternativa menys verbosa a collect(...)
        List<Persona> persones = llista.stream().map(i -> new Persona(i[0], i[1], i[2])).collect(Collectors.toList());

        // Comparadors
        Comparator<Persona> ordreNom = Comparator.comparing(Persona::getNom);
        Comparator<Persona> ordreCognom = Comparator.comparing(Persona::getCognom);
        Comparator<Persona> ordreDni = Comparator.comparing(Persona::getDni);

        // TreeSet base amb DNI
        TreeSet<Persona> setPersones = new TreeSet<>(ordreDni);
        setPersones.addAll(persones);
        Iterator<Persona> iter = null;

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int input;
        do {
            String template = " Mostrar les persones ordenades per ";
            System.out.println("~ Registre ciutadà ~\n" +
                    "\t[1] Introduir persona\n" +
                    "\t[2]" + template + "nom (A-Z)\n" +
                    "\t[3]" + template + "nom (Z-A)\n" +
                    "\t[4]" + template + "cognoms (A-Z)\n" +
                    "\t[5]" + template + "cognoms (Z-A)\n" +
                    "\t[6]" + template + "DNI (1-9)\n" +
                    "\t[7]" + template + "DNI (9-1)\n" +
                    "\t[0] Sortir");
            input = scanner.nextInt();

            switch (input) {
                case 0:
                    System.out.println("Adéu!");
                    break;
                case 1:
                    System.out.println("Introdueix nom: ");
                    String inNom = scanner.next();
                    System.out.println("Introdueix cognom: ");
                    String inCognom = scanner.next();
                    System.out.println("Introdueix DNI: ");
                    String inDNI = scanner.next();
                    setPersones.add(new Persona(inNom, inCognom, inDNI));
                    break;
                case 2:
                    TreeSet<Persona> setPersonesNom = new TreeSet<>(ordreNom);
                    setPersonesNom.addAll(setPersones);
                    iter = setPersonesNom.iterator();
                    break;
                case 3:
                    TreeSet<Persona> setPersonesNomR = new TreeSet<>(ordreNom);
                    setPersonesNomR.addAll(setPersones);
                    iter = setPersonesNomR.descendingIterator();
                    break;
                case 4:
                    TreeSet<Persona> setPersonesCognom = new TreeSet<>(ordreCognom);
                    setPersonesCognom.addAll(setPersones);
                    iter = setPersonesCognom.iterator();
                    break;
                case 5:
                    TreeSet<Persona> setPersonesCognomR = new TreeSet<>(ordreCognom);
                    setPersonesCognomR.addAll(setPersones);
                    iter = setPersonesCognomR.descendingIterator();
                    break;
                case 6:
                    iter = setPersones.iterator();
                    break;
                case 7:
                    iter = setPersones.descendingIterator();
                    break;
                default:
                    System.out.println("Input no vàlid");
                    break;
            }
            if (input > 1 && input < 8) iter.forEachRemaining(p -> System.out.println(p.toString()));

        } while (input != 0);
    }
}
