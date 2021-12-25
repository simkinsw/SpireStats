package io.github.simkinsw.spirestats;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RunService {

    private static final Logger log = LoggerFactory.getLogger(RunService.class);

    private RunParser parser;
    private RunDataRepository runRepo;
    private CampfireDataRepository campfireRepo;

    public RunService(RunParser newParser, RunDataRepository newRunRepo, CampfireDataRepository newCampfireRepo) {
        parser =  newParser;
        runRepo = newRunRepo;   
        campfireRepo = newCampfireRepo;    
        RunData rd = parser.readFromFile("1639586633.run");
        runRepo.save(rd);
        rd = parser.readFromFile("1619238219.run");
        runRepo.save(rd);

        
        log.info(runRepo.findByPlayId(rd.playId).characterChosen);
        log.info("campfire choices found:");
        log.info("---------------------------");
        for (CampfireData cf : campfireRepo.findByRunData(runRepo.findByPlayId(rd.playId))) {
            log.info(cf.key);
        }
        log.info("");
        
        
    }
    
}
