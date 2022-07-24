package br.com.rodriguestech.languages.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "main-languages")
public class Language {
    @Id
    private String id;
    private String name;
    private String logo;
    private int ranking;

    public Language(){}

    public Language(String name, String logo, int ranking) {
        this.name = name;
        this.logo = logo;
        this.ranking = ranking;
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }
    public String getLogo() {
        return logo;
    }
    public int getRanking() {
        return ranking;
    }    
}
