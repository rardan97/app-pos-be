package com.blackcode.app_pos_be.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryReq {
    public Long category_id;
    public String category_name;
}
