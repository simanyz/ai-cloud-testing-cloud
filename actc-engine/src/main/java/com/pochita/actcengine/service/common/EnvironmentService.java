package com.pochita.actcengine.service.common;


import com.pochita.actcengine.dto.common.EnvironmentDTO;
import com.pochita.actcengine.req.common.EnvironmentSaveReq;
import com.pochita.actcengine.req.common.EnvironmentUpdateReq;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
public interface EnvironmentService  {


    List<EnvironmentDTO> list(Long projectId);

    int save(EnvironmentSaveReq req);

    int update(EnvironmentUpdateReq req);

    int delete(Long projectId, Long id);

}
