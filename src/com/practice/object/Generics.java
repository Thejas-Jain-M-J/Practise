package com.practice.object;

import java.util.ArrayList;
import java.util.List;

class Building{

}

class House extends Building{

}

class office extends Building{

}

class Library extends Building{

}

class one_BHK_house extends House
{

}


public class Generics {

    public static void main(String[] args) {
        
        /**
         * Why i can't send List<House> or List<office> to List<Building> is because it violates
         * the TYPE SAFETY .
         * 
         * But if there is list of type Building like this List<Building> for this we can add
         * House and office objects.  Because of polymorphism.
         * 
         * But i can't send List<House> or List<Office> to method where it expecting List<Building>
         * even though House and Office are subclass of Building.
         * 
         * If i want to send like line no 41 and 46 then we need to use wildcard pattern.
         * There are two types   1. UpperBound wild card  ( ? extends T )
         *                       2. LowerBound wild card  (? super T )
         */

        List<one_BHK_house> list3 = new ArrayList<>();
        list3.add(new one_BHK_house());
        list3.add(new one_BHK_house());
        new Generics().printBuilding(list3);
        // new Generics().insertElement(list3);  This will throw error as this method allow only House and it's super types

        List<office> list1 = new ArrayList<>();
        list1.add(new office());
        list1.add(new office());
        new Generics().printBuilding(list1);
        //new Generics().insertElement(list1);

        List<House> list2 = new ArrayList<>();
        list2.add(new House());
        list2.add(new House());
        new Generics().printBuilding(list2);
        new Generics().insertElement(list2);

        List<Building> list = new ArrayList<>();
        list.add(new Building());
        list.add(new Building());

        new Generics().printBuilding(list);
        new Generics().insertElement(list);

    }

    void printBuilding(List<? extends Building> list)
    {
        /** Here we used upper bound wild card , if we want to just read the list we can use this. 
         * just i can read the value what i am getting in list. I cant modify list. If i use
         * upper bound wildcard then list become immutable.
         * */

         list.forEach(i-> System.out.println(i));

    }

    void insertElement(List<? super House> list)
    {

        /**
         * Here we used lowe bound wild card if we want to modify list then i can use this.
         * Here this method can receive List of type House or any of it's super types.
         * But it cannot accepts subclass of house as the arguments.
         */
        
        list.add(new House());
       // list.add(new Building());
    }

}
