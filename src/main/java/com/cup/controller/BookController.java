package com.cup.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cup.pojo.Book;
import com.cup.pojo.BookV;
import com.cup.pojo.Booktype;
import com.cup.pojo.PopularBook;
import com.cup.service.BookService;
import com.cup.service.BookVService;
import com.cup.service.BooktypeService;
import com.cup.service.BquantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    BookService bookService;
    @Autowired
    @Qualifier("booktypeServiceImpl")
    BooktypeService booktypeService;
    @Autowired
    @Qualifier("bquantityServiceImpl")
    BquantityService bquantityService;

    @Autowired
    @Qualifier("bookVServiceImpl")
    BookVService bookVService;

    @RequestMapping("/reader/books/{Page}")
    public String Books(Model model, @PathVariable("Page") int Page) {
        int size = 10;
        Page<Book> page = new Page<>(Page, size);
        bookService.selectPage(page, null);
        List<Book> bookList = page.getRecords();
        model.addAttribute("booktypeService", booktypeService);
        model.addAttribute("books", bookList);
        model.addAttribute("quantity", bquantityService);
        model.addAttribute("nowPage", Page);
        model.addAttribute("prePage", Page - 1);
        model.addAttribute("sufPage", Page + 1);
//        model.addAttribute("name", null);
//        model.addAttribute("booktypes", booktypeService.selectList(null));
        return "reader/books";
    }

    @RequestMapping("/reader/query/{Page}")
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
        return "reader/query";
    }

    @RequestMapping("/reader/popular")
    public String popularBooks(String dept, Integer grade, String type, Model model) {
        QueryWrapper<BookV> wrapper = new QueryWrapper<>();
        if (dept != null && !dept.equals("无"))
            wrapper.eq("r_dept", dept);
        if (grade != null && grade != 0)
            wrapper.eq("r_grade", grade);
        if (type != null && !type.equals("无"))
            wrapper.eq("b_type", type);
        List<PopularBook> popularBooks = bookVService.getPopularBooks(wrapper);
        List<Booktype> booktypes = booktypeService.selectList(null);
        model.addAttribute("books", popularBooks);
        model.addAttribute("booktypeService", booktypeService);
        model.addAttribute("bookService", bookService);
        model.addAttribute("booktypes", booktypes);
        model.addAttribute("dept", dept);
        model.addAttribute("grade", grade);
        model.addAttribute("type", type);
        return "reader/popular";
    }

}
