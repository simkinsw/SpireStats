package io.github.simkinsw.spirestats;

import org.springframework.stereotype.Service;

@Service
public class RunService {

    private RunParser parser;
    private RunRepo repo;

    public RunService(RunParser parser, RunRepo repo)
    {
        this.parser = parser;
        this.repo = repo;       
        RunData rd = parser.readFromFile("1639586633.run");
        repo.save(rd);
    }
    
}
