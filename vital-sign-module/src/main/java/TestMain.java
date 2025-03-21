import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMain {

    public static void main(String[] args) {

        var string = "aa// @#%^&Abaadcefg";
        var counting = string.chars().mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(counting);

/*        var list = List.of(1000,2000,3000,5000);
       var thirdSalary = list.stream().sorted((a,b)->Comparator.comparing(a,b)).skip(2).findFirst();
        System.out.println(thirdSalary);*/
    }
}
