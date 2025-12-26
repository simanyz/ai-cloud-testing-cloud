package com.pochita.actcengine.dto.stress;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: Junko
 * @date: 2025/12/24 17:29
 * @Version: 1.0
 * @description:
 */
@Data
public class StressCaseModuleDTO {

    private Long id;

    private Long projectId;

    private String name;

    private Date gmtCreate;

    private Date gmtModified;

    private List<StressCaseDTO> list;

}
