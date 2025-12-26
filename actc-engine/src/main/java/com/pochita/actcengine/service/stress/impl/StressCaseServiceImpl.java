package com.pochita.actcengine.service.stress.impl;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pochita.actccommon.util.SpringBeanUtil;
import com.pochita.actcengine.dto.stress.StressCaseDTO;
import com.pochita.actcengine.mapper.StressCaseMapper;
import com.pochita.actcengine.model.StressCaseDO;
import com.pochita.actcengine.req.stress.StressCaseSaveReq;
import com.pochita.actcengine.req.stress.StressCaseUpdateReq;
import com.pochita.actcengine.service.stress.StressCaseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Junko,
 * @since 2025-12-24
 */
@Service
public class StressCaseServiceImpl implements StressCaseService {

    @Resource
    private StressCaseMapper stressCaseMapper;

    @Override
    public StressCaseDTO findById(Long projectId, Long caseId) {
        LambdaQueryWrapper<StressCaseDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StressCaseDO::getId, caseId)
                .eq(StressCaseDO::getProjectId, projectId);
        StressCaseDO stressCaseDO = stressCaseMapper.selectOne(queryWrapper);
        return SpringBeanUtil.copyProperties(stressCaseDO,StressCaseDTO.class);
    }

    @Override
    public int delete(Long projectId, Long id) {
        LambdaQueryWrapper<StressCaseDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StressCaseDO::getId, id)
                .eq(StressCaseDO::getProjectId, projectId);
        return stressCaseMapper.delete(queryWrapper);
    }

    @Override
    public int save(StressCaseSaveReq req) {
        StressCaseDO stressCaseDO = SpringBeanUtil.copyProperties(req, StressCaseDO.class);
        return stressCaseMapper.insert(stressCaseDO);
    }

    @Override
    public int update(StressCaseUpdateReq req) {
        StressCaseDO stressCaseDO = SpringBeanUtil.copyProperties(req, StressCaseDO.class);
        LambdaQueryWrapper<StressCaseDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StressCaseDO::getId, stressCaseDO.getId())
                .eq(StressCaseDO::getProjectId, req.getProjectId());
        return stressCaseMapper.update(stressCaseDO, queryWrapper);
    }

    @Override
    public void execute(Long projectId, Long caseId) {

    }
}
