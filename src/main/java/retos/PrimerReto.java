package retos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrimerReto {
    public static void main(String[] args) {
        BufferedReader reader;
        String result = " ";

        try {
            reader = new BufferedReader(new FileReader(".\\src\\dataRetoUno.txt"));
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
