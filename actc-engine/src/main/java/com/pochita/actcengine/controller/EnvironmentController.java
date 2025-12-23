package com.pochita.actcengine.controller;

import com.pochita.actccommon.util.JsonData;
import com.pochita.actcengine.req.common.EnvironmentDelReq;
import com.pochita.actcengine.req.common.EnvironmentSaveReq;
import com.pochita.actcengine.req.common.EnvironmentUpdateReq;
import com.pochita.actcengine.service.common.EnvironmentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
@RestController
@RequestMapping("${api.base-path}/${api.version}/env")
public class EnvironmentController {

    @Resource
    private EnvironmentService environmentService;

    @GetMapping("/list")
    public JsonData list(@RequestParam("projectId")Long projectId){
        return JsonData.buildSuccess(environmentService.list(projectId));
    }


    @PostMapping("/save")
    public JsonData save(@RequestBody EnvironmentSaveReq req){
        return JsonData.buildSuccess(environmentService.save(req));
    }


    @PostMapping("/update")
    public JsonData update(@RequestBody EnvironmentUpdateReq req){
        return JsonData.buildSuccess(environmentService.update(req));
    }

    @PostMapping("/del")
    public JsonData delete(@RequestBody EnvironmentDelReq req){
        return JsonData.buildSuccess(environmentService.delete(req.getProjectId(),req.getId()));
    }

}
