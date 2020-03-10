package jp.co.chitose.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class UploaderController {

    @GetMapping("/")
    public String index(Model model){
        return "fileuploader";
    }

    @PostMapping("/uploaded")
    public String upload(Model model, @RequestParam("uploadfile") File file) {

        model.addAttribute("uploadfile", file);
        System.out.println(file.getName());

        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (fileExtension.equals(".csv") || fileExtension.equals(".jpg")) {
            return "analysis";
        } else {
            model.addAttribute("message","ファイルの形式が無効です。");
            return "fileuploader";
        }
    }


}
