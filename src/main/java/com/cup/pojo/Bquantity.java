package com.cup.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bquantity {
    @TableId(value = "b_id")
    private String bId;
    private Integer bNum;
    private Integer bRemain;
}
