package edu.bit.datastructures.array;

import java.util.Comparator;
import java.util.stream.Stream;

public class ReverseSortNumberArray {

    /**
     * Input - String[] strs = { "1", "20", "23", "4", "8" }; Output - 8423201
     *
     * @param input
     */
    public void reverseLexicographicalOrder(String[] input) {
        Stream.of(input).sorted(Comparator.reverseOrder()).forEachOrdered(System.out::print);
    }
}
