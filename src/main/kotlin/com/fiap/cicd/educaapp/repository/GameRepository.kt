package com.fiap.cicd.educaapp.repository

import com.fiap.cicd.educaapp.model.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : JpaRepository<Game, Long> {
}