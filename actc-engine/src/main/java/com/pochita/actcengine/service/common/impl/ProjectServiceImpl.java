package com.pochita.actcengine.service.common.impl;

import com.pochita.actccommon.util.SpringBeanUtil;
import com.pochita.actcengine.dto.common.ProjectDTO;
import com.pochita.actcengine.mapper.ProjectMapper;
import com.pochita.actcengine.model.ProjectDO;
import com.pochita.actcengine.req.common.ProjectSaveReq;
import com.pochita.actcengine.req.common.ProjectUpdateReq;
import com.pochita.actcengine.service.common.ProjectService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
@Service
@Slf4j
public class ProjectServiceImpl  implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectDTO> list() {
        List<ProjectDO> projectDOList = projectMapper.selectList(null);
        return SpringBeanUtil.copyProperties(projectDOList, ProjectDTO.class);
    }

    @Override
    public int save(ProjectSaveReq projectSaveReq) {
        ProjectDO projectDO = SpringBeanUtil.copyProperties(projectSaveReq, ProjectDO.class);
        return projectMapper.insert(projectDO);
    }

    @Override
    public int update(ProjectUpdateReq projectUpdateReq) {
        ProjectDO projectDO = SpringBeanUtil.copyProperties(projectUpdateReq, ProjectDO.class);
        return projectMapper.updateById(projectDO);
    }

    @Override
    public int delete(Long id) {
        projectMapper.deleteById(id);
        return 0;
    }
}
