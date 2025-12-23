package com.pochita.actcengine.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
@Getter
@Setter
@ToString
@TableName("stress_case_module")
@Schema(name = "StressCaseModuleDO", description = "")
public class StressCaseModuleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属项目ID
     */
    @TableField("project_id")
    @Schema(description = "所属项目ID")
    private Long projectId;

    /**
     * 接口模块名称
     */
    @TableField("name")
    @Schema(description = "接口模块名称")
    private String name;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    @Schema(description = "创建时间")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField("gmt_modified")
    @Schema(description = "更新时间")
    private Date gmtModified;
}
