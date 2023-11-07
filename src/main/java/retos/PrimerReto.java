package retos;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrimerReto {
    public static void main(String[] args) {
        BufferedReader reader = null;
        String resultado = " ";

        try {
            reader = new BufferedReader(new FileReader(".\\src\\data.txt"));
            List<String> palabras = new ArrayList<>();

            while (reader.ready()){
                String line = reader.readLine();
                palabras = List.of(line.split(" "));
            }

            Map<String, Long> conteo = palabras.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            for (Map.Entry<String, Long> entry : conteo.entrySet()){
                resultado = resultado.concat(entry.getKey() + conteo.get(entry.getKey()));
            }

        } catch (FileNotFoundException e) { throw new RuntimeException(e);
        } catch (IOException e) { throw new RuntimeException(e);
        } finally {
            try {reader.close();} catch (IOException e) {throw new RuntimeException(e);}
        }

        System.out.println(System.getProperty("user.dir"));
    }
}
