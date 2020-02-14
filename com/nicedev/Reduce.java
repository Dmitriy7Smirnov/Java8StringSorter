package com.nicedev;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public Reduce() {
        List<Integer> numbers = Arrays.asList(7, 2, 3, 4, 5);
        System.out.println(numbers);
        Optional<Integer> sum = numbers.stream().reduce((left, right) -> { System.out.printf("left = %d  and  right = %d ;   ", left, right); return left + right; });
        sum.ifPresent(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1, 7, 3, 4, 5, 6);
        Integer identity = 10;
        Integer sum1 = numbers1.stream().reduce(identity, (left, right) -> {
            System.out.printf("left = %d, right = %d ;", left, right);
            return left + right;
        });
        System.out.println(sum1);

        List<Integer> numbers2 = Arrays.asList(3, 5, 7, 9, 1, 2);
        Integer sum3 = numbers2.stream().parallel()
                .reduce(10, (identity1, element) -> { System.out.printf("acc is here: identity1 = %d, element = %d ;\n", identity1, element); return identity1 * element; } ,
                        (left, right) -> { System.out.printf("combiner is here: left = %d,  right = %d ;\n", left, right); return left + right; });
        System.out.println(sum3);
    }
}
