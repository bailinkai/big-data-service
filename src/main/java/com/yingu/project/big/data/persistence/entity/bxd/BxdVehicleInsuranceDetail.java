package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_vehicle_insurance_detail")
public class BxdVehicleInsuranceDetail {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 保险单uuid
     */
    private String uuid;

    /**
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 外键
     */
    @Column(name = "details_id")
    private String detailsId;

    /**
     * 优惠比例
     */
    @Column(name = "vehicle_adjust_ratio")
    private String vehicleAdjustRatio;

    /**
     * 优惠理由
     */
    @Column(name = "vehicle_adjust_ratio_reason")
    private String vehicleAdjustRatioReason;

    /**
     * 车牌号
     */
    @Column(name = "vehicle_license_no")
    private String vehicleLicenseNo;

    /**
     * 车辆用途
     */
    @Column(name = "vehicle_car_usage")
    private String vehicleCarUsage;

    /**
     * 车辆识别码
     */
    @Column(name = "vehicle_vin_no")
    private String vehicleVinNo;

    /**
     * 载客数
     */
    @Column(name = "vehicle_passenger_capacity")
    private String vehiclePassengerCapacity;

    /**
     * 车重(顿)
     */
    @Column(name = "vehicle_weighting_capacity")
    private String vehicleWeightingCapacity;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取保险单uuid
     *
     * @return uuid - 保险单uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置保险单uuid
     *
     * @param uuid 保险单uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取订单号
     *
     * @return order_num - 订单号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单号
     *
     * @param orderNum 订单号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取外键
     *
     * @return details_id - 外键
     */
    public String getDetailsId() {
        return detailsId;
    }

    /**
     * 设置外键
     *
     * @param detailsId 外键
     */
    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    /**
     * 获取优惠比例
     *
     * @return vehicle_adjust_ratio - 优惠比例
     */
    public String getVehicleAdjustRatio() {
        return vehicleAdjustRatio;
    }

    /**
     * 设置优惠比例
     *
     * @param vehicleAdjustRatio 优惠比例
     */
    public void setVehicleAdjustRatio(String vehicleAdjustRatio) {
        this.vehicleAdjustRatio = vehicleAdjustRatio;
    }

    /**
     * 获取优惠理由
     *
     * @return vehicle_adjust_ratio_reason - 优惠理由
     */
    public String getVehicleAdjustRatioReason() {
        return vehicleAdjustRatioReason;
    }

    /**
     * 设置优惠理由
     *
     * @param vehicleAdjustRatioReason 优惠理由
     */
    public void setVehicleAdjustRatioReason(String vehicleAdjustRatioReason) {
        this.vehicleAdjustRatioReason = vehicleAdjustRatioReason;
    }

    /**
     * 获取车牌号
     *
     * @return vehicle_license_no - 车牌号
     */
    public String getVehicleLicenseNo() {
        return vehicleLicenseNo;
    }

    /**
     * 设置车牌号
     *
     * @param vehicleLicenseNo 车牌号
     */
    public void setVehicleLicenseNo(String vehicleLicenseNo) {
        this.vehicleLicenseNo = vehicleLicenseNo;
    }

    /**
     * 获取车辆用途
     *
     * @return vehicle_car_usage - 车辆用途
     */
    public String getVehicleCarUsage() {
        return vehicleCarUsage;
    }

    /**
     * 设置车辆用途
     *
     * @param vehicleCarUsage 车辆用途
     */
    public void setVehicleCarUsage(String vehicleCarUsage) {
        this.vehicleCarUsage = vehicleCarUsage;
    }

    /**
     * 获取车辆识别码
     *
     * @return vehicle_vin_no - 车辆识别码
     */
    public String getVehicleVinNo() {
        return vehicleVinNo;
    }

    /**
     * 设置车辆识别码
     *
     * @param vehicleVinNo 车辆识别码
     */
    public void setVehicleVinNo(String vehicleVinNo) {
        this.vehicleVinNo = vehicleVinNo;
    }

    /**
     * 获取载客数
     *
     * @return vehicle_passenger_capacity - 载客数
     */
    public String getVehiclePassengerCapacity() {
        return vehiclePassengerCapacity;
    }

    /**
     * 设置载客数
     *
     * @param vehiclePassengerCapacity 载客数
     */
    public void setVehiclePassengerCapacity(String vehiclePassengerCapacity) {
        this.vehiclePassengerCapacity = vehiclePassengerCapacity;
    }

    /**
     * 获取车重(顿)
     *
     * @return vehicle_weighting_capacity - 车重(顿)
     */
    public String getVehicleWeightingCapacity() {
        return vehicleWeightingCapacity;
    }

    /**
     * 设置车重(顿)
     *
     * @param vehicleWeightingCapacity 车重(顿)
     */
    public void setVehicleWeightingCapacity(String vehicleWeightingCapacity) {
        this.vehicleWeightingCapacity = vehicleWeightingCapacity;
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

    public BxdVehicleInsuranceDetail() {
    }

    public BxdVehicleInsuranceDetail(String detailsId) {
        this.detailsId = detailsId;
    }
}