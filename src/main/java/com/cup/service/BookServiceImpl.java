package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cup.mapper.BookMapper;
import com.cup.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public String getNameById(String id) {
        return bookMapper.selectById(id).getBName();
    }

    @Override
    public void selectPage(Page<Book> page, Wrapper<Book> queryWrapper) {
        bookMapper.selectPage(page, queryWrapper);
    }

    @Override
    public void insertBook(Book book) {
        if (bookMapper.selectById(book.getBId()) != null)
            return;
        bookMapper.insert(book);
    }

}
