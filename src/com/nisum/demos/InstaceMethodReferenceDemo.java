package com.nisum.demos;

import com.nisum.functionalinterfaces.IntPredicate;
import com.nisum.methodreference.IntPredicateCheckerForInstanceMethodReference;
import com.nisum.methodreference.IntPredicateCheckerForStaticMethodReference;

public class InstaceMethodReferenceDemo {


    private final int num ;


    public InstaceMethodReferenceDemo(int num) {
        this.num = num;
    }

    public  boolean isBigger(int num){
        return this.num>num;
    }

    public  boolean numCheck(IntPredicate p, int n){
        return p.check(n);
    }

    public static void main(String[] args) {
        InstaceMethodReferenceDemo demo= new InstaceMethodReferenceDemo(10);
        int numToCompare=9;

        // Here, Using lambda expression to check if a number is bigger
        IntPredicate checker =number -> demo.num>number;
        boolean check1 = checker.check(numToCompare);
        if(check1){
            System.out.println(demo.num + " is bigger than " + numToCompare);
        }else{
            System.out.println(demo.num + " is smaller or equal than " + numToCompare);
        }
        // Here, Using a method reference  to check a number is bigger or not
        IntPredicate isBigger = demo::isBigger;
        boolean check=isBigger.check(numToCompare);
        if(check){
            System.out.println(demo.num + " is bigger than " + numToCompare);
        }else{
            System.out.println(demo.num + " is smaller or equal than " + numToCompare);
        }


        boolean result;
        int num = 9;

        // Here, Using lambda expression to check if a number is even
        IntPredicate lb1 = number -> (number % 2) ==0;
        result = demo.numCheck(lb1, num);
        System.out.println("Using lambda expression: " + num + " is even: " + result);

        // Here, a method reference to  instance method isEven of IntPredicatesChecker is passed to numCheck().
        IntPredicateCheckerForInstanceMethodReference reference = new IntPredicateCheckerForInstanceMethodReference();
        result = demo.numCheck(reference::isEven, num);

        System.out.println("Using static method reference: " + num + " is even: " + result);

        // Here, Using lambda expression to check if a number is positive
        IntPredicate lb2 = number -> number > 0;
        result = demo.numCheck(lb2, num);
        System.out.println("Using lambda expression: " + num + " is positive: " + result);

        // Here, a method reference to  instance method isPositive of IntPredicatesChecker is passed to numCheck().
        IntPredicateCheckerForInstanceMethodReference referenceOne = new IntPredicateCheckerForInstanceMethodReference();
        result = demo.numCheck(referenceOne::isPositive, num);
        System.out.println("Using static method reference: " + num + " is positive: " + result);



    }
}
