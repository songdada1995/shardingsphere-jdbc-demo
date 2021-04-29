package com.example.model.primary;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_area")
public class TArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 大区编码
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 大区名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建人id
     */
    @Column(name = "create_by_user_id")
    private Integer createByUserId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取大区编码
     *
     * @return area_code - 大区编码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置大区编码
     *
     * @param areaCode 大区编码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取大区名称
     *
     * @return area_name - 大区名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置大区名称
     *
     * @param areaName 大区名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建人id
     *
     * @return create_by_user_id - 创建人id
     */
    public Integer getCreateByUserId() {
        return createByUserId;
    }

    /**
     * 设置创建人id
     *
     * @param createByUserId 创建人id
     */
    public void setCreateByUserId(Integer createByUserId) {
        this.createByUserId = createByUserId;
    }
}