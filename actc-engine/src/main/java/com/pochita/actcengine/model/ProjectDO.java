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
 * 项目表
 * </p>
 *
 * @author Junko,
 * @since 2025-12-23
 */
@Getter
@Setter
@ToString
@TableName("project")
@Schema(name = "ProjectDO", description = "项目表")
public class ProjectDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目管理员ID
     */
    @TableField("project_admin")
    @Schema(description = "项目管理员ID")
    private Long projectAdmin;

    /**
     * 项目名称
     */
    @TableField("name")
    @Schema(description = "项目名称")
    private String name;

    /**
     * 描述
     */
    @TableField("description")
    @Schema(description = "描述")
    private String description;

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
