package n1e3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;

public class Joc {
    private HashMap<String, String> llistaPreguntes;
    private Scanner lector;

    public Joc() {
        this.llistaPreguntes = new HashMap<String, String>();
        this.lector = new Scanner(System.in);
    }

    public Joc(String camiFitxer) {
        this.llistaPreguntes = new HashMap<String, String>();
        carregarFitxer(camiFitxer);
        this.lector = new Scanner(System.in);
    }

    public void carregarFitxer(String camiFitxer) {
        try {
            File preguntes = new File(camiFitxer);
            Scanner in = new Scanner(preguntes);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (!line.equals("")) {
                    String[] parts = line.split(" ");
                    String country = parts[0].replace("_", " ");
                    String capital = parts[1].replace("_", " ");
                    llistaPreguntes.put(country, capital);
                    //System.out.printf("Country: %s -- Capital: %s\n", country, capital);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void jugar(int rondes, boolean guardar) {
        int puntuacio = 0;
        String usuari = presentarPregunta("Introdueix nom de jugador: ");
        ArrayList<String> llistaClaus = new ArrayList<>(llistaPreguntes.keySet());
        Collections.shuffle(llistaClaus);
        int i = 0;
        do {
            String pregunta = String.format("Ronda %d - Capital de %s: \n", (i + 1), llistaClaus.get(i));
            String respostaCorrecta = llistaPreguntes.get(llistaClaus.get(i));
            String resposta = presentarPregunta(pregunta);
            if (resposta.equals(respostaCorrecta)) {
                System.out.println("Correcte!");
                puntuacio++;
            } else {
                System.out.println("Incorrecte! La resposta correcta era: " + respostaCorrecta);
            }
            i++;
        } while (i < rondes);
        System.out.printf("Puntuació final de l'usuari %s: %s\n", usuari, puntuacio);
        if (guardar) {
            guardarPartida(usuari, puntuacio, rondes);
        }
    }

    public String presentarPregunta(String pregunta) {
        System.out.print(pregunta);
        return lector.nextLine();
    }

    public void guardarPartida(String usuari, int puntuacio, int rondes) {
        try {
            File fitxer = new File("classificació.txt");
            FileWriter fw = new FileWriter(fitxer, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String score = usuari + "\t" + String.valueOf(puntuacio) + "\t" + String.valueOf(rondes) + "\n";
            if (fitxer.length() == 0) {
                bw.write("usuari\tpuntuacio\trondes\n");
            }
            bw.write(score);
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
