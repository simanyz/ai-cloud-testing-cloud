package com.pochita.actcengine.service.stress.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pochita.actccommon.util.SpringBeanUtil;
import com.pochita.actcengine.dto.stress.StressCaseDTO;
import com.pochita.actcengine.dto.stress.StressCaseModuleDTO;
import com.pochita.actcengine.mapper.StressCaseMapper;
import com.pochita.actcengine.mapper.StressCaseModuleMapper;
import com.pochita.actcengine.model.StressCaseDO;
import com.pochita.actcengine.model.StressCaseModuleDO;
import com.pochita.actcengine.req.stress.StressCaseModuleSaveReq;
import com.pochita.actcengine.req.stress.StressCaseModuleUpdateReq;
import com.pochita.actcengine.service.stress.StressCaseModuleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
@Service
public class StressCaseModuleServiceImpl  implements StressCaseModuleService {

    @Resource
    private StressCaseModuleMapper caseModuleMapper;
    @Resource
    private StressCaseMapper stressCaseMapper;

    @Override
    public List<StressCaseModuleDTO> list(Long projectId) {
        LambdaQueryWrapper<StressCaseModuleDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StressCaseModuleDO::getProjectId, projectId);
        List<StressCaseModuleDO> stressCaseModuleDOList = caseModuleMapper.selectList(queryWrapper);
        List<StressCaseModuleDTO> stressCaseModuleDTOList = SpringBeanUtil.copyProperties(stressCaseModuleDOList, StressCaseModuleDTO.class);

        LambdaQueryWrapper<StressCaseDO> caseQueryWrapper = new LambdaQueryWrapper<>();
        stressCaseModuleDTOList.forEach(source ->{
            caseQueryWrapper.clear();
            caseQueryWrapper.eq(StressCaseDO::getModuleId, source.getId());
            List<StressCaseDO> stressCaseDOList = stressCaseMapper.selectList(caseQueryWrapper);
            source.setList(SpringBeanUtil.copyProperties(stressCaseDOList, StressCaseDTO.class));
        });
        return stressCaseModuleDTOList;
    }

    @Override
    public StressCaseModuleDTO findById(Long projectId, Long moduleId) {
        LambdaQueryWrapper<StressCaseModuleDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StressCaseModuleDO::getProjectId, projectId)
                .eq(StressCaseModuleDO::getId, moduleId);
        StressCaseModuleDO stressCaseModuleDO = caseModuleMapper.selectOne(queryWrapper);
        if (stressCaseModuleDO == null) {
            return null;
        }
        StressCaseModuleDTO stressCaseModuleDTO = SpringBeanUtil.copyProperties(stressCaseModuleDO, StressCaseModuleDTO.class);
        //查询压测模型下的关联用例
        LambdaQueryWrapper<StressCaseDO> caseQueryWrapper = new LambdaQueryWrapper<>();
        caseQueryWrapper.eq(StressCaseDO::getModuleId, stressCaseModuleDTO.getId());
        List<StressCaseDO> stressCaseDOList = stressCaseMapper.selectList(caseQueryWrapper);
        List<StressCaseDTO> stressCaseDTOList = SpringBeanUtil.copyProperties(stressCaseDOList, StressCaseDTO.class);
        stressCaseModuleDTO.setList(stressCaseDTOList);
        return stressCaseModuleDTO;
    }

    @Override
    public int delete(Long projectId, Long id) {
        return 0;
    }

    @Override
    public int save(StressCaseModuleSaveReq req) {
        return 0;
    }

    @Override
    public int update(StressCaseModuleUpdateReq req) {
        return 0;
    }
}
