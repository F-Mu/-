package com.cup.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.cup.pojo.BookV;
import com.cup.pojo.PopularBook;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookVMapper extends BaseMapper<BookV> {
    @Select("select b_id as bId, count(b_id) as count,b_type as bType from book_v ${ew.customSqlSegment} group by b_id order by count desc limit 0,10;")
    List<PopularBook> getPopularBooks(@Param(Constants.WRAPPER) Wrapper<BookV> wrapper);
}
