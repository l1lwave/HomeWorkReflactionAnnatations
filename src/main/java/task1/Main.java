package task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SumNumbers sumNumbers = new SumNumbers();
        Class<?> cls = sumNumbers.getClass();

        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(MyTest.class)) {
                MyTest myTest = method.getAnnotation(MyTest.class);
                int result = (Integer)method.invoke(sumNumbers, myTest.a(), myTest.b());
                System.out.println(result);
            }
        }
    }
}

class SumNumbers {
    @MyTest(a = 15, b = 23)
    public static int sumNumbers(int n, int k) {
        return n + k;
    }
}
