package com.ivoronline.springboot_database_namedparameterjdbctemplate_insert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  public int insert(String name, Integer age) {

    String sql = "INSERT INTO PERSON (NAME, AGE) VALUES (:personName, :personAge)";

    SqlParameterSource parameters = new MapSqlParameterSource()
      .addValue("personName", name)
      .addValue("personAge" , age);

    return namedParameterJdbcTemplate.update(sql, parameters);

  }

  //=========================================================================================================
  // INSERT AND RETURN ID
  //=========================================================================================================
  public int insertAndReturnId(String name, Integer age) {

    String sql = "INSERT INTO PERSON (NAME, AGE) VALUES (:personName, :personAge)";

    SqlParameterSource parameters = new MapSqlParameterSource()
      .addValue("personName", name)
      .addValue("personAge" , age);

    KeyHolder keyHolder = new GeneratedKeyHolder();

    namedParameterJdbcTemplate.update(sql, parameters, keyHolder);

    return keyHolder.getKey().intValue();

  }

}
