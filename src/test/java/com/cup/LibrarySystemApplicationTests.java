package com.cup;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cup.mapper.BookVMapper;
import com.cup.mapper.BpenaltyMapper;
import com.cup.pojo.*;
import com.cup.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class LibrarySystemApplicationTests {
    @Autowired
    private BookService bookService;
    @Autowired
    @Qualifier("booktypeServiceImpl")
    private BooktypeService booktypeService;
    @Autowired
    @Qualifier("revertServiceImpl")
    RevertService revertService;

    @Autowired
    @Qualifier("readerServiceImpl")
    ReaderService readerService;

    @Autowired
    @Qualifier("borrowServiceImpl")
    BorrowService borrowService;

    @Autowired
    BpenaltyMapper bpenaltyMapper;
    @Autowired
    @Qualifier("bquantityServiceImpl")
    BquantityService bquantityService;

    @Autowired
    BookVMapper bookVMapper;
    @Autowired
    @Qualifier("rloginServiceImpl")
    RloginService rloginService;
    @Autowired
    @Qualifier("aloginServiceImpl")
    AloginService aloginService;
    @Test
    void contextLoads() {
    }

    @Test
    void BookTypeMapperTest() {
    }

    @Test
    void BookTypeSelectById() {
        System.out.println(booktypeService.SelectById("1"));
    }

    @Test
    void selectReaderById() {
        System.out.println(readerService.selectReaderById("2018011137"));
    }

    @Test
    void BorrowSelectListById() {
        List<Borrow> borrows = borrowService.selectListById("2018011137");
        for (Borrow borrow : borrows) {
            System.out.println(borrow);
        }
    }

    @Test
    void insert() {
    }

    @Test
    void ReturnSelectListById() {
        List<Revert> reverts = revertService.selectListById("2018011137");
        for (Revert aRevert : reverts) {
            System.out.println(aRevert);
        }
    }

    @Test
    void date() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        Date last = calendar.getTime();
        System.out.println(sdf.format(date));
        System.out.println(sdf.format(last));
    }

    @Test
    void testGV() {
        QueryWrapper<BookV> wrapper = new QueryWrapper<>();
        wrapper.eq("r_grade","2");
        List<PopularBook> popularBooks = bookVMapper.getPopularBooks(wrapper);
        for (PopularBook popularBook : popularBooks) {
            System.out.println(popularBook);
        }
    }
    @Test
    void testEmpty(){
        System.out.println(aloginService.selectPasswordById("1"));
    }

    @Test
    void del(){
        QueryWrapper<Bpenalty> wrapper=new QueryWrapper<>();
        wrapper.le("penalty",0);
        bpenaltyMapper.delete(wrapper);
        List<Bpenalty> bpenalties = bpenaltyMapper.selectList(wrapper);
        for (Bpenalty bpenalty : bpenalties) {
            System.out.println(bpenalty);
        }
    }
}
