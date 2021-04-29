package com.example.model.primary;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_account")
public class TAccount {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号名
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 账号简称
     */
    @Column(name = "account_code")
    private String accountCode;

    /**
     * 大区id
     */
    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 站点id
     */
    @Column(name = "site_id")
    private Integer siteId;

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
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取账号名
     *
     * @return account_name - 账号名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置账号名
     *
     * @param accountName 账号名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 获取账号简称
     *
     * @return account_code - 账号简称
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * 设置账号简称
     *
     * @param accountCode 账号简称
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /**
     * 获取大区id
     *
     * @return area_id - 大区id
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置大区id
     *
     * @param areaId 大区id
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取站点id
     *
     * @return site_id - 站点id
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     * 设置站点id
     *
     * @param siteId 站点id
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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