import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        List<String> myL = Arrays.asList("Manas", "Jaee", "Era", "Arya");
        Stream<String> myList = myL.stream();
//        System.out.println(myList.iterator().next().equals("Arya"));
        myList.forEach(m->System.out.print(m + "\t "));
        System.out.println(" ");

        Stream<String> myS = myL.stream();
        myS.forEach(m -> System.out.print(m.charAt(2) + "\t "));

        System.out.println(" ");
        Stream<String> gen = Stream.generate(() -> "item").limit(10);
        gen.forEach(s -> System.out.print(s + "\t "));


    }
}