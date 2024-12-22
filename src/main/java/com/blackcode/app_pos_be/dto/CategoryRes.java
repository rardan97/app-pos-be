package com.blackcode.app_pos_be.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRes {
    public Long category_id;
    public String category_name;
}
