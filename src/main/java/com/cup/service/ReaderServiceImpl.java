package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cup.mapper.ReaderMapper;
import com.cup.pojo.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public Reader selectReaderById(String id) {
        return readerMapper.selectById(id);
    }

    @Override
    public String selectNameById(String id) {
        return readerMapper.selectById(id).getRName();
    }

    @Override
    public void updateById(Reader reader) {
        readerMapper.updateById(reader);
    }

    @Override
    public void selectPage(Page<Reader> page, Wrapper<Reader> queryWrapper) {
        readerMapper.selectPage(page, queryWrapper);
    }

    @Override
    public void insertReader(Reader reader) {
        readerMapper.insert(reader);
    }
}
