package task3;

import java.io.*;
import java.lang.reflect.Field;

public class Main {
    public static void saveToFile(Object obj, String filename) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    writer.write(field.getName() + "=" + field.get(obj));
                    writer.newLine();
                }
            }
        }
    }

    public static void loadFromFile(Object obj, String filename) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Class<?> clazz = obj.getClass();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                String fieldName = parts[0];
                String value = parts[1];

                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                if (field.getType() == int.class) {
                    field.set(obj, Integer.parseInt(value));
                } else {
                    field.set(obj, value);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Car car1 = new Car("Red", 200, "ASFASFG231FSG231");
        System.out.println(car1);
        saveToFile(car1, "car.txt");

        Car car2 = new Car("", 0, "");
        loadFromFile(car2, "car.txt");

        System.out.println(car2);

    }
}
