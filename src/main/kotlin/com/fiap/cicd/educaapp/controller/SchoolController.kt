package com.fiap.cicd.educaapp.controller

import com.fiap.cicd.educaapp.model.School
import com.fiap.cicd.educaapp.repository.SchoolRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api")
class SchoolController (private val schoolRepository: SchoolRepository){

    @GetMapping("/schools")
    @ResponseBody
    fun getAllSchools(): List<School> {
        return schoolRepository.findAll()
    }

    @PostMapping("/schools")
    @ResponseBody
    fun createNewSchool(@RequestBody school: School) {
        schoolRepository.save(school)
    }

    @GetMapping("/schools/{id}")
    @ResponseBody
    fun getSchoolById(@PathVariable(value = "id") SchoolId: Long): ResponseEntity<School> {
        return schoolRepository.findById(SchoolId).map { School ->
            ResponseEntity.ok(School)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/schools/{id}")
    @ResponseBody
    fun deleteSchoolById(@PathVariable(value = "id") SchoolId: Long): ResponseEntity<Void> {

        return schoolRepository.findById(SchoolId).map { School  ->
            schoolRepository.delete(School)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}