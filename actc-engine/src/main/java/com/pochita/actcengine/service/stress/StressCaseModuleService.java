package com.pochita.actcengine.service.stress;


import com.pochita.actcengine.dto.stress.StressCaseModuleDTO;
import com.pochita.actcengine.req.stress.StressCaseModuleSaveReq;
import com.pochita.actcengine.req.stress.StressCaseModuleUpdateReq;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
public interface StressCaseModuleService  {

    List<StressCaseModuleDTO> list(Long projectId);

    StressCaseModuleDTO findById(Long projectId, Long moduleId);

    int delete(Long projectId, Long id);

    int save(StressCaseModuleSaveReq req);

    int update(StressCaseModuleUpdateReq req);

}
