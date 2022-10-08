package com.cup.controller;

import com.cup.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {
    @Autowired
    @Qualifier("readerServiceImpl")
    ReaderService readerService;

    @RequestMapping("/reader/profile")
    public String Profile(Model model, HttpSession session) {
        model.addAttribute("reader", readerService.selectReaderById((String) session.getAttribute("loginId")));
        return "reader/profile";
    }
}
