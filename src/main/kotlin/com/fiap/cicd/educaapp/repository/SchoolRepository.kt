package com.fiap.cicd.educaapp.repository

import com.fiap.cicd.educaapp.model.School
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchoolRepository : JpaRepository<School, Long> {
}