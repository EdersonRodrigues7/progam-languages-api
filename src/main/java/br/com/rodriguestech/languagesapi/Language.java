package br.com.rodriguestech.languagesapi;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    } 
       
}
