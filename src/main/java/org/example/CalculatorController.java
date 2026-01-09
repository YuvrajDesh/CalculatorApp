package org.example;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double a,
            @RequestParam(required = false) Double b,
            @RequestParam String operation,
            Model model) {

        double result = 0;

        if ("sqrt".equals(operation)) {
            result = service.sqrt(a);
        } else if ("fact".equals(operation)) {
            result = service.factorial((int) a);
        } else if ("ln".equals(operation)) {
            result = service.ln(a);
        } else if ("pow".equals(operation) && b != null) {
            result = service.power(a, b);
        }

        model.addAttribute("result", result);
        return "index";
    }
}
