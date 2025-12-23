package com.pochita.actcengine.service.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pochita.actccommon.util.SpringBeanUtil;
import com.pochita.actcengine.dto.common.EnvironmentDTO;
import com.pochita.actcengine.mapper.EnvironmentMapper;
import com.pochita.actcengine.mapper.ProjectMapper;
import com.pochita.actcengine.model.EnvironmentDO;
import com.pochita.actcengine.model.ProjectDO;
import com.pochita.actcengine.req.common.EnvironmentSaveReq;
import com.pochita.actcengine.req.common.EnvironmentUpdateReq;
import com.pochita.actcengine.service.common.EnvironmentService;
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
public class EnvironmentServiceImpl  implements EnvironmentService {

    @Resource
    private EnvironmentMapper environmentMapper;
    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<EnvironmentDTO> list(Long projectId) {
        LambdaQueryWrapper<EnvironmentDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EnvironmentDO::getProjectId, projectId);
        List<EnvironmentDO> environmentDOList = environmentMapper.selectList(queryWrapper);
        return SpringBeanUtil.copyProperties(environmentDOList, EnvironmentDTO.class);
    }

    @Override
    public int save(EnvironmentSaveReq req) {
        ProjectDO projectDO = projectMapper.selectById(req.getProjectId());
        if (projectDO != null){
            EnvironmentDO environmentDO = SpringBeanUtil.copyProperties(req, EnvironmentDO.class);
            return environmentMapper.insert(environmentDO);
        }
        return 0;
    }

    @Override
    public int update(EnvironmentUpdateReq req) {
        ProjectDO projectDO = projectMapper.selectById(req.getProjectId());
        if (projectDO != null){
            EnvironmentDO environmentDO = SpringBeanUtil.copyProperties(req, EnvironmentDO.class);
            return environmentMapper.updateById(environmentDO);
        }
        return 0;
    }

    @Override
    public int delete(Long projectId, Long id) {
        LambdaQueryWrapper<EnvironmentDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EnvironmentDO::getProjectId, projectId).eq(EnvironmentDO::getId, id);
        return environmentMapper.delete(queryWrapper);

    }
}
