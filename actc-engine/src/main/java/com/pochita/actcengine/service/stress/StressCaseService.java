package com.pochita.actcengine.service.stress;


import com.pochita.actcengine.dto.stress.StressCaseDTO;
import com.pochita.actcengine.req.stress.StressCaseSaveReq;
import com.pochita.actcengine.req.stress.StressCaseUpdateReq;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Junko,
 * @since 2025-12-24
 */
public interface StressCaseService  {

    StressCaseDTO findById(Long projectId, Long caseId);

    int delete(Long projectId, Long id);

    int save(StressCaseSaveReq req);

    int update(StressCaseUpdateReq req);

    void execute(Long projectId, Long caseId);

}
