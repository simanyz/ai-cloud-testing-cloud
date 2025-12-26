package com.pochita.actcengine.controller.stress;

import com.pochita.actccommon.util.JsonData;
import com.pochita.actcengine.req.stress.StressCaseModuleDelReq;
import com.pochita.actcengine.req.stress.StressCaseModuleSaveReq;
import com.pochita.actcengine.req.stress.StressCaseModuleUpdateReq;
import com.pochita.actcengine.service.stress.StressCaseModuleService;
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
@Controller
@RequestMapping("${api.base-path}/${api.version}/stressCaseModuleDO")
public class StressCaseModuleController {

    @Resource
    private StressCaseModuleService stressCaseModuleService;

    @GetMapping("list")
    public JsonData list(@RequestParam("projectId")Long projectId){
        return JsonData.buildSuccess(stressCaseModuleService.list(projectId));
    }

    @GetMapping("find")
    public JsonData findById(@RequestParam("projectId") Long projectId, @RequestParam("moduleId") Long moduleId){
        return JsonData.buildSuccess(stressCaseModuleService.findById(projectId,moduleId));
    }


    @PostMapping("/del")
    public JsonData delete(@RequestBody StressCaseModuleDelReq req){
        return JsonData.buildSuccess(stressCaseModuleService.delete(req.getProjectId(),req.getId()));
    }
    @PostMapping("/save")
    public JsonData save(@RequestBody StressCaseModuleSaveReq req){
        return JsonData.buildSuccess(stressCaseModuleService.save(req));
    }

    @PostMapping("/update")
    public JsonData update(@RequestBody StressCaseModuleUpdateReq req){
        return JsonData.buildSuccess(stressCaseModuleService.update(req));
    }

}
