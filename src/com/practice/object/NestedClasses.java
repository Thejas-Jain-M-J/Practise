package com.practice.object;

import com.practice.object.Food;

class Food {

    String foodName;

    void getInnerClassFOod() {
        System.out.println(new Maggie("Inner Maggie").localFoodName);
    }

    /**
     * This is Inner Class because this is non static class.
     * we can create object of this,but first we need to create object of outer
     * class
     * and then we can create object of inner class
     * All members of inner class are available to outer class just if we create
     * object of inner class.
     * It has access to all members (including private members) of the outer class.
     */
    class Maggie {
        String localFoodName;

        Maggie(String name) {
            localFoodName = name;
        }
    }

    void getNestedClassFOod() {
        System.out.println(new Noodles("Static  Noodles").staticFoodName);
    }

    /**
     * This nested class because its a static class
     * It does not have access to instance variables and methods of the outer class.
     * It can be instantiated without an instance of the outer class.
     */
    public static class Noodles {
        String staticFoodName = "";

        Noodles(String name) {
            staticFoodName = name;
        }

    }
}

public class NestedClasses {

    public static void main(String[] args) {

        Food outer = new Food();
        Food.Maggie Inner1 = outer.new Maggie("Maggie");
        outer.getInnerClassFOod();

        Food.Noodles Inner2 = new Food.Noodles("Static Noddles");
        outer.getNestedClassFOod();
    }

}
