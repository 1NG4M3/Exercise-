package tregulovReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class employeeClass = Class.forName("tregulovReflection.Employee");

//        Employee o = (Employee) employeeClass.newInstance();
//        System.out.println(o);

        Constructor<Employee> constructor1 = employeeClass.getConstructor();
        Employee obj = constructor1.newInstance();

        Constructor constructor2 = employeeClass.getConstructor(int.class,String.class,String.class);
        Object obj2 = constructor2.newInstance(5,"Dmitry","IT");
        System.out.println(obj2);

        Method method = employeeClass.getMethod("setSalary", double.class);
        method.invoke(obj2,800.88);
        System.out.println(obj2);
    }
}
