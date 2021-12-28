package io.github.simkinsw.spirestats;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("runs")
public class RunController {

    private RunService service;

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

}
