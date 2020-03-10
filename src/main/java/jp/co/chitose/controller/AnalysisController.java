package jp.co.chitose.controller;

import jp.co.chitose.form.ImageForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AnalysisController {

    @PostMapping("/analysis")
    public String analysis(Model model,
                          @RequestParam(value = "boxplot",defaultValue = "false") boolean boxplot,
                          @RequestParam(value = "linegraph",defaultValue = "false") boolean linegraph,
                          @RequestParam(value = "bargraph",defaultValue = "false") boolean bargraph){

        ArrayList<Boolean> List = new ArrayList<>();
        List.add(boxplot);
        List.add(linegraph);
        List.add(bargraph);
        model.addAttribute("List",List);

        return "result";
    }

}
