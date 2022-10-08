package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cup.mapper.BooktypeMapper;
import com.cup.pojo.Booktype;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooktypeServiceImpl implements BooktypeService {
    @Autowired
    private BooktypeMapper booktypeMapper;

    @Override
    public Booktype SelectById(String id) {
        return booktypeMapper.selectById(id);
    }

    @Override
    public String getTypeById(String id) {
        return booktypeMapper.selectById(id).getBtName();
    }

    @Override
    public List<Booktype> selectList(Wrapper<Booktype> queryWrapper) {
        return booktypeMapper.selectList(queryWrapper);
    }
}
