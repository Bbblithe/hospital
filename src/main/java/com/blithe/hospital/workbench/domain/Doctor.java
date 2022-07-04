package com.blithe.hospital.workbench.domain;

/**
 * Author:  blithe.xwj
 * Date:    2022/7/4 10:20
 * Description:
 */

public class Doctor {
    private String ID;
    private String DoctorCode;
    private String DoctorName;
    private String Grade;
    private String PhotoFileID;
    private String MainCodeList;
    private String Sex;
    private String DocIntro;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDoctorCode() {
        return DoctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        DoctorCode = doctorCode;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getPhotoFileID() {
        return PhotoFileID;
    }

    public void setPhotoFileID(String photoFileID) {
        PhotoFileID = photoFileID;
    }

    public String getMainCodeList() {
        return MainCodeList;
    }

    public void setMainCodeList(String mainCodeList) {
        MainCodeList = mainCodeList;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDocIntro() {
        return DocIntro;
    }

    public void setDocIntro(String docIntro) {
        DocIntro = docIntro;
    }

    public Doctor() {
    }
}
