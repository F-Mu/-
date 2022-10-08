package com.cup.service;

import com.cup.mapper.BpenaltyMapper;
import com.cup.pojo.Bpenalty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BpenaltyServiceImpl implements BpenaltyService {
    @Autowired
    private BpenaltyMapper bpenaltyMapper;

    @Override
    public float insertBpenalty(String rid, String bid, Date pre, Date now) {
        int days = (int) ((now.getTime() - pre.getTime()) / (1000 * 3600 * 24));
        bpenaltyMapper.insert(new Bpenalty(rid, bid, days, (float) (days * 0.1)));
        return (float) (days * 0.1);
    }
}