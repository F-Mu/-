package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cup.mapper.AloginMapper;
import com.cup.pojo.Alogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AloginServiceImpl implements AloginService {
    @Autowired
    private AloginMapper aloginMapper;

    @Override
    public String selectPasswordById(String id) {
        QueryWrapper<Alogin> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_id", id);
        Alogin alogin = aloginMapper.selectOne(wrapper);
        return alogin == null ? null : alogin.getAdminPassword();
    }
}
