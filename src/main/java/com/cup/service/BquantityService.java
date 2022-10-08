package com.cup.service;

import com.cup.pojo.Book;
import com.cup.pojo.Bquantity;

public interface BquantityService {
    int getNumById(String id);
    int getRemainById(String id);
    void updateRemainById(String id, int num);
    void insertQuantity(Book book, int num);
    Bquantity getQuantityById(String id);
    void addBookById(String id,int num);
}
