package jp.co.chitose.controller;

import jp.co.chitose.form.ImageForm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultController {

    @ModelAttribute
    public ImageForm setForm() {
        return new ImageForm();
    }

    @PostMapping("/img")
    public String resulted(ImageForm imageForm, Model model)throws Exception {
        StringBuffer data = new StringBuffer();
        String base64 = new String(Base64.encodeBase64(imageForm.getImage().getBytes()), "ASCII");
        data.append("data:image/jpeg;base64,");
        data.append(base64);
        model.addAttribute("base64image", data.toString());
        return "result";
    }


}
