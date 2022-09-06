package com.hn.controllers;

import com.hn.pojo.CoachLine;
import com.hn.service.CoachLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoachLineController {

    @Autowired
    private CoachLineService coachLineService;

    @GetMapping("/coach-line")
    public String chitietchuyendi(@RequestParam(name = "id", defaultValue = "0") int id,
                                      Model model) {

        CoachLine coachLine = coachLineService.getById(id);
        model.addAttribute("coachLine", coachLine);
        return "chi-tiet-chuyen-di";
    }

}
