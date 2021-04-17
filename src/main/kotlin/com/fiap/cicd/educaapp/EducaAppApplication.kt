package com.fiap.cicd.educaapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EducaAppApplication

fun main(args: Array<String>) {
	runApplication<EducaAppApplication>(*args)
}
