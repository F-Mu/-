package com.cup.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @TableId(value = "b_id")
    private String bId;
    private String bName;
    private String isbn;
    private String btId;
    private String bAuthor;
    private String bPublish;
    private String bIntr;
}
