package com.fiap.cicd.educaapp.controller

import com.fiap.cicd.educaapp.model.User
import com.fiap.cicd.educaapp.repository.GameRepository
import com.fiap.cicd.educaapp.repository.SchoolRepository
import com.fiap.cicd.educaapp.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api")
class UserController(private val userRepository: UserRepository,
                     private val schoolRepository: SchoolRepository,
                     private val gameRepository: GameRepository
) {

    @GetMapping("/users")
    @ResponseBody
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @PostMapping("/users")
    @ResponseBody
    fun createNewUser(@RequestBody user: User) {
        //user.school?.let { schoolRepository.save(it) }
        userRepository.save(user)
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    fun getUserById(@PathVariable(value = "id") UserId: Long): ResponseEntity<User> {
        return userRepository.findById(UserId).map { User ->
            ResponseEntity.ok(User)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/users/{id}")
    @ResponseBody
    fun deleteUserById(@PathVariable(value = "id") UserId: Long): ResponseEntity<Void> {

        return userRepository.findById(UserId).map { User  ->
            userRepository.delete(User)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/users/{idUser}/games/{idGame}")
    @ResponseBody
    fun addNewGame(@PathVariable(value = "idUser") UserId: Long,
                   @PathVariable(value = "idGame") GameId: Long): ResponseEntity<Void> {

        return userRepository.findById (UserId).map { User ->
            gameRepository.findById (GameId).map { Game ->
                User.games.add(Game)
                userRepository.save(User)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
        }.orElse(ResponseEntity.notFound().build())
    }
}

