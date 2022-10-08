package com.cup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cup.pojo.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends BaseMapper<Book> {
}
