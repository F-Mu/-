package com.cup.controller;

import com.cup.service.AdminService;
import com.cup.service.AloginService;
import com.cup.service.ReaderService;
import com.cup.service.RloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    @Qualifier("readerServiceImpl")
    ReaderService readerService;
    @Autowired
    @Qualifier("rloginServiceImpl")
    RloginService rloginService;
    @Autowired
    @Qualifier("aloginServiceImpl")
    AloginService aloginService;
    @Autowired
    @Qualifier("adminServiceImpl")
    AdminService adminService;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String id,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        String realPassword = rloginService.selectPasswordById(id);
        if (realPassword == null || !realPassword.equals(password)) {
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
        session.setAttribute("loginUser", readerService.selectNameById(id));
        session.setAttribute("loginId", id);
        return "redirect:/reader/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/toIndex")
    public String userLogin() {
        return "redirect:/";
    }

    @RequestMapping("/admin")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping("/admin/login")
    public String index(@RequestParam("username") String id,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        String realPassword = aloginService.selectPasswordById(id);
        System.out.println(realPassword);
        if (realPassword == null || !realPassword.equals(password)) {
            model.addAttribute("msg", "用户名或密码错误");
            return "admin/login";
        }
        session.setAttribute("loginUser", adminService.selectNameById(id));
        session.setAttribute("loginId", id);
        return "redirect:/admin/books/1";
    }
}
