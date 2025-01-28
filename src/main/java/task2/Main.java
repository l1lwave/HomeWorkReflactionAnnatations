package task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TextContainer textContainer = new TextContainer();
        Class<?> cls = textContainer.getClass();

        if (!cls.isAnnotationPresent(SaveTo.class)) {
            System.out.println("No Annatation");
            System.exit(0);
        }

        SaveTo saveTo = cls.getAnnotation(SaveTo.class);
        String path = saveTo.path();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(textContainer, path);
                break;
            }
        }

        System.out.println("Save to " + path);

    }
}
