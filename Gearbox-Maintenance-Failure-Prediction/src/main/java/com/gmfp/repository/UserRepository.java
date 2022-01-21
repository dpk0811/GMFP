package com.gmfp.repository;

import com.gmfp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

    Optional<UserModel> findByUsernameAndPassword(String username, String password);

}
