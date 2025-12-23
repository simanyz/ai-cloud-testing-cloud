package com.pochita.actcengine.dto.common;

import lombok.Data;

import java.util.Date;

/**
 * @author: Junko
 * @date: 2025/12/23 23:38
 * @Version: 1.0
 * @description:
 */
@Data
public class EnvironmentDTO {
    private Long id;

    private Long projectId;

    private String name;

    private String protocol;

    private String domain;

    private Integer port;

    private String description;

    private Date gmtCreate;

    private Date gmtModified;

}
