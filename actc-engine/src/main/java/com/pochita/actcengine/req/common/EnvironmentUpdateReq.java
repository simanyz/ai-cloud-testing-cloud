package com.pochita.actcengine.req.common;

import lombok.Data;

/**
 * @author: Junko
 * @date: 2025/12/23 23:39
 * @Version: 1.0
 * @description:
 */
@Data
public class EnvironmentUpdateReq {

    private Long id;

    private Long projectId;

    private String name;

    private String protocol;

    private String domain;

    private Integer port;

    private String description;

}
