package com.cup.service;

import com.cup.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public String selectNameById(String id) {
        return adminMapper.selectById(id).getAdminName();
    }
}
