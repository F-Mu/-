package com.cup.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Revert {
    @TableId(value = "r_id")
    private String rId;
    private String bId;
    private Date borrowDate;
    private Date revertDate;
}
