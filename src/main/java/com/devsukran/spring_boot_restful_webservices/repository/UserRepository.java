package com.devsukran.spring_boot_restful_webservices.repository;

import com.devsukran.spring_boot_restful_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{


}
