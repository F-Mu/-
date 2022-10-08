package com.cup.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Alogin {
    @TableId(value = "admin_id")
    private String adminId;
    private String adminPassword;
}
