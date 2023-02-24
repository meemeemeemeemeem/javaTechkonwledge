package org.example.generic;

import org.example.entity.People;

/**
 * @Author mei
 * @create 2023/1/1 17:05
 */
public class Test<T>{
    private T data;
    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data=data;
    }

}
