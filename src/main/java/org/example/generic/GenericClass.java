package org.example.generic;

/**
 * @Author mei
 * @create 2023/1/1 14:44
 */

public class GenericClass<T>{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GenericClass(T data) {
        this.data = data;
    }

    public <E> E getAllData(E data){
        return  data;
    }

    public <E extends Comparable<E>> E compareTo(E a , E b){
        return a.compareTo(b)>0?a:b;
    }
}
