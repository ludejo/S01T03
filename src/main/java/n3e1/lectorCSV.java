package n3e1;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class lectorCSV {
    private String separador;

    public lectorCSV() {
        this.separador = ",";
    }

    public static List<String[]> llegirCSV(String cami) {
        //TODO provar optional.orElse
        List<String[]> registre = null;
        try {
            registre = Files.readAllLines(Path.of(cami)).stream().map(l -> l.split(",")).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return registre;
    }

// TODO Crear col·lecció de classe amb generics+reflection
/*    public static <T> List<T> classificar(@NotNull List<String> registre, Class<T> nomClasse) {
        List<nomClasse> llistaClasse = registre.stream().map(ins -> new Class.forName(nomClasse));
        return llistaClasse;
    }*/



}
