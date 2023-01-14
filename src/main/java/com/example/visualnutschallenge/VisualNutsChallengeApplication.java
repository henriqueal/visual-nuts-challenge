package com.example.visualnutschallenge;

import challenges.Challenge1;
import challenges.Challenge2;
import challenges.dto.CountryDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class VisualNutsChallengeApplication {

	public static void main(String[] args)  throws JsonProcessingException, IOException {
		challenge1();
		System.out.println("------------------------------------------------");
		challenge2();
		SpringApplication.run(VisualNutsChallengeApplication.class, args);
	}

	private static void challenge2() throws JsonProcessingException, IOException {
		List<CountryDTO> countries = Challenge2.readJson();
		System.out.println("Number of countries: " + Challenge2.numberOfCountries(countries));
		System.out.println("Number of official languages: " + Challenge2.numberOfficialLanguages(countries));
		System.out.println("Country with highest number of official languages: " +
				Challenge2.countryWithHighestNumberOfLanguages(countries).toString());
		System.out.println("Country with highest number of official languages that spoken Germany: " +
				Challenge2.countryWithMostNumberOfLanguagesAndDe(countries).toString());
		System.out.println("Most frequent language: " +
				Challenge2.languangeMostFrequent(countries).toString());
	}

	private static void challenge1() {
		System.out.println("## Challenge 1:");
		int start = 1;
		int end  = 100;
		Map<Integer,String> map = new HashMap<>();
		map.put( 3, "Visual");
		map.put( 5, "Nuts");

		String both =  "Visual Nuts";

		Challenge1.printNumbers(start, end, map, both).forEach(System.out::println);
	}

}
