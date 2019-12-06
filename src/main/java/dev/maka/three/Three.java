package dev.maka.three;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Three {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/java/dev/maka/three/input.txt")))) {
            ArrayList<Set<Point>> wireList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                Set<Point> wire = new HashSet<>();
                int x = 0;
                int y = 0;
                for (String s : line.split(",")) {
                    String[] vector = s.split("(?<=\\D)");
                    String direction = vector[0];
                    int magnitude = Integer.parseInt(vector[1]);
                    for (int i = 0; i < magnitude; i++) {
                        switch (direction) {
                            case "U":
                                y++;
                                break;
                            case "R":
                                x++;
                                break;
                            case "D":
                                y--;
                                break;
                            case "L":
                                x--;
                                break;
                        }
                        Point p = new Point(x, y);
                        wire.add(p);
                    }
                }
                wireList.add(wire);
            }
            Set<Point> intersection = wireList.get(0);
            for (Set<Point> set : wireList) {
                intersection.retainAll(set);
            }
            int shortest = Integer.MAX_VALUE;
            for (Point p : intersection) {
                int distance = p.x + p.y;
                if (distance < shortest)
                    shortest = distance;
            }
            System.out.println("Shortest manhattan distance: " + shortest);
        }
    }
}
