package com.blithe.hospital.workbench.web.controller;

import com.blithe.hospital.vo.PaginationVo;
import com.blithe.hospital.workbench.domain.DoctorDuty;
import com.blithe.hospital.workbench.service.DoctorDutyService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Author:  blithe.xwj
 * Date:    2022/6/24 11:07
 * Description:
 */

@Controller
@RequestMapping("workbench/schedule")
public class DoctorDutyController {

    @Resource
    DoctorDutyService doctorDutyService;

    @RequestMapping("pageList.do")
    @ResponseBody
    public PaginationVo<DoctorDuty> getPageList(Integer pageNo, Integer pageSize, String mainClass,
                                    String doctor, String techRoom) {
        DoctorDuty doctorDuty = new DoctorDuty();
        doctorDuty.setDoctorName(doctor);
        doctorDuty.setTechOfficeName(techRoom);
        doctorDuty.setMainClassName(mainClass);
        PaginationVo<DoctorDuty> paginationVo = doctorDutyService.pageList(pageNo,pageSize,doctorDuty);
        for(DoctorDuty duty:paginationVo.getDataList()){
            duty.setDutyDate(duty.getDutyDate().substring(0,10));
            if("0".equals(duty.getDutyType())){
                duty.setDutyType("临时值班");
            }else{

            }
            if("2".equals(duty.getDutyTimeStage())){
                duty.setDutyTimeStage("全天");
            }else if("1".equals(duty.getDutyTimeStage())){
                duty.setDutyTimeStage("下午");
            }else{
                duty.setDutyTimeStage("上午");
            }
        }
        return paginationVo;
    }
}
