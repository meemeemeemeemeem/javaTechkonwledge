package array;

import employee.Employee;
import employee.EmployeeT;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author mei
 * @since 2023/7/14 17:09
 */
public class CopyOfTest {
    public static Object[] badCopyOf(Object[]a ,int newLength){
        var newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }
    public static Object goodCopyOf(Object a ,int newLength){
        Class cl = a.getClass();
        if(!cl.isArray())return null;
        Class componentType =cl.getComponentType();
        int length= Array.getLength(a);
        Object newArray = Array.newInstance(componentType,length);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        a=(int[])goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[]b={"Tom","Dick","Harry"};
        b=(String[]) goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

        b=(String[])  badCopyOf(b,10);

    }
}
