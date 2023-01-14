package com.example.visualnutschallenge.challenges;

import challenges.Challenge1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class Challenge1Test {

    static int start, end;
    static String both;
    static Map<Integer,String> map = new HashMap<>();

    @BeforeAll
    static void setup() {
        start = 1;
        end  = 100;
        both =  "Visual Nuts";
    }

    @DisplayName("Assert list size")
    @Test
    void test_listSize_Success() {
        map = new HashMap<>();
        map.put( 3, "Visual");
        map.put( 5, "Nuts");

        var result = Challenge1.printNumbers(start, end, map, both);

        Assertions.assertEquals(result.size(), end - start + 1);
    }

    @DisplayName("Assert Visual Nuts for both divisors")
    @Test
    void test_divisorByBoth_Success() {
        map = new HashMap<>();
        map.put( 3, "Visual");
        map.put( 5, "Nuts");

        var result = Challenge1.printNumbers(start, end, map, both);

        for(int i = start; i <= end; i++){
            if(i % 3 == 0 && i % 5 == 0){
                Assertions.assertEquals(both, result.get(i-1));
            }
        }
    }

    @DisplayName("Assert that number is divisible by 3 and not divisible by both")
    @Test
    void test_divisionBy3_Success() {
        map = new HashMap<>();
        map.put( 3, "Visual");
        map.put( 5, "Nuts");

        var result = Challenge1.printNumbers(start, end, map, both);

        for(int i = start; i <= end; i++){
            if(i % 3 == 0 && i % 5 != 0){
                Assertions.assertEquals(map.get(3), result.get(i-1));
            }
        }
    }

    @DisplayName("Assert that if number is divisible by 5 and not divisible by 3 returns 'Five'")
    @Test
    void test_divisionBy5_Success() {
        map = new HashMap<>();
        map.put( 3, "Visual");
        map.put( 5, "Five");

        var result = Challenge1.printNumbers(start, end, map, both);

        for(int i = start; i <= end; i++){
            if(i % 3 != 0 && i % 5 == 0){
                Assertions.assertEquals(map.get(5), result.get(i-1));
            }
        }
    }

    @DisplayName("Assert that both works with many elements in map")
    @Test
    void test_divisionByBothWithManyElements_Success() {
        map = new HashMap<>();
        map.put( 3, "Visual");
        map.put( 5, "Nuts");
        map.put( 2, "Two");

        var result = Challenge1.printNumbers(start, end, map, both);

        for(int i = start; i <= end; i++){
            if(i % 2 == 0 && i % 3 == 0 && i % 5 == 0){
                Assertions.assertEquals(both, result.get(i-1));
            }
        }
    }

    @DisplayName("Assert that Visual Nuts is printed when second element is multiple of the first. " +
            "Assert that Nuts is never printed")
    @Test
    void test_secondElementIsMultipleOfFirstIs_Success() {
        map =  new HashMap<>();
        map.put( 3, "Visual");
        map.put( 6, "Nuts");

        var result = Challenge1.printNumbers(start, end, map, both);

        for(int i = start; i <= end; i++){
            Assertions.assertNotEquals(map.get(6), result.get(i-1));
            if(i % 3 == 0 && i % 6 == 0){
                Assertions.assertEquals(both, result.get(i-1));
            }
        }
    }
}
