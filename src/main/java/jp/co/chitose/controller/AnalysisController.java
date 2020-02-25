package jp.co.chitose.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class AnalysisController {


    @PostMapping("/analysis")
    public String analysis(Model model, @RequestParam("uploadfile") File file){
        model.addAttribute("uploadfile", file);
        System.out.println(file.getName());

        return "analysis";
    }
}
