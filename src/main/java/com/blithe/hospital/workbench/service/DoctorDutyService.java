package com.blithe.hospital.workbench.service;

import com.blithe.hospital.vo.PaginationVo;
import com.blithe.hospital.workbench.domain.DoctorDuty;
import com.blithe.hospital.workbench.domain.MainClass;

import java.util.List;

/**
 * Author:  blithe.xwj
 * Date:    2022/6/24 18:25
 * Description:
 */

public interface DoctorDutyService {

    PaginationVo<DoctorDuty> pageList(Integer pageNo, Integer pageSize, DoctorDuty doctorDuty);

    List<MainClass> getMainClassList();

    List<String> getTechNameList();

    boolean delete(String[] ids);

    int getLastNo();

    boolean saveDuty(DoctorDuty doctorDuty);
}
