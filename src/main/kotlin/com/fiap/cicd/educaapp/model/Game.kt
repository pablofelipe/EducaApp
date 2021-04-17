package com.fiap.cicd.educaapp.model

import javax.persistence.*

@Entity
data class Game (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",

    val developer: String = "",

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(name = "UserGame",
        joinColumns = [JoinColumn(name = "game_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")])
    val users: MutableList<User> = mutableListOf<User>()
)
