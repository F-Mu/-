package com.cup.service;

import com.cup.mapper.BquantityMapper;
import com.cup.pojo.Book;
import com.cup.pojo.Bquantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BquantityServiceImpl implements BquantityService {
    @Autowired
    private BquantityMapper bquantityMapper;

    @Override
    public int getNumById(String id) {
        return bquantityMapper.selectById(id).getBNum();
    }

    @Override
    public int getRemainById(String id) {
        return bquantityMapper.selectById(id).getBRemain();
    }

    @Override
    public void updateRemainById(String id, int num) {
        Bquantity now = getQuantityById(id);
        now.setBRemain(now.getBRemain() + num);
        bquantityMapper.updateById(now);
    }

    @Override
    public void insertQuantity(Book book, int num) {
        bquantityMapper.insert(new Bquantity(book.getBId(), num, num));
    }

    @Override
    public Bquantity getQuantityById(String id) {
        return bquantityMapper.selectById(id);
    }

    @Override
    public void addBookById(String id, int num) {
        Bquantity now = getQuantityById(id);
        now.setBNum(now.getBNum() + num);
        now.setBRemain(now.getBRemain() + num);
        bquantityMapper.updateById(now);
    }
}
