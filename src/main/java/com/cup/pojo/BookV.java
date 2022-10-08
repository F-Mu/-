package com.cup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookV {
    private String rDept;
    private int rGrade;
    private String bId;
    private String bName;
    private String bType;
}
