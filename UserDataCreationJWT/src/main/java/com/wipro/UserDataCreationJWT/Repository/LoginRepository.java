package com.wipro.UserDataCreationJWT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.UserDataCreationJWT.Entity.UserEmployeeData;


public interface LoginRepository extends JpaRepository<UserEmployeeData,Integer>{

}
