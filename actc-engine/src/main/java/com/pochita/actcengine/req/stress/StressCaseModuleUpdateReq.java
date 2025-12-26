package com.pochita.actcengine.req.stress;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Junko
 * @date: 2025/12/24 17:16
 * @Version: 1.0
 * @description:
 */
@Data
public class StressCaseModuleUpdateReq implements Serializable {
    private Long id;

    private Long projectId;

    private String name;


}
