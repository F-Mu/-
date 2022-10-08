package com.cup.controller;

import com.cup.service.BorrowService;
import com.cup.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Controller
public class UserIndexController {
    @Autowired
    @Qualifier("borrowServiceImpl")
    BorrowService borrowService;
    @Autowired
    @Qualifier("revertServiceImpl")
    RevertService revertService;

    @RequestMapping("/reader/index")
    public String index(Model model, HttpSession session) {
        String id = (String) session.getAttribute("loginId");
        model.addAttribute("borrow", borrowService.selectCountById(id));
        model.addAttribute("revert", revertService.selectCountById(id));
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour < 11)
            model.addAttribute("welcome", "上午好");
        else if (hour >= 11 && hour < 13)
            model.addAttribute("welcome", "中午好");
        else if (hour >= 13 && hour < 18)
            model.addAttribute("welcome", "下午好");
        else model.addAttribute("welcome", "晚上好");
        return "reader/index";
    }
}
