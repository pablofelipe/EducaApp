package com.fiap.cicd.educaapp.controller

import com.fiap.cicd.educaapp.model.Game
import com.fiap.cicd.educaapp.repository.GameRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api")
class GameController (private val gameRepository: GameRepository) {

    @GetMapping("/games")
    @ResponseBody
    fun getAllGames(): List<Game> {
        return gameRepository.findAll()
    }

    @PostMapping("/games")
    @ResponseBody
    fun createNewGame(@RequestBody game: Game) {
        gameRepository.save(game)
    }

    @GetMapping("/games/{id}")
    @ResponseBody
    fun getGameById(@PathVariable(value = "id") GameId: Long): ResponseEntity<Game> {
        return gameRepository.findById(GameId).map { Game ->
            ResponseEntity.ok(Game)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/games/{id}")
    @ResponseBody
    fun deleteGameById(@PathVariable(value = "id") GameId: Long): ResponseEntity<Void> {

        return gameRepository.findById(GameId).map { Game  ->
            gameRepository.delete(Game)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}