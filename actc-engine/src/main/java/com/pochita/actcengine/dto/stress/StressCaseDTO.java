package com.pochita.actcengine.dto.stress;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Junko
 * @date: 2025/12/24 17:12
 * @Version: 1.0
 * @description:
 */
@Data
public class StressCaseDTO implements Serializable {

    private Long id;

    private Long projectId;


    private Long moduleId;

    private Long environmentId;

    private String name;

    private String description;

    private String assertion;

    private String relation;

    private String stressSourceType;

    private String threadGroupConfig;

    private String jmxUrl;

    private String path;

    private String method;

    private String query;

    private String header;

    private String body;

    private String bodyType;

    private Date gmtCreate;

    private Date gmtModified;

}
