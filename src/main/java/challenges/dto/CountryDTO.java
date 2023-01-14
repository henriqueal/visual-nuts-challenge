package challenges.dto;

import java.util.List;

public class CountryDTO {
    String country;
    List<String> languages;

    public CountryDTO() {
    }

    public CountryDTO(String country, List<String> languages) {
        this.country = country;
        this.languages = languages;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "country='" + country + '\'' +
                ", languages=" + languages +
                '}';
    }
}
