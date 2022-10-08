package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cup.mapper.RloginMapper;
import com.cup.pojo.Alogin;
import com.cup.pojo.Rlogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RloginServiceImpl implements RloginService {
    @Autowired
    private RloginMapper rloginMapper;

    @Override
    public String selectPasswordById(String id) {
        QueryWrapper<Rlogin> wrapper = new QueryWrapper<>();
        wrapper.eq("r_id", id);
        Rlogin rlogin = rloginMapper.selectOne(wrapper);
        return rlogin == null ? null : rlogin.getRPassword();
    }

    @Override
    public void updateRlogin(Rlogin rlogin) {
        rloginMapper.updateById(rlogin);
    }

    @Override
    public void insertRlogin(Rlogin rlogin) {
        rloginMapper.insert(rlogin);
    }
}
