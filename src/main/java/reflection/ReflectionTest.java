package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author mei
 * @since 2023/7/12 17:04
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String name;
        if(args.length>0){
            name = args[0];
        } else {
            var in =new Scanner(System.in);
            System.out.println("输入类名 例如 java.util.Date:");
            name=in.nextLine();
        }
        Class cl=Class.forName(name);
        Class supercl = cl.getSuperclass();

        String modifiers = Modifier.toString(cl.getModifiers());
        if(modifiers.length()>0)
        {
            System.out.print(modifiers);
        }
        System.out.println("class "+name);
        if(supercl!=null &&supercl!=Object.class){
            System.out.println("extends "+supercl.getName());
        }
        System.out.println("constructors:{");
        printConstructors(cl);
        System.out.println("methods:{");
        printMethods(cl);
        System.out.println("fields:{");
        printFields(cl);




    }

    private static void printFields(Class cl) {
        Field[] fields= cl.getDeclaredFields();
        for (Field field : fields) {
            Class type = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(field.getModifiers());

            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.println(type.getName()+name);
        }
        System.out.println("}");
    }

    private static void printMethods(Class cl) {
        Method[] methods=cl.getDeclaredMethods();
        for (Method method : methods) {
            Class retType = method.getReturnType();
            String name = method.getName();
            String modifiers = Modifier.toString(method.getModifiers());
            if ((modifiers.length()>0)) System.out.print(modifiers+" ");
            System.out.print(retType+" "+name+"(");
            Class[] paramTypes=method.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName()+",");
            }
            System.out.print(")");
            System.out.println();

        }
        System.out.println("}");
    }

    private static void printConstructors(Class cl) {
        Constructor[] constructors=cl.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            String modifiers=Modifier.toString(constructor.getModifiers());
            if ((modifiers.length()>0)) System.out.print(modifiers+" ");
            System.out.print(name +"(");
            Class[] paramTypes=constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName()+",");
            }
            System.out.print(")");
            System.out.println();

        }
        System.out.println("}");
    }

}
