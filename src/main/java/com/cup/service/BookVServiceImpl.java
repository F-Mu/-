package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cup.mapper.BookVMapper;
import com.cup.pojo.BookV;
import com.cup.pojo.PopularBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookVServiceImpl implements BookVService {
    @Autowired
    private BookVMapper bookVMapper;
    @Override
    public List<PopularBook> getPopularBooks(Wrapper<BookV> wrapper) {
        return bookVMapper.getPopularBooks(wrapper);
    }
}
