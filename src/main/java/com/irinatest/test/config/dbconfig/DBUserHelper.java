package com.irinatest.test.config.dbconfig;

import io.qameta.allure.Step;

public class DBUserHelper {

    @Step("Get user Id by passport")
    public String getCitizenIdByPassport(String passport) {
        String query = new StringBuilder()
                .append("SELECT citizenid FROM reg_office.citizens WHERE passportnumber = ")
                .append("'")
                .append(passport).append("'")
                .toString();
        return new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Get user Id by passport")
    public String getApplicationIdByCitizenId(Integer citizenId) {
        String query = new StringBuilder()
                .append("SELECT applicationId FROM reg_office.applications WHERE citizenid = ")
                .append(citizenId)
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
        new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Delete row from marriage certificates table by citizen Id")
    public void deleteMarriageCertificatesById(Integer citizenId) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.merrigecertificates WHERE citizenid = ")
                .append(citizenId)
                .toString();
        new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Delete user from citizens table by passport")
    public void deleteCitizenById(Integer citizenId) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.citizens WHERE citizenid = ")
                .append(citizenId)
                .toString();
        new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Delete application from applications table by user passport")
    public void deleteApplicantByPassport(String passport) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.applicants WHERE citizenid = ")
                .append("'")
                .append(passport)
                .append("'")
                .toString();
        new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Delete applicant from applicants table by user Id")
    public void deleteApplicationsByCitizenId(Integer citizenId) {
        String query = new StringBuilder()
                .append("DELETE FROM reg_office.applications WHERE citizenid = ")
                .append(citizenId)
                .toString();
        new DataBaseConnection().getSingleValueQuery(query);
    }
}

