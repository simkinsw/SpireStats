package io.github.simkinsw.spirestats;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class CardImporter {
    ObjectMapper mapper = new ObjectMapper();

    public CardInfo[] importCards(String jsonFile) {
        try {
            File json = ResourceUtils.getFile("classpath:" + jsonFile);
            return mapper.readValue(json, CardInfo[].class);
        }
        catch (Exception e) {
            return null;
        }
    }
}
