package java9.collection_factory;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class After {


    //------List Examples ------
    @Test(expected = UnsupportedOperationException.class)
    public void normalList(){
        List<String> normalList = List.of("It", "is","a","normal","List");
        printWithSpace(normalList);
        normalList.set(3,"Unmodifiable");
    }

    @Test//(expected = NullPointerException.class)
    public void unmodifiableListWithNull_shouldThrowNullPointer(){
        Assert.assertThrows(NullPointerException.class,
                () ->{
                    List.of("It", "is","a","unmodifiable",null,"List");
                });
    }

    //----- Set Examples -----------

    @Test(expected = UnsupportedOperationException.class)
    public void normalSet(){


        Set<String> normalSet = Set.of( "It", "is","a","normal","Set");
        printWithSpace(normalSet);

        Set<String> temp = new LinkedHashSet<>(Arrays.asList("It", "is","a","Linked","Set"));
        Set<String> copySet = Set.copyOf( temp);
        printWithSpace(copySet);

        normalSet.remove("normal");
        normalSet.add("Unmodifiable");

    }
    @Test(expected = NullPointerException.class)
    public void unmodifiableSetWithNull_shouldThrowNullPointerException(){
        Set<String> nullSet = Set.of("It", "is","a","normal",null,"Set");
    }

    //----- Map examples -------------
    @Test(expected = UnsupportedOperationException.class)
    public void normalMap() {
        Map<String, String> tempMap = Map.of(
                                            "MT", "Malta",
                                            "BR", "Brazil",
                                            "AR", "Argentina"
                                            );

        printWithSpace(tempMap);

        tempMap.remove("AR");

    }

    @Test(expected = NullPointerException.class)
    public void unmodifiableMapWithNull_shouldThrowNullPointerException() {
        Map<String, String> tempMap = Map.of(
                                         "MT", "Malta",
                                         "BR", "Brazil",
                                         "AR", null
                                            );
        printWithSpace(tempMap);
    }

    private static void printWithSpace(Object obj){
        System.out.println();
        switch(obj){
            case List l -> l.forEach(a -> System.out.print(a + " "));
            case Set s -> s.forEach(a ->System.out.print(a+" "));
            case Map m -> m.forEach((a,b) -> System.out.println(a+" is Key of "+b));
            default -> new Object();
        }
    }
}
