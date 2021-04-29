package com.example.model.primary;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order")
public class TOrder {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 订单数量
     */
    @Column(name = "order_qty")
    private Integer orderQty;

    /**
     * 订单日期
     */
    @Column(name = "order_date")
    private Date orderDate;

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
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取订单数量
     *
     * @return order_qty - 订单数量
     */
    public Integer getOrderQty() {
        return orderQty;
    }

    /**
     * 设置订单数量
     *
     * @param orderQty 订单数量
     */
    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * 获取订单日期
     *
     * @return order_date - 订单日期
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 设置订单日期
     *
     * @param orderDate 订单日期
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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