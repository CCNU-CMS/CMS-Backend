package com.cmsbackend.dao.user_dao;

import com.cmsbackend.entity.course_entity.Course;
import com.cmsbackend.entity.user_entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends JpaRepository<User,Integer>,Serializable {


    User findById(Long ID);
    User findByAccount(String Account);
    List<User> findAllByIdentity(long identity, Pageable pageable);
    Page<User> findAll(Pageable pageable);
    void deleteByAccount(String account);

//    List<User> findAllByIdentityAndStatus(Integer Identity, Integer  Status, Pageable pageable);
}

