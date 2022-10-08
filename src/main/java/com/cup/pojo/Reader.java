package com.cup.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reader {
    @TableId(value = "r_id")
    private String rId;
    private String rName;
    private boolean rSex;
    private String rDept;
    private String rGrade;
}
