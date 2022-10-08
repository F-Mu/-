package com.cup.service;

import com.cup.pojo.Revert;

import java.util.Date;
import java.util.List;

public interface RevertService {
    List<Revert> selectListById(String rid);
    int selectCountById(String id);
    void insertRevert(String rid, String bid, Date date);
}
