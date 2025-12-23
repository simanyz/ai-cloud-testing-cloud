package com.pochita.actcengine.dto.common;

import lombok.Data;

import java.util.Date;

/**
 * @author: Junko
 * @date: 2025/12/23 22:59
 * @Version: 1.0
 * @description:
 */
@Data
public class ProjectDTO {
    private Long id;

    private Long projectAdmin;

    private String name;

    private String description;

    private Date gmtCreate;

    private Date gmtModified;
}
