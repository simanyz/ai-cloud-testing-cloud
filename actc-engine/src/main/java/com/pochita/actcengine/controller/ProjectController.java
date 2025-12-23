package com.pochita.actcengine.controller;

import com.pochita.actccommon.util.JsonData;
import com.pochita.actcengine.req.common.ProjectSaveReq;
import com.pochita.actcengine.req.common.ProjectUpdateReq;
import com.pochita.actcengine.service.common.ProjectService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 项目表 前端控制器
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
@RequestMapping("${api.base-path}/${api.version}/project")
@RestController
public class ProjectController {

    @Resource
    private ProjectService  projectService;

    @GetMapping("/list")
    public JsonData list(){
        return JsonData.buildSuccess(projectService.list());
    }

    @PostMapping("save")
    public JsonData save(@RequestBody ProjectSaveReq projectSaveReq){
        return JsonData.buildSuccess(projectService.save(projectSaveReq));
    }

    @PostMapping("update")
    public JsonData update(@RequestBody ProjectUpdateReq projectUpdateReq){
        return JsonData.buildSuccess(projectService.update(projectUpdateReq));
    }

    @PostMapping("del")
    public JsonData del(@RequestBody Long id){
        return JsonData.buildSuccess(projectService.delete(id));
    }

}
