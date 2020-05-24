/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author krawler
 */
public class StreamsDemo {

    public static void main(String[] args) {

//        printEvenNumbers();
//        CalculateSqareOfEachNumber();
//        SortNumber();
//        Find_MIN();
//        FindSquareOfEachElementAndAdd();
//            ConcatStringUsingReduceFunction();
            MapUsingStreams();

    }

    public static void MapUsingStreams() {

        Map<String, String> books = new HashMap<>();
        
        books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");
        
        Set<Map.Entry<String,String>> entry = books.entrySet();
        Collection<String> values =  books.values();
        Set<String> keys  = books.keySet();
        
        Stream<Entry<String,String>> stream =  entry.stream();
//        Set setValues = stream.filter(i -> "Effective Java".equals(i.getValue())).collect(Collectors.toSet());
        Optional<Entry<String,String>> setValues = stream.findAny();
        System.out.println(setValues);
       

    }
    public static void Find_MIN() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(15);
        list.add(25);
        list.add(10);
        list.add(3);
        list.add(999);
        list.add(38);
        list.add(2);
        
        Comparator<Integer> c = (i,j) -> i.compareTo(j);
        
        Integer minValue = list.stream().min(c).get();
        System.out.println(minValue);
    }

    public static void SortNumber() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(15);
        list.add(25);
        list.add(10);
        list.add(3);
        list.add(999);
        list.add(38);
        list.add(2);

        Comparator<Integer> c = (i1, i2) -> -i1.compareTo(i2);
//        {
//            if(i1<12){
//                return 1;
//            } else if (i1>i2){
//                return -1;
//            } else{
//                return 0;
//            }
//        } ;
        // (i1<i2 ?1:i1>i2 ?-1:0); // condition

        List updated = list.stream().sorted(c).collect(Collectors.toList());
        System.out.println(updated);

    }

    public static void printEvenNumbers() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(15);
        list.add(25);
        list.add(10);
        list.add(3);
        list.add(999);
        list.add(38);
        list.add(2);

        List updated = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(updated);

    }

    public static void CalculateSqareOfEachNumber() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(15);
        list.add(25);
        list.add(10);
        list.add(3);
        list.add(999);
        list.add(38);
        list.add(2);

        Function<Integer, Integer> f = i -> {
            return i * i;
        };
        List updated = list.stream().map(f).collect(Collectors.toList());
        System.out.println(updated);

    }
    
       public static void FindSquareOfEachElementAndAdd() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(10);
//        list.add(3);
//        list.add(999);
//        list.add(38);
//        list.add(2);

        Function<Integer, Integer> f = i -> {
            return i * i;
        };
        
        BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
               return i+j;
            }
        };
        
        Integer sum = list.stream().map(f).reduce(0, (i,j) -> i+j);
        System.out.println(sum);

    }
       
       public static void ConcatStringUsingReduceFunction() {
        List<String> list = new ArrayList<String>();
//        list.add("Santosh");
//        list.add("Vilas");
//        list.add("Belote");

//        BinaryOperator<String> b = new BinaryOperator<String>() {
//            @Override
//            public String apply(String i, String j) {
//               return i+j;
//            }
//        };
        
        Optional<String> concatedString = list.stream().reduce((acc,stream) -> acc + " " +stream);
//        String concatedString = list.stream().reduce("",(acc,stream) -> acc + " " +stream);
        System.out.println(concatedString.get());

    }
}
