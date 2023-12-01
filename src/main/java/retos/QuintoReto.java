package retos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
		ArrayList<String> invalid = new ArrayList<>();
		String[] row;

		try {
			reader = new BufferedReader(new FileReader(".\\dataRetoCinco.csv"));
			while (reader.ready()){
				boolean valid = true;
				String[] buffer = reader.readLine().split(",");
				if (buffer.length < 5){
					row = Arrays.copyOf(buffer, 5);
					row[4] = "";
				}else {
					row = buffer;
				}

				String user = row[1];
				System.out.println(Arrays.toString(row));
				if (row[0].equals("") || !row[0].matches("[a-zA-Z0-9]*")){
					valid = false;
					System.out.println("id incorrecto " + row[0]);
				}else if (user.equals("") && !user.matches("[a-zA-Z0-9]*")){
					valid = false;
					System.out.println("usuario incorrecto " + row[1]);
				}else if (row[2].equals("") ||
						!row[2].matches("^" + "(" + user + "|" + user.toLowerCase() + ")"
						+ "@[a-zA-Z]+\\.com$")){
					valid = false;
					System.out.println("email incorrecto " + row[2]);
				}else if (!row[3].equals("") && !row[3].matches("\\d*")){
					valid = false;
					System.out.println("edad incorrecta " + row[3]);
				} else if (!row[4].equals("") && !row[4].matches("[a-zA-Z\s]*")){
					valid = false;
					System.out.println("lugar incorrecta " + row[4]);
				}

				if (!valid){
					invalid.add(user);
				}
			}

			StringBuilder mensaje = new StringBuilder();
			for (String user : invalid){
				mensaje.append(user.charAt(0));
			}

			System.out.println(mensaje);
		} catch (IOException e) {throw new RuntimeException(e);
		}
	}
}
