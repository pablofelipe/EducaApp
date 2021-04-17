package com.fiap.cicd.educaapp.repository

import com.fiap.cicd.educaapp.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}