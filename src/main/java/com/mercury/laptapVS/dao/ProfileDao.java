package com.mercury.laptapVS.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.laptapVS.bean.Profile;

public interface ProfileDao extends JpaRepository<Profile,Integer> {

}
