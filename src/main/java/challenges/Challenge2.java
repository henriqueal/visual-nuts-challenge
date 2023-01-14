package challenges;

import challenges.dto.CountryDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Challenge2 {

    public static List<CountryDTO> readJson() throws JsonProcessingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<CountryDTO> countries = objectMapper.readValue(Paths.get("src/main/resources/countries.json").toFile(),
                new TypeReference<List<CountryDTO>>() {});
        return countries;
    }

    public static Integer numberOfCountries(List<CountryDTO> countries)  {
        return countries.size();
    }

    public static Integer numberOfficialLanguages(List<CountryDTO> countries){
        Set<String> languagesSet = new HashSet<>();
        for(CountryDTO c : countries){
            languagesSet.addAll(c.getLanguages());
        }
        return languagesSet.size();
    }

    private static List<String> findMostFrequent(List<CountryDTO> countries, Integer highest) {
        List<String> result = new ArrayList<>();
        for (CountryDTO c : countries) {
            if (c.getLanguages().size() == highest) {
                result.add(c.getCountry());
            }
        }
        return result;
    }

    public static List<String> countryWithHighestNumberOfLanguages(List<CountryDTO> countries) {
        Integer highest = 0;

        for(CountryDTO c : countries){
            if (c.getLanguages().size() > highest){
                highest = c.getLanguages().size();
            }
        }

        return findMostFrequent(countries, highest);
    }

    public static List<String> countryWithMostNumberOfLanguagesAndDe(List<CountryDTO> countries) {
        Integer highest = 0;
        for(CountryDTO c : countries){
            if (c.getLanguages().contains("de") && c.getLanguages().size() > highest) {
                highest = c.getLanguages().size();
            }
        }

        return findMostFrequent(countries, highest);
    }

    public static List<String> languangeMostFrequent(List<CountryDTO> countries) {
        Integer highest = 0;

        Map<String,Integer> map = fillFrequency(countries);

        highest = findHighestValue(highest, map);

        return findHighestCountries(highest, map);
    }

    private static List<String> findHighestCountries(Integer highest, Map<String, Integer> map) {
        List<String> result = new ArrayList<>();
        for(String k : map.keySet()){
            if(map.get(k) == highest){
                result.add(k);
            }
        }
        return result;
    }

    private static Integer findHighestValue(Integer highest, Map<String, Integer> map) {
        for(String k : map.keySet()){
            if(map.get(k) > highest){
                highest = map.get(k);
            }
        }
        return highest;
    }

    private static Map<String, Integer> fillFrequency(List<CountryDTO> countries) {
        Map<String,Integer> map = new HashMap<>();

        for(CountryDTO c : countries){
            for(String l : c.getLanguages()){
                map.put(l, map.get(l) == null ? 1 : map.get(l) + 1);
            }
        }
        return map;
    }
}
