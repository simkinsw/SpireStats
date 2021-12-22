package io.github.simkinsw.spirestats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("runs")
public class RunController {
    
    @ResponseBody
    @GetMapping("/demo")
    public RunData getRunData() {
        RunParser parser = new RunParser();
        return parser.readFromFile("1639586633.run");
    }
}
