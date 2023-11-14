package retos;

import java.util.Scanner;

public class SegundoReto {
    public static void main(String[] args) {
        String line = new Scanner(System.in).next();
        String result = "";
        int counter = 0;

        for (char character : line.toCharArray()){
            switch (character){
                case '#' -> counter++;
                case '@' -> counter--;
                case '*' -> counter = counter*counter;
                case '&' -> result = result.concat(String.valueOf(counter));
            }
        }

        System.out.println(result);
    }
}
