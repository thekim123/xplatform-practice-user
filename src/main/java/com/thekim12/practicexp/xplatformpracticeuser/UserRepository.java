package com.thekim12.practicexp.xplatformpracticeuser;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thekim12.practicexp.xplatformpracticeuser.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	void deleteByEmplId(String emplId);
}
