package com.example.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

    @GetMapping("/")
    public String greeting(){
        return "main";
    }

    @RequestMapping(value = "/calc", params = "add", method = RequestMethod.POST)
    public String getAdd(@RequestParam Integer first, @RequestParam Integer second, Model model){
        model.addAttribute("result", first + second);
        return "main";
    }
    @RequestMapping(value = "/calc", params = "subtract", method = RequestMethod.POST)
    public String getSubstact(@RequestParam Integer first, @RequestParam Integer second, Model model){
        model.addAttribute("result", first - second);
        return "main";
    }
    @RequestMapping(value = "/calc", params = "multiply", method = RequestMethod.POST)
    public String getMultiply(@RequestParam Integer first, @RequestParam Integer second, Model model){
        model.addAttribute("result", first * second);
        return "main";
    }
    @RequestMapping(value = "/calc", params = "divide", method = RequestMethod.POST)
    public String getDivide(@RequestParam Double first, @RequestParam Double second, Model model){
        if (second != 0){
            model.addAttribute("result", getDiv(first, second));
        }
        else {
            model.addAttribute("result", "Ошибка");
        }
        return "main";
    }

    public double getDiv(double a, double b){
        return a/b;
    }
}