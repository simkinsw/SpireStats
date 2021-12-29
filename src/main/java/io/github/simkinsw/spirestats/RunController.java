package io.github.simkinsw.spirestats;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("runs")
public class RunController {

    private RunService service;
    private static final Set<String> VALID_CHARACTERS = new HashSet<String>(Arrays.asList("ironclad", "silent", "defect", "watcher"));

    public RunController(RunService newService) {
        service = newService;
    }

    @ResponseBody
    @GetMapping("/demo")
    public RunData getRunData() {
        RunParser parser = new RunParser();
        return parser.readFromFile("1639586633.run");
    }

    @GetMapping("/index")
    public String showRunList(Model model) {
        model.addAttribute("runs", service.findAllRuns());
        return "index";
    }

    @GetMapping("/cards/{character}")
    public String showIroncladCardStats(Model model, @PathVariable("character") String character) {
        character = character.toLowerCase();
        if(!VALID_CHARACTERS.contains(character)) {
            return "fail";
        }

        List<CardInfo> cardInfos = service.findCardsByCharacter(character);
        List<String> cardNames = new ArrayList<String>();
        HashMap<String, HashMap<String, Integer>> allPickData = new HashMap<String, HashMap<String, Integer>>();
        for(CardInfo info : cardInfos) {
            String name = info.name;
            cardNames.add(name);
            HashMap<String, Integer> pickData = service.cardData(name);
            allPickData.put(name, pickData);
        }
        model.addAttribute("pickData", allPickData);
        model.addAttribute("cardNames", cardNames);
        return "cards";
    }

}
