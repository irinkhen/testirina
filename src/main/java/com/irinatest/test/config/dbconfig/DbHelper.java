package com.irinatest.test.config.dbconfig;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface DbHelper { 
    @SqlQuery("SELECT citizenid FROM reg_office.citizens WHERE passportnumber = :passport")
    Integer getCitizensByPassport(@Bind("passport") String passport);
}
