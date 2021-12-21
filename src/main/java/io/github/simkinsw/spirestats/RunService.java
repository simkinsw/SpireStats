package io.github.simkinsw.spirestats;

import org.springframework.stereotype.Service;

@Service
public class RunService {

    private RunParser parser;

    public RunService()
    {
        System.out.println("test");
        parser = new RunParser();
        
    }
    
}
