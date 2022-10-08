package com.cup.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cup.pojo.*;
import com.cup.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    @Qualifier("booktypeServiceImpl")
    BooktypeService booktypeService;

    @Autowired
    @Qualifier("bookServiceImpl")
    BookService bookService;

    @Autowired
    @Qualifier("bquantityServiceImpl")
    BquantityService bquantityService;

    @Autowired
    @Qualifier("borrowServiceImpl")
    BorrowService borrowService;

    @Autowired
    @Qualifier("revertServiceImpl")
    RevertService revertService;

    @Autowired
    @Qualifier("bpenaltyServiceImpl")
    BpenaltyService bpenaltyService;

    @Autowired
    @Qualifier("readerServiceImpl")
    ReaderService readerService;

    @Autowired
    @Qualifier("rloginServiceImpl")
    RloginService rloginService;

    @RequestMapping("/admin/books/{Page}")
    public String AdminBooks(Model model, @PathVariable("Page") int Page) {
        int size = 10;
        Page<Book> page = new Page<>(Page, size);
        bookService.selectPage(page, null);
        List<Book> bookList = page.getRecords();
        model.addAttribute("books", bookList);
        model.addAttribute("quantity", bquantityService);
        model.addAttribute("nowPage", Page);
        model.addAttribute("prePage", Page - 1);
        model.addAttribute("sufPage", Page + 1);
//        model.addAttribute("name", null);
        return "admin/books";
    }

    @RequestMapping("/admin/returnID")
    public String returnID() {
        return "admin/returnID";
    }

    @Transactional
    @RequestMapping("/admin/borrow")
    public String borrow(String rid, String bid) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, 1);
        Date last = calendar.getTime();
        borrowService.insertBorrow(rid, bid, now, last);
        bquantityService.updateRemainById(bid, -1);
        return "redirect:/admin/books/1";
    }

    @RequestMapping("/admin/return")
    public String borrow(Model model, String id) {
        model.addAttribute("borrows", borrowService.selectListById(id));
        model.addAttribute("bookService", bookService);
        model.addAttribute("id", id);
        return "admin/return";
    }

    @Transactional
    @RequestMapping("/admin/penalty")
    public String penalty(@ModelAttribute("rid") String rid, @ModelAttribute("bid") String bid, Model model) {
        Borrow borrow = borrowService.selectOneById(bid, rid);
        float penalty = bpenaltyService.insertBpenalty(rid, bid, borrow.getExpectReturnDate(), new Date());
        borrowService.deleteBorrowById(rid, bid);
        revertService.insertRevert(rid, bid, borrow.getBorrowDate());
        bquantityService.updateRemainById(bid, 1);
        model.addAttribute("penalty", penalty);
        model.addAttribute("expect", borrow.getExpectReturnDate());
        model.addAttribute("now", new Date());
        model.addAttribute("id", rid);
        return "admin/penalty";
    }

    @Transactional
    @RequestMapping("/admin/returnBook")
    public String returnBook(String rid, String bid, RedirectAttributes attr) {
        Borrow borrow = borrowService.selectOneById(bid, rid);
        int days = (int) ((new Date().getTime() - borrow.getExpectReturnDate().getTime()) / (1000 * 3600 * 24));//如果今天比预期时间要大至少一天
        if (days > 0) {
            attr.addFlashAttribute("rid", rid);
            attr.addFlashAttribute("bid", bid);
            return "redirect:/admin/penalty";
        }
        borrowService.deleteBorrowById(rid, bid);
        revertService.insertRevert(rid, bid, borrow.getBorrowDate());
        bquantityService.updateRemainById(bid, 1);
        attr.addAttribute("id", rid);
        return "redirect:/admin/return";
    }

    @RequestMapping("/admin/readers/{Page}")
    public String readers(Model model, @PathVariable("Page") int Page) {
        int size = 10;
        Page<Reader> page = new Page<>(Page, size);
        readerService.selectPage(page, null);
        List<Reader> readerList = page.getRecords();
        model.addAttribute("readers", readerList);
        model.addAttribute("nowPage", Page);
        model.addAttribute("prePage", Page - 1);
        model.addAttribute("sufPage", Page + 1);
        model.addAttribute("name", null);
        return "admin/readers";
    }

    @RequestMapping("/admin/query/{Page}")
    public String queryBookByName(String name, @PathVariable("Page") int Page, Model model) {
        int size = 10;
        Page<Book> page = new Page<>(Page, size);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("b_name", name);
        bookService.selectPage(page, wrapper);
        List<Book> bookList = page.getRecords();
        model.addAttribute("booktypeService", booktypeService);
        model.addAttribute("books", bookList);
        model.addAttribute("quantity", bquantityService);
        model.addAttribute("nowPage", Page);
        model.addAttribute("prePage", Page - 1);
        model.addAttribute("sufPage", Page + 1);
        model.addAttribute("name", name);
        return "admin/queryBook";
    }

    @RequestMapping("/admin/readers/query")
    public String readers(Model model, String id) {
        model.addAttribute("reader", readerService.selectReaderById(id));
        model.addAttribute("id", id);
        return "admin/queryReader";
    }

    @RequestMapping("/admin/updateReader")
    public String updateReader(Model model, String id) {
        Reader reader = readerService.selectReaderById(id);
        model.addAttribute("reader", reader);
        return "admin/updateReader";
    }

    @Transactional
    @RequestMapping("/admin/successUpdateReader")
    public String successUpdate(Reader reader, Rlogin rlogin) {
        readerService.updateById(reader);
        rloginService.updateRlogin(rlogin);
        return "redirect:/admin/readers/1";
    }

    @Transactional
    @RequestMapping("/admin/successAddReader")
    public String successAddReader(Reader reader, Rlogin rlogin) {
        readerService.insertReader(reader);
        rloginService.insertRlogin(rlogin);
        return "redirect:/admin/readers/1";
    }

    @RequestMapping("/admin/addReader")
    public String addReader() {
        return "admin/addReader";
    }

    @RequestMapping("/admin/insertBook")
    public String addBook(Model model) {
        model.addAttribute("booktypeService", booktypeService);
        return "admin/addBook";
    }

    @Transactional
    @RequestMapping("/admin/successInsertBook")
    public String successInsertBook(Book book, int count) {
        bookService.insertBook(book);
        bquantityService.insertQuantity(book, count);
        return "redirect:/admin/books/1";
    }

    @RequestMapping("/admin/addBook")
    public String addBook(String bid,int count){
        bquantityService.addBookById(bid,count);
        return "redirect:/admin/books/1";
    }
}
