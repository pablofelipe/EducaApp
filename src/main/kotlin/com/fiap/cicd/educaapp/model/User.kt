package com.fiap.cicd.educaapp.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.*

@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",

    val birthday: Date,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id")
    val school: School? = null,

    //@JsonManagedReference
    //@OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "user")

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(name = "UserGame",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "game_id", referencedColumnName = "id")])
    val games: MutableList<Game> = mutableListOf<Game>()
)
