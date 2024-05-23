package com.ivoronline.springboot_database_namedparameterjdbctemplate_insert.controllers;

import com.ivoronline.springboot_database_namedparameterjdbctemplate_insert.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/insert")
  public int insert() {
    int    success = myService.insert("Jill", 40);
    return success;
  }

  //=========================================================================================================
  // INSERT AND RETURN ID
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/insertAndReturnId")
  public int insertAndReturnId() {
    int    id = myService.insertAndReturnId("Jill", 40);
    return id;
  }

}

