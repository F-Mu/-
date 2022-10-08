package com.cup.service;

import java.util.Date;

public interface BpenaltyService {
    float insertBpenalty(String rid, String bid, Date pre, Date now);
}
