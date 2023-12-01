package retos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
Nuestra base de datos está en formato .csv. Las columnas son id, username, email, age, location.
Un usuario sólo es válido si:
    - id: existe y es alfanumérica
    - username: existe y es alfanumérico
    - email: existe y es válido (sigue el patrón user@dominio.com)
    - age: es opcional pero si aparece es un número
    - location: es opcional pero si aparece es una cadena de texto

Ejemplos:
    Entrada: 1a421fa,alex,alex9@gmail.com,18,Barcelona
    Resultado: ✅ Válido

    Entrada: 9412p_m,maria,mb@hotmail.com,22,CDMX
    Resultado: ❌ Inválido (id no es alfanumérica, sobra el _)

    Entrada: 494ee0,madeval,mdv@twitch.tv,,
    Resultado: ✅ Válido (age y location son opcionales)
    Entrada: 494ee0,madeval,twitch.tv,22,Montevideo
    Resultado: ❌ Inválido (email no es válido)

** Cómo resolverlo **
1. Analiza la lista de entradas de la baes de datos y detecta
los inválidos: https://codember.dev/data/database_attacked.txt
2. Encuentra el primer caracter (número o letra) del username de cada
usuario inválido. Júntalos por orden de aparición y descubre el mensaje oculto.
 */
public class QuintoReto {
	public static void main(String[] args) {
		BufferedReader reader;
		ArrayList<String> row = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(".\\dataRetoCinco.txt"));

			String[] row;
			while (reader.ready()){
				row = reader.readLine().split(",([^,*])"); //Allow have "," in a column
				elements.add(row[column]);
			}
		} catch (IOException e) {throw new RuntimeException(e);
		}

		return elements;
	}
}
