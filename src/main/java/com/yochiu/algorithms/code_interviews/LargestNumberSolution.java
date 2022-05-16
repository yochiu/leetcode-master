package com.yochiu.algorithms.code_interviews;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumberSolution {

    public String largestNumber(int[] nums) {
        return Arrays.stream(Arrays.stream(nums).boxed().toArray()).map(String::valueOf)
                .sorted((x, y) -> (y + x).compareTo(x + y))
                .collect(Collectors.collectingAndThen(Collectors.joining(""), s -> s.charAt(0) == '0' ? "0" : s));

    }



}
