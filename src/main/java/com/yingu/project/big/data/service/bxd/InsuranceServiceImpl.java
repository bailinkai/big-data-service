package com.yingu.project.big.data.service.bxd;

import com.yingu.project.big.data.common.ResponseCode;
import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.persistence.entity.bxd.*;
import com.yingu.project.big.data.persistence.entity.pc.PcCustomerBaseInfo;
import com.yingu.project.big.data.persistence.mapper.bxd.*;
import com.yingu.project.big.data.persistence.mapper.pc.PcCustomerBaseInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
@Slf4j
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    BxdBaseInfoMapper bxdBaseInfoMapper;
    @Autowired
    BxdDetailMapper bxdDetailMapper;
    @Autowired
    BxdInsurantDetailMapper bxdInsurantDetailMapper;
    @Autowired
    BxdApplicantDetailMapper bxdApplicantDetailMapper;
    @Autowired
    BxdBeneficiaryMapper bxdBeneficiaryMapper;
    @Autowired
    BxdPaymentDetailMapper bxdPaymentDetailMapper;
    @Autowired
    BxdInsuranceKindMapper bxdInsuranceKindMapper;
    @Autowired
    BxdVehicleInsuranceDetailMapper bxdVehicleInsuranceDetailMapper;
    @Autowired
    PcCustomerBaseInfoMapper pcCustomerBaseInfoMapper;
    @Autowired
    BxdSunshineUserInfoMapper bxdSunshineUserInfoMapper;
    @Autowired
    BxdSunshinePolicyInfoListMapper bxdSunshinePolicyInfoListMapper;
    @Autowired
    BxdSunshineBeneficiaryListMapper bxdSunshineBeneficiaryListMapper;
    @Autowired
    BxdSunshineInsurantListMapper bxdSunshineInsurantListMapper;
    @Autowired
    BxdSunshinePaymentInfoMapper bxdSunshinePaymentInfoMapper;
    @Autowired
    BxdSunshineApplicantMapper bxdSunshineApplicantMapper;

    @Override
    public boolean saveInfo(String orderNum, String stringData) {
        return false;
    }

    @Override
    public ResponseResult getBXDInfo(String orderNum) {
        return null;
    }

    @Override
    public ResponseResult getAllInfo(String orderNum) {
        Map<String, Object> dataMap = new HashMap<>();
        List<Map<String, Object>> applicant_info = new ArrayList<>();
        List<Map<String, Object>> warranty_base_info = new ArrayList<>();
        List<Map<String, Object>> warranty_details = new ArrayList<>();
        List<Map<String, Object>> payment_info = new ArrayList<>();
        List<Map<String, Object>> other_info = new ArrayList<>();
        try {
            //查询该订单编号的所有保险单List集合

            List<BxdBaseInfo> bxdBase = bxdBaseInfoMapper.select(new BxdBaseInfo(orderNum));
            List<BxdSunshinePolicyInfoList> bxdBases = bxdSunshinePolicyInfoListMapper.select(new BxdSunshinePolicyInfoList(orderNum));
            if (bxdBase.size() <= 0 && bxdBases.size() <= 0) {
                return new ResponseResult(ResponseCode.BXDDATANOTUSER.getCode(), ResponseCode.BXDDATANOTUSER.getDescription());
            }
            if (bxdBase.size() > 0) {
                for (BxdBaseInfo bxdBI : bxdBase) {
                    //拿到details外键
                    String telephone = bxdBI.getTelephone() == null ? "" : bxdBI.getTelephone();
                    String company_school = bxdBI.getCompanySchool() == null ? "" : bxdBI.getCompanySchool();
                    String company = bxdBI.getCompany() == null ? "" : bxdBI.getCompany();
                    String details = bxdBI.getDetailsId() == null ? "" : bxdBI.getDetailsId();
                    String name = bxdBI.getName() == null ? "" : bxdBI.getName();

                    //根据details外键查询对应的所有的details对象
                    List<BxdDetail> bxdDetails = bxdDetailMapper.select(new BxdDetail(details));
                    if (bxdDetails.size() > 0) {
                        for (BxdDetail bxdDetail : bxdDetails) {
                            //遍历拿到其中一个对象
                            Map<String, Object> detailMap = new HashMap<>();
                            detailMap.put("insurance_id", bxdDetail.getInsuranceId() == null ? "" : bxdDetail.getInsuranceId());
                            detailMap.put("company", company == null ? "" : company);
                            detailMap.put("name", name == null ? "" : name);
                            detailMap.put("insurance_name", bxdDetail.getInsuranceName() == null ? "" : bxdDetail.getInsuranceName());
                            detailMap.put("insurance_type", bxdDetail.getInsuranceType() == null ? "" : bxdDetail.getInsuranceType());
                            detailMap.put("insurance_main", bxdDetail.getInsuranceMain() == null ? "" : bxdDetail.getInsuranceMain());
                            detailMap.put("insurance_num", bxdDetail.getInsuranceNum() == null ? "" : bxdDetail.getInsuranceNum());

                            warranty_base_info.add(detailMap);
                            //拿到对应的里面的list对应的外键
                            String detailsIdTwo = bxdDetail.getDetailsIdTwo();

                            List<BxdApplicantDetail> applicantDetailList = bxdApplicantDetailMapper.select(new BxdApplicantDetail(detailsIdTwo));
                            List<PcCustomerBaseInfo> customerBaseInfos = pcCustomerBaseInfoMapper.select(new PcCustomerBaseInfo(orderNum));
                            String phone = "";
                            if (customerBaseInfos.size() > 0) {

                                for (PcCustomerBaseInfo pcCustomerBaseInfo : customerBaseInfos) {
                                    phone = pcCustomerBaseInfo.getPhone() == null ? "" : pcCustomerBaseInfo.getPhone();
                                }
                            }
                            if (applicantDetailList.size() > 0) {
                                for (BxdApplicantDetail bxdApplicantDetail : applicantDetailList) {
                                    Map<String, Object> bxdApplicantMap = new HashMap<>();
                                    bxdApplicantMap.put("applicant_name", bxdApplicantDetail.getApplicantName() == null ? "" : bxdApplicantDetail.getApplicantName());
                                    bxdApplicantMap.put("applicant_id_card_num", bxdApplicantDetail.getApplicantIdCardNum() == null ? "" : bxdApplicantDetail.getApplicantIdCardNum());
                                    bxdApplicantMap.put("applicant_cell_phone", bxdApplicantDetail.getApplicantCellPhone() == null ? "" : bxdApplicantDetail.getApplicantCellPhone());
                                    bxdApplicantMap.put("applicant_profession", bxdApplicantDetail.getApplicantProfession() == null ? "" : bxdApplicantDetail.getApplicantProfession());
                                    bxdApplicantMap.put("applicant_address", bxdApplicantDetail.getApplicantAddress() == null ? "" : bxdApplicantDetail.getApplicantAddress());

                                    bxdApplicantMap.put("applicant_email", bxdApplicantDetail.getApplicantEmail() == null ? "" : bxdApplicantDetail.getApplicantEmail());
                                    bxdApplicantMap.put("wxid", bxdBI.getWxid() == null ? "" : bxdBI.getWxid());

                                    bxdApplicantMap.put("telephone", telephone);
                                    bxdApplicantMap.put("warning", false);
                                    bxdApplicantMap.put("company_school", company_school);


                                    applicant_info.add(bxdApplicantMap);
                                }

                            }

                            List<BxdInsuranceKind> bxdInsuranceKinds = bxdInsuranceKindMapper.select(new BxdInsuranceKind(detailsIdTwo));
                            if (bxdInsuranceKinds.size() > 0) {
                                for (BxdInsuranceKind bxdInsuranceKind : bxdInsuranceKinds) {
                                    Map<String, Object> insuranceKindMap = new HashMap<>();
                                    insuranceKindMap.put("insurance_kind_insurance_name", bxdInsuranceKind.getInsuranceKindInsuranceName() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceName());
                                    insuranceKindMap.put("insurance_kind_insurance_type", bxdInsuranceKind.getInsuranceKindInsuranceType() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceType());
                                    insuranceKindMap.put("insurance_kind_insured_amount", bxdInsuranceKind.getInsuranceKindInsuredAmount() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuredAmount());
                                    insuranceKindMap.put("insurance_kind_insurance_period", bxdInsuranceKind.getInsuranceKindInsurancePeriod() == null ? "" : bxdInsuranceKind.getInsuranceKindInsurancePeriod());
                                    insuranceKindMap.put("insurance_kind_insurance_premium", bxdInsuranceKind.getInsuranceKindInsurancePremium() == null ? "" : bxdInsuranceKind.getInsuranceKindInsurancePremium());
                                    insuranceKindMap.put("insurance_kind_insurance_status", bxdInsuranceKind.getInsuranceKindInsuranceStatus() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceStatus());

                                    warranty_details.add(insuranceKindMap);
                                }
                            }

                            List<BxdPaymentDetail> paymentDetails = bxdPaymentDetailMapper.orderBy(detailsIdTwo);
                            if (paymentDetails.size() > 0) {
                                for (BxdPaymentDetail bxdPaymentDetail : paymentDetails) {
                                    Map<String, Object> paymentDetailMap = new HashMap<>();
                                    paymentDetailMap.put("insurance_amt", bxdPaymentDetail.getInsuranceAmt() == null ? "" : bxdPaymentDetail.getInsuranceAmt());
                                    paymentDetailMap.put("start_date", bxdPaymentDetail.getStartDate() == null ? "" : bxdPaymentDetail.getStartDate());
                                    paymentDetailMap.put("pay_end_date", bxdPaymentDetail.getPayEndDate() == null ? "" : bxdPaymentDetail.getPayEndDate());
                                    paymentDetailMap.put("pay_amt", bxdPaymentDetail.getPayAmt() == null ? "" : bxdPaymentDetail.getPayAmt());
                                    paymentDetailMap.put("pay_had_times", bxdPaymentDetail.getPayHadTimes() == null ? "" : bxdPaymentDetail.getPayHadTimes());
                                    paymentDetailMap.put("pay_period", bxdPaymentDetail.getPayPeriod() == null ? "" : bxdPaymentDetail.getPayPeriod());
                                    paymentDetailMap.put("payment_frequency", bxdPaymentDetail.getPaymentFrequency() == null ? "" : bxdPaymentDetail.getPaymentFrequency());
                                    paymentDetailMap.put("payment_type", bxdPaymentDetail.getPaymentType() == null ? "" : bxdPaymentDetail.getPaymentType());
                                    paymentDetailMap.put("warning", false);

                                    paymentDetailMap.put("next_pay_date", bxdPaymentDetail.getNextPayDate() == null ? "" : bxdPaymentDetail.getNextPayDate());
                                    paymentDetailMap.put("policy_start_date", bxdPaymentDetail.getPolicyStartDate() == null ? "" : bxdPaymentDetail.getPolicyStartDate());
                                    paymentDetailMap.put("end_date", bxdPaymentDetail.getEndDate() == null ? "" : bxdPaymentDetail.getEndDate());
                                    paymentDetailMap.put("pay_need_times", bxdPaymentDetail.getPayNeedTimes() == null ? "" : bxdPaymentDetail.getPayNeedTimes());
                                    paymentDetailMap.put("insurance_premium", bxdPaymentDetail.getInsurancePremium() == null ? "" : bxdPaymentDetail.getInsurancePremium());
                                    paymentDetailMap.put("payment_premium_payable", bxdPaymentDetail.getPaymentPremiumPayable() == null ? "" : bxdPaymentDetail.getPaymentPremiumPayable());
                                    paymentDetailMap.put("payment_premium_charge", bxdPaymentDetail.getPaymentPremiumCharge() == null ? "" : bxdPaymentDetail.getPaymentPremiumCharge());


                                    payment_info.add(paymentDetailMap);
                                }
                            }

                            List<BxdInsurantDetail> insurantDetails = bxdInsurantDetailMapper.select(new BxdInsurantDetail(detailsIdTwo));
                            List<BxdBeneficiary> beneficiaries = bxdBeneficiaryMapper.select(new BxdBeneficiary(detailsIdTwo));
                            List<BxdVehicleInsuranceDetail> vehicleInsuranceDetails = bxdVehicleInsuranceDetailMapper.select(new BxdVehicleInsuranceDetail(detailsIdTwo));
                            if (insurantDetails.size() > 0) {
                                for (BxdInsurantDetail bxdInsurantDetail : insurantDetails) {
                                    Map<String, Object> InsurantDetailMap = new HashMap<>();
                                    InsurantDetailMap.put("insurant_id_card_num", bxdInsurantDetail.getInsurantIdCardNum() == null ? "" : bxdInsurantDetail.getInsurantIdCardNum());
                                    InsurantDetailMap.put("insurant_relationship", bxdInsurantDetail.getInsurantRelationship() == null ? "" : bxdInsurantDetail.getInsurantRelationship());
                                    InsurantDetailMap.put("insurant_name", bxdInsurantDetail.getInsurantName() == null ? "" : bxdInsurantDetail.getInsurantName());
                                    InsurantDetailMap.put("beneficiary_name", "");
                                    InsurantDetailMap.put("beneficiary_relationship", "");
                                    InsurantDetailMap.put("auto_insurance", "无");
                                    if (vehicleInsuranceDetails.size() > 0) {
                                        InsurantDetailMap.put("auto_insurance", "有");
                                    }
                                    if (beneficiaries.size() > 0) {
                                        for (BxdBeneficiary bxdBeneficiary : beneficiaries) {
                                            InsurantDetailMap.put("beneficiary_relationship", bxdBeneficiary.getBeneficiaryRelationship() == null ? "" : bxdBeneficiary.getBeneficiaryRelationship());
                                            InsurantDetailMap.put("beneficiary_name", bxdBeneficiary.getBeneficiaryName() == null ? "" : bxdBeneficiary.getBeneficiaryName());
                                            other_info.add(InsurantDetailMap);
                                        }
                                    } else {
                                        other_info.add(InsurantDetailMap);
                                    }
                                }
                            }
                        }

                    }
                }

            } else if (bxdBases.size() > 0) {
                String name = "";
                String profession = "";
                String city = "";
                String marital_status = "";
                //拿到user的相关信息
                List<BxdSunshineUserInfo> userInfos = bxdSunshineUserInfoMapper.select(new BxdSunshineUserInfo(orderNum));
                if (userInfos.size() > 0) {
                    for (BxdSunshineUserInfo bxdSunshineUserInfo : userInfos) {
                        profession = bxdSunshineUserInfo.getProfession() == null ? "" : bxdSunshineUserInfo.getProfession();
                        city = bxdSunshineUserInfo.getCity() == null ? "" : bxdSunshineUserInfo.getCity();
                        name = bxdSunshineUserInfo.getUsername() == null ? "" : bxdSunshineUserInfo.getUsername();
                        marital_status = bxdSunshineUserInfo.getMaritalStatus() == null ? "" : bxdSunshineUserInfo.getMaritalStatus();
                    }
                }
                //投保人信息
                List<BxdSunshineApplicant> applicantLists = bxdSunshineApplicantMapper.select(new BxdSunshineApplicant(orderNum));
                if (applicantLists.size() > 0) {
                    for (BxdSunshineApplicant bxdSunshineApplicant : applicantLists) {
                        Map<String, Object> bxdApplicantMap = new HashMap<>();
                        bxdApplicantMap.put("applicant_name", bxdSunshineApplicant.getName() == null ? "" : bxdSunshineApplicant.getName());
                        bxdApplicantMap.put("applicant_id_card_num", bxdSunshineApplicant.getIdCardNo() == null ? "" : bxdSunshineApplicant.getIdCardNo());
                        bxdApplicantMap.put("applicant_cell_phone", bxdSunshineApplicant.getPhoneNo() == null ? "" : bxdSunshineApplicant.getPhoneNo());
                        bxdApplicantMap.put("applicant_profession", profession);
                        bxdApplicantMap.put("applicant_address", bxdSunshineApplicant.getAddress() == null ? "" : bxdSunshineApplicant.getAddress());
                        bxdApplicantMap.put("warning", false);
                        bxdApplicantMap.put("company_school", bxdSunshineApplicant.getCompany() == null ? "" : bxdSunshineApplicant.getCompany());

                        applicant_info.add(bxdApplicantMap);
                    }
                }

                //保单信息 warranty_base_info
                List<BxdSunshinePolicyInfoList> BxdSunshinePolicyInfoList = bxdSunshinePolicyInfoListMapper.select(new BxdSunshinePolicyInfoList(orderNum));
                if (BxdSunshinePolicyInfoList.size() > 0) {
                    for (BxdSunshinePolicyInfoList bxdSunshinePolicyInfoList : BxdSunshinePolicyInfoList) {
                        //遍历拿到其中一个对象
                        Map<String, Object> detailMap = new HashMap<>();
                        detailMap.put("insurance_id", bxdSunshinePolicyInfoList.getPolicyNo() == null ? "" : bxdSunshinePolicyInfoList.getPolicyNo());
                        detailMap.put("company", bxdSunshinePolicyInfoList.getCompany() == null ? "" : bxdSunshinePolicyInfoList.getCompany() == null);
                        detailMap.put("name", name);
                        detailMap.put("insurance_name", "");
                        detailMap.put("insurance_type", bxdSunshinePolicyInfoList.getType() == null ? "" : bxdSunshinePolicyInfoList.getType());
                        detailMap.put("insurance_main", bxdSunshinePolicyInfoList.getMainInsurance() == null ? "" : bxdSunshinePolicyInfoList.getMainInsurance());
                        detailMap.put("insurance_num", bxdSunshinePolicyInfoList.getQuantity() == null ? "" : bxdSunshinePolicyInfoList.getQuantity());

                        warranty_base_info.add(detailMap);
                    }

                    for (BxdSunshinePolicyInfoList bxdSunshinePolicyInfoList : BxdSunshinePolicyInfoList) {
                        Map<String, Object> insuranceKindMap = new HashMap<>();
                        //遍历拿到其中一个对象
                        insuranceKindMap.put("insurance_kind_insurance_name", bxdSunshinePolicyInfoList.getMainInsurance() == null ? "" : bxdSunshinePolicyInfoList.getMainInsurance());
                        insuranceKindMap.put("insurance_kind_insurance_type", bxdSunshinePolicyInfoList.getType() == null ? "" : bxdSunshinePolicyInfoList.getType());
                        insuranceKindMap.put("insurance_kind_insured_amount", bxdSunshinePolicyInfoList.getAmount() == null ? "" : bxdSunshinePolicyInfoList.getAmount());
                        insuranceKindMap.put("insurance_kind_insurance_premium", "");
                        insuranceKindMap.put("insurance_kind_insurance_status", bxdSunshinePolicyInfoList.getStatus() == null ? "" : bxdSunshinePolicyInfoList.getStatus());
                        insuranceKindMap.put("insurance_kind_insurance_period", bxdSunshinePolicyInfoList.getPeriod() == null ? "" : bxdSunshinePolicyInfoList.getPeriod());

                        warranty_details.add(insuranceKindMap);
                    }
                }

                //查询所有的paymentInfo信息
                BxdSunshinePaymentInfo bxdSunshine = new BxdSunshinePaymentInfo();
                bxdSunshine.setOrderNum(orderNum);
                List<BxdSunshinePaymentInfo> paymentInfos = bxdSunshinePaymentInfoMapper.orderBy(bxdSunshine);
                if (paymentInfos.size() > 0) {
                    for (BxdSunshinePaymentInfo bxdSunshinePaymentInfo : paymentInfos) {
                        Map<String, Object> paymentDetailMap = new HashMap<>();
                        paymentDetailMap.put("insurance_amt", bxdSunshinePaymentInfo.getTotalPremium() == null ? "" : bxdSunshinePaymentInfo.getTotalPremium());
                        paymentDetailMap.put("start_date", bxdSunshinePaymentInfo.getStartDate() == null ? "" : bxdSunshinePaymentInfo.getStartDate());
                        paymentDetailMap.put("pay_end_date", bxdSunshinePaymentInfo.getEndDate() == null ? "" : bxdSunshinePaymentInfo.getEndDate());
                        paymentDetailMap.put("pay_amt", bxdSunshinePaymentInfo.getPeriodAmount() == null ? "" : bxdSunshinePaymentInfo.getPeriodAmount());
                        paymentDetailMap.put("pay_had_times", bxdSunshinePaymentInfo.getPaidCount() == null ? "" : bxdSunshinePaymentInfo.getPaidCount());
                        paymentDetailMap.put("pay_period", bxdSunshinePaymentInfo.getPeriod() == null ? "" : bxdSunshinePaymentInfo.getPeriod());
                        paymentDetailMap.put("payment_frequency", bxdSunshinePaymentInfo.getPayModel() == null ? "" : bxdSunshinePaymentInfo.getPayModel());
                        paymentDetailMap.put("payment_type", bxdSunshinePaymentInfo.getType() == null ? "" : bxdSunshinePaymentInfo.getType());

                        payment_info.add(paymentDetailMap);
                    }
                }

                //other_info
                BxdSunshineInsurantList bxdSunshineInsura = new BxdSunshineInsurantList();
                bxdSunshineInsura.setOrderNum(orderNum);
                List<BxdSunshineInsurantList> insurantLists = bxdSunshineInsurantListMapper.select(bxdSunshineInsura);
                BxdSunshineBeneficiaryList bxdSunshineBeneficia = new BxdSunshineBeneficiaryList();
                bxdSunshineBeneficia.setOrderNum(orderNum);
                List<BxdSunshineBeneficiaryList> bxdSunshineBenefi = bxdSunshineBeneficiaryListMapper.select(bxdSunshineBeneficia);
                if (insurantLists.size() > 0) {
                    for (BxdSunshineInsurantList bxdSunshineInsurantList : insurantLists) {
                        Map<String, Object> InsurantDetailMap = new HashMap<>();
                        InsurantDetailMap.put("insurant_id_card_num", bxdSunshineInsurantList.getIdCardNo() == null ? "" : bxdSunshineInsurantList.getIdCardNo());
                        InsurantDetailMap.put("insurant_name", bxdSunshineInsurantList.getName() == null ? "" : bxdSunshineInsurantList.getName());
                        InsurantDetailMap.put("insurant_relationship", bxdSunshineInsurantList.getRelation() == null ? "" : bxdSunshineInsurantList.getRelation());
                        InsurantDetailMap.put("beneficiary_name", "");
                        InsurantDetailMap.put("beneficiary_relationship", "");
                        InsurantDetailMap.put("auto_insurance", "无");
                        if (bxdSunshineBenefi.size() > 0) {
                            for (BxdSunshineBeneficiaryList bxdSunshineBeneficiaryList : bxdSunshineBenefi) {
                                InsurantDetailMap.put("beneficiary_name", bxdSunshineBeneficiaryList.getName() == null ? "" : bxdSunshineBeneficiaryList.getName());
                                InsurantDetailMap.put("beneficiary_relationship", bxdSunshineBeneficiaryList.getRelation() == null ? "" : bxdSunshineBeneficiaryList.getRelation());

                            }
                        }
                        other_info.add(InsurantDetailMap);
                    }
                }
            }
        } catch (Exception e) {

            log.info("bxd get Info Exception", e);
        } finally {
            dataMap.put("applicant_info", applicant_info);
            dataMap.put("warranty_base_info", warranty_base_info);
            dataMap.put("warranty_details", warranty_details);
            dataMap.put("payment_info", payment_info);
            dataMap.put("other_info", other_info);
        }
        return ResponseResult.ok(dataMap);
    }
}
