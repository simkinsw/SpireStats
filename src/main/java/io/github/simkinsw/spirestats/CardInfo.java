package io.github.simkinsw.spirestats;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
public class CardInfo {

    @Id
    @GeneratedValue
    public Long id;

    public String name;
    public String type;
    public String character;
    public String rarity;

    public void setCharacter(String character) {
        this.character = character.toLowerCase();
    }
}
