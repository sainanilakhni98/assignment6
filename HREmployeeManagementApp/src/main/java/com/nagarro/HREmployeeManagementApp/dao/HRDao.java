package com.nagarro.HREmployeeManagementApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.HREmployeeManagementApp.entity.HRDetail;

public interface HRDao extends JpaRepository<HRDetail,Integer> {

}
