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
 * @author Junko,
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@TableName("stress_case")
@Schema(name = "StressCaseDO", description = "")
public class StressCaseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目id
     */
    @TableField("project_id")
    @Schema(description = "项目id")
    private Long projectId;

    /**
     * 所属接口模块ID
     */
    @TableField("module_id")
    @Schema(description = "所属接口模块ID")
    private Long moduleId;

    @TableField("environment_id")
    private Long environmentId;

    /**
     * 接口名称
     */
    @TableField("name")
    @Schema(description = "接口名称")
    private String name;

    /**
     * 接口描述
     */
    @TableField("description")
    @Schema(description = "接口描述")
    private String description;

    /**
     * 响应断言
     */
    @TableField("assertion")
    @Schema(description = "响应断言")
    private String assertion;

    /**
     * 可变参数
     */
    @TableField("relation")
    @Schema(description = "可变参数")
    private String relation;

    /**
     * 压测类型 [simple jmx]
     */
    @TableField("stress_source_type")
    @Schema(description = "压测类型 [simple jmx]")
    private String stressSourceType;

    /**
     * 压测参数
     */
    @Schema(description = "压测参数")
    @TableField("thread_group_config")
    private String threadGroupConfig;

    /**
     * jmx文件地址
     */
    @TableField("jmx_url")
    @Schema(description = "jmx文件地址")
    private String jmxUrl;

    /**
     * 接口路径
     */
    @TableField("path")
    @Schema(description = "接口路径")
    private String path;

    /**
     * 请求方法 [GET POST PUT PATCH DELETE HEAD OPTIONS]
     */
    @TableField("method")
    @Schema(description = "请求方法 [GET POST PUT PATCH DELETE HEAD OPTIONS]")
    private String method;

    /**
     * 查询参数
     */
    @TableField("query")
    @Schema(description = "查询参数")
    private String query;

    /**
     * 请求头
     */
    @TableField("header")
    @Schema(description = "请求头")
    private String header;

    /**
     * 请求体
     */
    @TableField("body")
    @Schema(description = "请求体")
    private String body;

    /**
     * 请求体格式 [raw form-data json]
     */
    @TableField("body_type")
    @Schema(description = "请求体格式 [raw form-data json]")
    private String bodyType;

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
