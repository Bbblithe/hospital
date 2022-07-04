package com.blithe.hospital.workbench.service.impl;

import com.blithe.hospital.vo.PaginationVo;
import com.blithe.hospital.workbench.dao.DoctorDutyDao;
import com.blithe.hospital.workbench.domain.DoctorDuty;
import com.blithe.hospital.workbench.domain.MainClass;
import com.blithe.hospital.workbench.service.DoctorDutyService;
import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * Author:  blithe.xwj
 * Date:    2022/6/24 18:25
 * Description:
 */

@Service
public class DoctorDutyServiceImpl implements DoctorDutyService {

    @Resource
    DoctorDutyDao doctorDutyDao;

    @Override
    public PaginationVo<DoctorDuty> pageList(Integer pageNo, Integer pageSize, DoctorDuty doctorDuty){
        PaginationVo<DoctorDuty> vo = new PaginationVo<>();
        vo.setTotal(doctorDutyDao.getTotal(doctorDuty));
        PageHelper.startPage(pageNo,pageSize);
        List<DoctorDuty> doctorDutyList = doctorDutyDao.getDutyListByCondition(doctorDuty);
        vo.setDataList(doctorDutyList);
        return vo;
    }

    @Override
    public List<MainClass> getMainClassList() {
        List<MainClass> mainClasses = doctorDutyDao.selectMainClasses();
        return mainClasses;
    }

    @Override
    public List<String> getTechNameList() {
        return doctorDutyDao.selectTechName();
    }

    @Override
    @Transactional
    public boolean delete(String[] ids) {
        int count = 0;
        for(int i = 0 ; i < ids.length ; i ++){
            count += doctorDutyDao.deleteOne(ids[i]);
        }
        return count == ids.length;
    }

    @Override
    public int getLastNo() {
        return doctorDutyDao.getLastNo() + 1;
    }

    @Override
    public boolean saveDuty(DoctorDuty doctorDuty) {
        String docCode = doctorDutyDao.getDoctorIdByName(doctorDuty.getDoctorName());
        String TechOfficeNo = doctorDutyDao.getTechId(doctorDuty.getTechOfficeName());
        if(docCode == "" || docCode == null){
            return false;
        }
        doctorDuty.setDocGrade(doctorDutyDao.getDocGrade(docCode));
        doctorDuty.setDoctorCode(docCode);
        doctorDuty.setTechOfficeCode(TechOfficeNo);
        doctorDuty.setPDetailCode("123123");
        return doctorDutyDao.save(doctorDuty) != 1;
    }
}
