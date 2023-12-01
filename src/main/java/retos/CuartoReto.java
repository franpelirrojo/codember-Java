package retos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Cada archivo tiene un nombre con dos partes, separadas por un guion (-).
La primera parte es una cadena alfanumérica y la segunda es unchecksum, que es una cadena
formada por los caracteres que sólo aparecen una vez en la primera parte y en el orden en que aparecen.
Escribe un programa que determine si un archivo es real o falso basado en estas reglas.
Ejemplos:
    Nombre del archivo: xyzz33-xy
    Resultado: ✅ Real (El checksum es válido)

    Nombre del archivo: abcca1-ab1
    Resultado: ❌ Falso (El checksum debería ser b1, es incorrecto)

    Nombre del archivo: abbc11-ca
    Resultado: ❌ Falso (El checksum debería ser ac, el orden es incorrecto)
Cada línea indica el nombre del archivo y su correspondiente checksum,
separados por un guion (-).
** Cómo resolverlo **
1. Analiza la lista de nombres de archivos y sus checksums que encontrarás
en este archivo: https://codember.dev/data/files_quarantine.txt
2. Busca el archivo real número 33 (de todos los archivos reales, el 33º en orden de apareción)
y envía su checksum con submit. Por ejemplo si el archivo es xyzz33-xy, harías:
 */

public class CuartoReto {
	public static void main(String[] args) {
		BufferedReader reader;
		ArrayList<String> valid = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(".\\dataRetoCuatro.txt"));
			while (reader.ready()){
				String line = reader.readLine();
				String[] splitLine = line.split("-");
				String name = splitLine[0];
				String checksum = splitLine[1];

				LinkedHashMap<Character, Integer> repeated = new LinkedHashMap<>();
				for (char character : name.toCharArray()){
					int recuento = repeated.getOrDefault(character, 0);
					repeated.put(character, recuento + 1);
				}

				StringBuilder calculatedChecksum = new StringBuilder();
				for (Map.Entry<Character, Integer> entry : repeated.entrySet()){
					if (entry.getValue() == 1){
						calculatedChecksum.append(entry.getKey());
					}
				}

				if (calculatedChecksum.toString().equals(checksum)){
					valid.add(checksum);
				}
			}

			System.out.println(valid.get(32));
		} catch (IOException e) { throw new RuntimeException(e);
		}
	}
}
