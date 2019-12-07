package dev.maka.three;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Three {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/java/dev/maka/three/input.txt")))) {
            ArrayList<HashMap<Point, Integer>> wireList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                HashMap<Point, Integer> wire = new HashMap<>();
                int x = 0;
                int y = 0;
                int wireDistance = 0;
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
                        wire.put(p, ++wireDistance);
                    }
                }
                wireList.add(wire);
            }
            Set<Point> intersections = wireList.get(0).keySet();
            intersections.retainAll(wireList.get(1).keySet());

            ArrayList<Integer> distances = new ArrayList<>();
            for (Point p : intersections) {
                distances.add(wireList.get(0).get(p) + wireList.get(1).get(p));
            }
            System.out.println("Fewest combined steps: " + Collections.min(distances));
        }
    }
}
