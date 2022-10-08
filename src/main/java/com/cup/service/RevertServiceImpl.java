package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cup.mapper.RevertMapper;
import com.cup.pojo.Revert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RevertServiceImpl implements RevertService {
    @Autowired
    private RevertMapper revertMapper;
    @Override
    public List<Revert> selectListById(String rid) {
        QueryWrapper<Revert> wrapper = new QueryWrapper<>();
        wrapper.eq("r_id", rid);
        return revertMapper.selectList(wrapper);
    }
    @Override
    public int selectCountById(String id) {
        QueryWrapper<Revert> wrapper = new QueryWrapper<>();
        wrapper.eq("r_id", id);
        return revertMapper.selectCount(wrapper);
    }

    @Override
    public void insertRevert(String rid, String bid, Date date) {
        Revert revert = new Revert(rid, bid, date, new Date());
        revertMapper.insert(revert);
    }
}
