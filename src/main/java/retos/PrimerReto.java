package retos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Los mensajes son palabras separadas por espacios como este:
gato perro perro coche Gato peRRo sol

Necesitamos que el programa nos devuelva el número de veces que aparece cada palabra
en el mensaje, independientemente de si está en mayúsculas o minúsculas.

El resultado será una cadena de texto con la palabra y el número de veces que aparece
en el mensaje, con este formato:
gato2perro3coche1sol1

¡Las palabras son ordenadas por su primera aparición en el mensaje!
 */

public class PrimerReto {
    public static void main(String[] args) {
        BufferedReader reader;
        String result = " ";

        try {
            reader = new BufferedReader(new FileReader(".\\dataRetoUno.txt"));
            List<String> words = new ArrayList<>();

            while (reader.ready()){
                String line = reader.readLine();
                words = List.of(line.split(" "));
            }

            Map<String, Long> count = words.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            for (Map.Entry<String, Long> entry : count.entrySet()){
                result = result.concat(entry.getKey() + count.get(entry.getKey()));
            }

            System.out.println(result);
        } catch (IOException e) { throw new RuntimeException(e);
        }
    }
}
