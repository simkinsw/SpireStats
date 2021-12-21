package io.github.simkinsw.spirestats;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.util.ResourceUtils;

public class RunParser {
    ObjectMapper mapper = new ObjectMapper();

    RunData readFromFile(String jsonFile) {
        try {
            File json = ResourceUtils.getFile("classpath:" + jsonFile);
            return mapper.readValue(json, RunData.class);
        } catch (IOException e) {
            return null;
        }
    }
}
