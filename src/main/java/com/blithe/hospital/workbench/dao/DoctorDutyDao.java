package com.blithe.hospital.workbench.dao;

import com.blithe.hospital.workbench.domain.DoctorDuty;
import com.blithe.hospital.workbench.domain.MainClass;

import java.util.List;

/**
 * Author:  blithe.xwj
 * Date:    2022/6/24 11:06
 * Description:
 */

public interface DoctorDutyDao {
    int getTotal(DoctorDuty doctorDuty);

    List<DoctorDuty> getDutyListByCondition(DoctorDuty doctorDuty);

    List<MainClass> selectMainClasses();

    List<String> selectTechName();

    int deleteOne(String id);

    int getLastNo();

    String getDoctorIdByName(String doctor);

    int save(DoctorDuty doctorDuty);

    String getTechId(String techOfficeName);

    String getDocGrade(String docCode);

    List<String> getDocNameList();
}
