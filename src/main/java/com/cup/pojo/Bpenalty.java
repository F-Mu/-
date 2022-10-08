package com.cup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bpenalty {
    private String rId;
    private String bId;
    private int overDate;
    private float penalty;
}
