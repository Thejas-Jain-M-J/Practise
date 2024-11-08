package com.practice.Generics;

import java.util.*;

public class GenericMethod {

    static   <T> List<T> toArrayList(T[] arr,List<T> list)
    {
        for(T o : arr)
        {
            list.add(o);
        }

        return list;
    }
    public static void main(String[] args) {
        
        Character[] ch = {'A', 'B', 'C', 'D'};
        String[] str = {"A", "B", "C", "D", "E"};
        Integer[] integer = {1,2,3,4,5,6,7};

        System.out.println(toArrayList(ch, new ArrayList<Character>()));
        System.out.println(toArrayList(str, new ArrayList<String >()));
        System.out.println(toArrayList(integer, new ArrayList<Integer>()));
    
    

    }

     

}
