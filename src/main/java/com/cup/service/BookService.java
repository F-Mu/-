package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cup.pojo.Book;
import org.apache.ibatis.annotations.Param;

public interface BookService {
    String getNameById(String id);
    void selectPage(Page<Book> page, @Param("ew") Wrapper<Book> queryWrapper);
    void insertBook(Book book);
}
