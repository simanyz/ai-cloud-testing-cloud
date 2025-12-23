package com.pochita.actcengine.service.common;

import com.pochita.actcengine.dto.common.ProjectDTO;
import com.pochita.actcengine.req.common.ProjectSaveReq;
import com.pochita.actcengine.req.common.ProjectUpdateReq;

import java.util.List;


/**
 * <p>
 * 项目表 服务类
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
public interface ProjectService{

    /**
     * 获取用户的项目列表
     * @return
     */
    List<ProjectDTO> list();

    /**
     * 保存项目
     * @param projectSaveReq
     * @return
     */
    int save(ProjectSaveReq projectSaveReq);

    /**
     * 更新项目
     * @param projectUpdateReq
     * @return
     */
    int update(ProjectUpdateReq projectUpdateReq);

    /**
     * 删除项目
     * @param id
     * @return
     */
    int delete(Long id);

}
