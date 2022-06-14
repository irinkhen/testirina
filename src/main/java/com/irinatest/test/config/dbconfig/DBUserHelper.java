package com.irinatest.test.config.dbconfig;

import io.qameta.allure.Step;

public class DBUserHelper {

    @Step("Get user Id by passport")
    public String getCitizenIdByPassport(String passport) {
        String query = new StringBuilder()
                .append("SELECT citizenid FROM reg_office.citizens WHERE passportnumber = '")
                .append(passport).append("'")
                .toString();
        return new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Get application id by passport")
    public String getApplicationIdByCitizenId(Integer citizenId) {
        String query = new StringBuilder()
                .append("SELECT applicationId FROM reg_office.applications WHERE citizenid = ")
                .append(citizenId)
                .toString();
        return new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Get applicant Id by passport")
    public String getApplicantIdByPassport(String passport) {
        String query = new StringBuilder()
                .append("SELECT applicantid FROM reg_office.applicants WHERE passportnumber = '")
                .append(passport).append("'")
                .toString();
        return new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Delete row from birth certificates table by citizen Id")
    public void deleteBirthCertificatesById(Integer citizenId) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.birthcertificates WHERE citizenid = ")
                .append(citizenId)
                .toString();
        new DataBaseConnection().deleteRow(query);
    }

    @Step("Delete row from death certificates table by citizen Id")
    public void deleteDeathCertificatesById(Integer citizenId) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.deathcertificates WHERE citizenid = ")
                .append(citizenId)
                .toString();
        new DataBaseConnection().deleteRow(query);
    }

    @Step("Delete row from marriage certificates table by citizen Id")
    public void deleteMarriageCertificatesById(Integer citizenId) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.merrigecertificates WHERE citizenid = ")
                .append(citizenId)
                .toString();
        new DataBaseConnection().deleteRow(query);
    }

    @Step("Delete user from citizens table by user id")
    public void deleteCitizenById(Integer citizenId) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.citizens WHERE citizenid = ")
                .append(citizenId)
                .toString();
        new DataBaseConnection().deleteRow(query);
    }

    @Step("Delete application from applications table by user passport")
    public void deleteApplicantByPassport(String passport) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.applicants WHERE passportnumber = '")
                .append(passport)
                .append("'")
                .toString();
        new DataBaseConnection().deleteRow(query);
    }

    @Step("Delete applicant from applicants table by user Id")
    public void deleteApplicationsByCitizenId(Integer citizenId) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.applications WHERE citizenid = ")
                .append(citizenId)
                .toString();
        new DataBaseConnection().deleteRow(query);
    }

    @Step("Get application status from database")
    public String getApplicationStatus(Integer applicationId) {
        String query = new StringBuilder()
                .append("SELECT statusofapplication FROM reg_office.applications WHERE applicationId = ")
                .append(applicationId)
                .toString();
        return new DataBaseConnection().getSingleValueQuery(query);
    }
}

