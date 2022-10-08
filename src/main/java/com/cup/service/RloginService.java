package com.cup.service;

import com.cup.pojo.Rlogin;

public interface RloginService {
    String selectPasswordById(String id);
    void updateRlogin(Rlogin rlogin);
    void insertRlogin(Rlogin rlogin);
}
