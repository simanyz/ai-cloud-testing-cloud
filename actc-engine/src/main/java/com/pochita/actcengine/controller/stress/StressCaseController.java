package com.pochita.actcengine.controller.stress;

import com.pochita.actccommon.util.JsonData;
import com.pochita.actcengine.req.stress.StressCaseDelReq;
import com.pochita.actcengine.req.stress.StressCaseSaveReq;
import com.pochita.actcengine.req.stress.StressCaseUpdateReq;
import com.pochita.actcengine.service.stress.StressCaseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Junko,
 * @since 2025-12-24
 */
@RestController
@RequestMapping("${api.base-path}/${api.version}/stressCaseDO")
public class StressCaseController {

    @Resource
    private StressCaseService stressCaseService;

    @GetMapping("find")
    public JsonData findById(@RequestParam("projectId") Long projectId, @RequestParam("id") Long caseId) {
         return JsonData.buildSuccess(stressCaseService.findById(projectId, caseId));
    }

    @PostMapping("del")
    public JsonData delete(@RequestBody StressCaseDelReq req){
        return JsonData.buildSuccess(stressCaseService.delete(req.getProjectId(),req.getId()));
    }

    @PostMapping("save")
    public JsonData save(@RequestBody StressCaseSaveReq req){
        return JsonData.buildSuccess(stressCaseService.save(req));
    }

    @RequestMapping("update")
    public JsonData update(@RequestBody StressCaseUpdateReq req){

        return JsonData.buildSuccess(stressCaseService.update(req));
    }

    @GetMapping("excute")
    public JsonData execute(@RequestParam("projectId") Long projectId,@RequestParam("id") Long caseId){
        stressCaseService.execute(projectId, caseId);
        return JsonData.buildSuccess();
    }


}
