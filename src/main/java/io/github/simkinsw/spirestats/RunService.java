package io.github.simkinsw.spirestats;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RunService {

    private static final Logger log = LoggerFactory.getLogger(RunService.class);

    private RunParser parser;
    private CardImporter cardImporter;
    private RunDataRepository runRepo;
    private CardInfoRepository cardInfoRepo;
    private CardChoiceRepository cardRepo;


    public RunService(RunParser newParser, RunDataRepository newRunRepo, 
                            CardInfoRepository newCardInfoRepo, CardImporter ci,
                                CardChoiceRepository cr) {
        parser =  newParser;
        runRepo = newRunRepo;
        cardInfoRepo = newCardInfoRepo;  
        cardImporter = ci;
        cardRepo = cr;
        
        CardInfo[] cards = cardImporter.importCards("Cards.json");
        cardInfoRepo.saveAll(Arrays.asList(cards));


        File dir = new File("./src/main/resources");
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {     
                return name.toLowerCase().endsWith(".run");
            }
        });
        for(File f : files) {
            RunData rd = parser.readFromFile(f.getName());
            try {
                if(rd != null) {
                    runRepo.save(rd);
                }
            }
            catch (Exception e) {
                log.info(e.toString());
            }
        }            
    }

    public HashMap<String, Integer> cardData(String cardName) {
        int picked = cardRepo.findByCardNameAndPicked(cardName, true).size();
        int unpicked = cardRepo.findByCardNameAndPicked(cardName, false).size();
        HashMap<String, Integer> rets = new HashMap<String, Integer>();
        rets.put("picked", picked);
        rets.put("unpicked", unpicked);
        double percent = 100.0 * picked / (double)(unpicked + picked);
        rets.put("percent", (int)percent);
        return rets;
    }

    public Iterable<RunData> findAllRuns() {
        return runRepo.findAll();
    }

    public List<CardInfo> findCardsByCharacter(String character) {
        return cardInfoRepo.findByCharacter(character);
    }
}
