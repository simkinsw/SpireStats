package io.github.simkinsw.spirestats;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class RunParser {
    ObjectMapper mapper = new ObjectMapper();

    RunData readData(String json) {
        try {
            return mapper.readValue(json, RunData.class);
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    RunData readFromFile(String jsonFile) {
        try {
            File json = ResourceUtils.getFile("classpath:" + jsonFile);
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            if(!"2020-12-22".equals(node.get("build_version").asText())) {
                return null;
            }
            return mapper.readValue(json, RunData.class);
        } catch (IOException e) {
            return null;
        }
    }

    
}
