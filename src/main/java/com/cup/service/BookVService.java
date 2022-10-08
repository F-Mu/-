package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.cup.pojo.BookV;
import com.cup.pojo.PopularBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookVService {
    List<PopularBook> getPopularBooks(@Param(Constants.WRAPPER) Wrapper<BookV> wrapper);
}
