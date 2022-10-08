package com.cup.controller;

import com.cup.service.BookService;
import com.cup.service.BorrowService;
import com.cup.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BorrowController {
    @Autowired
    @Qualifier("borrowServiceImpl")
    BorrowService borrowService;
    @Autowired
    @Qualifier("bookServiceImpl")
    BookService bookService;
    @Autowired
    @Qualifier("revertServiceImpl")
    RevertService revertService;
    @RequestMapping("/reader/borrow")
    public String borrow(Model model, HttpSession session) {
        model.addAttribute("borrows", borrowService.selectListById((String) session.getAttribute("loginId")));
        model.addAttribute("bookService", bookService);
        return "reader/borrow";
    }

    @RequestMapping("/reader/return")
    public String ret(Model model, HttpSession session) {
        System.out.println(session.getAttribute("loginId"));
        model.addAttribute("reverts", revertService.selectListById((String) session.getAttribute("loginId")));
        model.addAttribute("bookService", bookService);
        return "reader/return";
    }
}
