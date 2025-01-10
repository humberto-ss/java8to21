package java9.collection_factory;

import java.util.*;

public class Before {

    public static void main(String[] args) {
//        normalList();
//        unmodifiableListWithNull();

//        normalSet();
//        unmodifiableSetWithNull();

        normalMap();
        unmodifiableMapWithNull();
    }

    //------List Examples ------

    static void normalList(){
        List<String> normalList = Arrays.asList("It", "is","a","normal","List");
        printWithSpace(normalList);

        normalList.set(3,"Unmodifiable");
        normalList = Collections.unmodifiableList(normalList);

        printWithSpace(normalList);
    }

   static void unmodifiableListWithNull(){
        List<String> listExample = Collections.unmodifiableList(Arrays.asList("It", "is","a","unmodifiable",null,"List"));
        printWithSpace(listExample);
    }

    //----- Set Examples -----------

    static void normalSet(){
        Set<String> normalSet = new LinkedHashSet<>(Arrays.asList("It", "is","a","normal","Set"));
        printWithSpace(normalSet);

        normalSet.remove("normal");
        normalSet.add("Unmodifiable");

        normalSet = Collections.unmodifiableSet(normalSet);
        printWithSpace(normalSet);

    }
    static void unmodifiableSetWithNull(){
        Set<String> nullSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("It", "is","a","normal",null,"Set")));
        printWithSpace(nullSet);
    }

    //----- Map examples -------------
    static void normalMap() {
        Map<String, String> tempMap = new LinkedHashMap<>();
        tempMap.put("MT", "Malta");
        tempMap.put("BR", "Brazil");
        tempMap.put("AR", "Argentina");
        printWithSpace(tempMap);

        tempMap.remove("AR");
        printWithSpace(Collections.unmodifiableMap(tempMap));
    }

    static void unmodifiableMapWithNull() {
        Map<String, String> tempMap = new LinkedHashMap<>();
        tempMap.put("MT", "Malta");
        tempMap.put("BR", "Brazil");
        tempMap.put("AR", "Argentina");
        printWithSpace(tempMap);

        tempMap.replace("AR", null);
        printWithSpace(Collections.unmodifiableMap(tempMap));
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
