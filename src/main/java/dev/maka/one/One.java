package dev.maka.one;

import java.io.*;

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/java/dev/maka/one/input.txt")));

        int fuel = 0;
        String line;
        while ((line = reader.readLine()) != null ) {
            fuel += calculateFuel(Integer.parseInt(line));
        }
        System.out.println(fuel);
    }

    private static int calculateFuel(int mass) {
        int fuel = (int)Math.floor(mass/3) - 2;
        return fuel > 0 ? fuel + calculateFuel(fuel) : 0;
    }
}
