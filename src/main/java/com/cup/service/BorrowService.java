package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cup.pojo.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BorrowService {
    List<Borrow> selectListById(String rid);
    void selectPage(Page<Borrow> page, @Param("ew") Wrapper<Borrow> queryWrapper);
    int selectCountById(String id);
    void insertBorrow(String rid, String bid, Date now,Date last);
    void deleteBorrowById(String rid,String bid);
    Borrow selectOneById(String bid,String rid);
}
