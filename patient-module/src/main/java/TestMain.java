import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMain {

    public static void main(String[] args) {

        int[] array = {1,2,3,4};
        int[] output = new int [array.length];
        int count = 0;

        for(int i=0;i<array.length;i++){
            int mul = 1;
            for(int j=0;j<array.length;j++){
                if(j != count){
                    mul = mul * array[j];
                }
            }
            output[i] = mul;
            count++;

        }
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }

    }
}
