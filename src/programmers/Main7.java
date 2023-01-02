package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main7 {
    int[] numList = {1, 2, 3, 4, 5};
    List<Integer> result = Arrays.stream(numList).boxed().collect(Collectors.toList());
    ;
}
