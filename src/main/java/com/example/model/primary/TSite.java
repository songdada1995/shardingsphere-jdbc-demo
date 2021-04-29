package com.example.model.primary;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_site")
public class TSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 站点编码
     */
    @Column(name = "site_code")
    private String siteCode;

    /**
     * 站点名称
     */
    @Column(name = "site_name")
    private String siteName;

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
     * 获取站点编码
     *
     * @return site_code - 站点编码
     */
    public String getSiteCode() {
        return siteCode;
    }

    /**
     * 设置站点编码
     *
     * @param siteCode 站点编码
     */
    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    /**
     * 获取站点名称
     *
     * @return site_name - 站点名称
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * 设置站点名称
     *
     * @param siteName 站点名称
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
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