package com.example.visualnutschallenge.challenges;

import challenges.Challenge2;
import challenges.dto.CountryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Challenge2Test {

    static List<CountryDTO> countries;

    @DisplayName("Assert countries size")
    @Test
    void test_numberOfCountries_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO portugal = new CountryDTO("Portugal", Arrays.asList("pt"));

        countries.add(portugal);
        countries.add(brazil);

        var result = Challenge2.numberOfCountries(countries);
        Assertions.assertEquals(2, result);
    }

    @DisplayName("Assert official languages of all countries")
    @Test
    void test_numberOfficialLanguages_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO portugal = new CountryDTO("Portugal", Arrays.asList("pt"));
        CountryDTO usa = new CountryDTO("USA", Arrays.asList("en"));
        CountryDTO de = new CountryDTO("DE", Arrays.asList("de"));

        countries.add(portugal);
        countries.add(brazil);
        countries.add(usa);
        countries.add(de);

        var result = Challenge2.numberOfficialLanguages(countries);
        Assertions.assertEquals(3, result);
    }

    @DisplayName("Assert country with highest number of official languages without draw")
    @Test
    void test_countryWithHighestNumberOfLanguages_withoutDraw_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO portugal = new CountryDTO("Portugal", Arrays.asList("pt"));
        CountryDTO usa = new CountryDTO("USA", Arrays.asList("en"));
        CountryDTO be = new CountryDTO("BE", Arrays.asList("nl","fr","de"));

        countries.add(portugal);
        countries.add(brazil);
        countries.add(usa);
        countries.add(be);

        var result = Challenge2.countryWithHighestNumberOfLanguages(countries);
        Assertions.assertEquals(Arrays.asList("BE"), result);
    }

    @DisplayName("Assert the number of countries with highest official languages when draw happens")
    @Test
    void test_countryWithHighestNumberOfLanguages_withDraw_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO portugal = new CountryDTO("Portugal", Arrays.asList("pt"));
        CountryDTO usa = new CountryDTO("USA", Arrays.asList("en"));

        countries.add(portugal);
        countries.add(brazil);
        countries.add(usa);

        var result = Challenge2.countryWithHighestNumberOfLanguages(countries);
        Assertions.assertEquals(3, result.size());
    }

    @DisplayName("Assert the number of countries with highest official languages with 'De'")
    @Test
    void test_countryWithMostNumberOfLanguagesAndDe_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO germany = new CountryDTO("Germany", Arrays.asList("de"));
        CountryDTO netherland = new CountryDTO("Netherland", Arrays.asList("nl","fr","de"));

        countries.add(germany);
        countries.add(brazil);
        countries.add(netherland);

        var result = Challenge2.countryWithMostNumberOfLanguagesAndDe(countries);
        Assertions.assertEquals(Arrays.asList("Netherland"), result);
    }

    @DisplayName("Assert the number of countries with highest official languages with 'De' when draw happens")
    @Test
    void test_countryWithMostNumberOfLanguagesAndDeWithListWithList_withDraw_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO germany = new CountryDTO("Germany", Arrays.asList("de"));
        CountryDTO netherland = new CountryDTO("Netherland", Arrays.asList("nl","fr","de"));
        CountryDTO romania = new CountryDTO("Romania", Arrays.asList("ro","hu","de"));

        countries.add(germany);
        countries.add(brazil);
        countries.add(netherland);
        countries.add(romania);

        var result = Challenge2.countryWithHighestNumberOfLanguages(countries);
        Assertions.assertEquals(2, result.size());
    }

    @DisplayName("Assert that when there is no country with 'De' language will return empty list")
    @Test
    void test_countryWithMostNumberOfLanguagesAndDe_EmptyList_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO portugal = new CountryDTO("Portugal", Arrays.asList("pt"));
        CountryDTO usa = new CountryDTO("USA", Arrays.asList("en"));

        countries.add(brazil);
        countries.add(portugal);
        countries.add(usa);

        var result = Challenge2.countryWithMostNumberOfLanguagesAndDe(countries);
        Assertions.assertEquals(0, result.size());
    }

    @DisplayName("Assert the most frequent language")
    @Test
    void test_languangeMostFrequent_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO portugal = new CountryDTO("Portugal", Arrays.asList("pt"));
        CountryDTO usa = new CountryDTO("USA", Arrays.asList("en"));

        countries.add(brazil);
        countries.add(portugal);
        countries.add(usa);

        var result = Challenge2.languangeMostFrequent(countries);
        Assertions.assertEquals(Arrays.asList("pt"), result);
    }

    @DisplayName("Assert the most frequent language when draw happens")
    @Test
    void test_languangeMostFrequent_withDraw_Success() {
        countries = new ArrayList<>();

        CountryDTO brazil = new CountryDTO("Brazil", Arrays.asList("pt"));
        CountryDTO portugal = new CountryDTO("Portugal", Arrays.asList("pt"));
        CountryDTO usa = new CountryDTO("USA", Arrays.asList("en"));
        CountryDTO ireland = new CountryDTO("Ireland", Arrays.asList("ir","en"));
        CountryDTO test = new CountryDTO("Test", Arrays.asList("ir","de"));

        countries.add(brazil);
        countries.add(portugal);
        countries.add(usa);
        countries.add(ireland);
        countries.add(test);

        var result = Challenge2.languangeMostFrequent(countries);
        Assertions.assertEquals(3, result.size());
    }
}
