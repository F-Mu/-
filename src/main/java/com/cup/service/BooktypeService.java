package com.cup.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cup.pojo.Booktype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BooktypeService {
    Booktype SelectById(String id);

    String getTypeById(String id);

    List<Booktype> selectList(@Param("ew") Wrapper<Booktype> queryWrapper);
}
