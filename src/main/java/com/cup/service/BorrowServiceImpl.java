package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cup.mapper.BorrowMapper;
import com.cup.pojo.Book;
import com.cup.pojo.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public List<Borrow> selectListById(String rid) {
        QueryWrapper<Borrow> wrapper = new QueryWrapper<>();
        wrapper.eq("r_id", rid);
        return borrowMapper.selectList(wrapper);
    }

    @Override
    public void selectPage(Page<Borrow> page, Wrapper<Borrow> queryWrapper) {
        borrowMapper.selectPage(page, queryWrapper);
    }

    @Override
    public int selectCountById(String id) {
        QueryWrapper<Borrow> wrapper = new QueryWrapper<>();
        wrapper.eq("r_id", id);
        return borrowMapper.selectCount(wrapper);
    }

    @Override
    public void insertBorrow(String rid, String bid, Date now, Date last) {
        Borrow borrow = new Borrow(rid, bid, now, last);
        borrowMapper.insert(borrow);
    }

    @Override
    public void deleteBorrowById(String rid, String bid) {
        QueryWrapper<Borrow> wrapper = new QueryWrapper<>();
        wrapper.eq("r_id", rid);
        wrapper.eq("b_id", bid);
        borrowMapper.delete(wrapper);
    }

    @Override
    public Borrow selectOneById(String bid, String rid) {
        QueryWrapper<Borrow> wrapper = new QueryWrapper<>();
        wrapper.eq("r_id", rid);
        wrapper.eq("b_id", bid);
        return borrowMapper.selectOne(wrapper);
    }

}
