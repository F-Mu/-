package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cup.pojo.Book;
import com.cup.pojo.Reader;
import org.apache.ibatis.annotations.Param;

public interface ReaderService {
    Reader selectReaderById(String id);
    String selectNameById(String id);
    void updateById(Reader reader);
    void selectPage(Page<Reader> page, @Param("ew") Wrapper<Reader> queryWrapper);
    void insertReader(Reader reader);
}
