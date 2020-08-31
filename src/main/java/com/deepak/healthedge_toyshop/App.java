package com.deepak.healthedge_toyshop;

import java.util.Arrays;
import java.util.List;

/**
 * Demo use case
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Toy> toyUseCase = Arrays.asList(new Toy("A",1,5),new Toy("B",10,1),new Toy("C",5,3),new Toy("D",3,2),new Toy("E",0,8));
        ToyCatalogue catalogue = new ToyCatalogue(toyUseCase);
        int maxNumberOfToysForGivenAmount = catalogue.getMaxNumberOfToysForGivenAmount(25);
        
        System.out.println("Max number of toys for given amount is "+ maxNumberOfToysForGivenAmount);
    }
}
