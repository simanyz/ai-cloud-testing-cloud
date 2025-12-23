package com.pochita.actcengine.req.common;

import lombok.Data;

/**
 * @author: Junko
 * @date: 2025/12/23 23:01
 * @Version: 1.0
 * @description:
 */
@Data
public class ProjectUpdateReq {

    private Long id;

    private String name;

    private String description;

}
