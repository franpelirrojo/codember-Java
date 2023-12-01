package retos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
Para solucionar el problema, han creado una lista (tu entrada al desafío) de contraseñas (según la base de datos
corrupta) y la política de seguridad cuando esa clave fue establecida.

Ejemplo de la lista:

    2-4 f: fgff
    4-6 z: zzzsg
    1-6 h: hhhhhh

Cada línea indica, separado por :, la política de la clave y la clave misma.

La política de la clave especifica el número mínimo y máximo de veces que un carácter dado debe aparecer
para que la clave sea válida. Por ejemplo, 2-4 f significa que la clave debe contener f al menos 2 veces
y como máximo 4 veces.

Sabiendo esto, en el ejemplo anterior, hay 2 claves válidas:

La segunda clave, zzzsg, no lo es; contiene 3 veces la letra z, pero necesita al menos 4. Las primeras
y terceras claves son válidas: contienen la cantidad adecuada de f y h, respectivamente, según sus políticas.
** Tu desafío: **

Determina cuántas claves de cifrado son válidas según sus políticas.
** Cómo resolverlo **

1. Analiza la lista de políticas y claves de cifrado que encontrarás
en este archivo: https://codember.dev/data/encryption_policies.txt

2. Crea un programa que devuelva la clave inválida número 42
 */

public class TercerReto {
	public static void main(String[] args) {
		BufferedReader reader;
		ArrayList<String> invalid = new ArrayList<>();
		int min;
		int max;
		char letter;

		try {
			reader = new BufferedReader(new FileReader(".\\dataRetoTres.txt"));
			while (reader.ready()){
				String line = reader.readLine();
				String[] splitLine = line.split(":");
				String codingPolicy = splitLine[0];
				String pass = splitLine[1].replaceAll("\s", "");

				String[] splitCoding = codingPolicy.split("\s");
				letter =  splitCoding[1].charAt(0);

				String[] splitNumbers = splitCoding[0].split("-");
				min = Integer.parseInt(splitNumbers[0]);
				max = Integer.parseInt(splitNumbers[1]);

				int counter = 0;
				for (char character : pass.toCharArray()){
					if (character == letter){
						counter++;
					}
				}

				if (counter < min || counter > max){
					invalid.add(pass);
				}
			}

			System.out.println(invalid.get(41));
		} catch (IOException e) { throw new RuntimeException(e);
		}
	}
}
