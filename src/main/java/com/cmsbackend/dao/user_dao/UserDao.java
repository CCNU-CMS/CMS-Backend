package com.cmsbackend.dao.user_dao;

import com.cmsbackend.entity.user_entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UserDao extends JpaRepository<User,Integer>,Serializable {

    User findById(Long ID);
    User findByAccount(String Account);
    void deleteByAccount(String account);

//    List<User> findAllByIdentityAndStatus(Integer Identity, Integer  Status, Pageable pageable);
}

