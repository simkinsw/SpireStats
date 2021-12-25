package io.github.simkinsw.spirestats;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
public class RunData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public int[] goldPerFloor;
    public int floorReached;
    public int playtime;
    //public String[] itemsPurged;
    public int score;

    @Column(unique = true)
    public String playId;

    public String localTime;
    public Boolean isAscensionMode;

    
    @OneToMany(mappedBy = "runData", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    public Set<CampfireData> campfireChoices;
    

    public String neowCost;
    public long seedSourceTimestamp;
    public int circletCount;
    //public String[] masterDeck;
    public int specialSeed;
    //public String[] relics;
    public int[] potionsFloorUsage;
    //public HashMap[] damageTaken;
    public String seedPlayed;
    //public HashMap[] potionsObtained;
    public Boolean isTrial;
    //public String[] pathPerFloor;
    public String characterChosen;
    //public String[] itemsPurchased;
    public int campfireRested;
    public int[] itemPurchaseFloors;
    public int[] currentHpPerFloor;
    public int gold;
    public String neowBonus;
    public Boolean isProd;
    public Boolean isDaily;
    public Boolean chooseSeed;
    public int campfireUpgraded;
    public int winRate;
    public int timestamp;
    //public String[] pathTaken;
    public String buildVersion;
    public int purchasedPurges;
    public Boolean victory;
    public int[] maxHpPerFloor;
    //public HashMap[] cardChoices;
    public int playerExperience;
    //public HashMap[] relicsObtained;
    //public HashMap[] eventChoices;
    public Boolean isBeta;
    //public HashMap[] bossRelics;
    public int[] itemsPurgedFloors;
    public Boolean isEndless;
    public int[] potionsFloorSpawned;
    public int ascensionLevel;

    public void saveCampfires() {
        for(CampfireData cd : campfireChoices) {
            cd.runData = this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }

        RunData other = (RunData)o;
        return other.playId.equals(this.playId);
    }
}