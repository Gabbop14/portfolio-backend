package com.portfolio.demo.controller

import com.portfolio.demo.model.Person
import com.portfolio.demo.service.api.PersonServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/person")
@CrossOrigin("*")
class PersonController {
    @Autowired
    lateinit var personServiceAPI: PersonServiceAPI

    @GetMapping("/all")
    fun getAll() : MutableList<Person>? {
        return personServiceAPI.all
    }

    @PostMapping("/save")
    fun save(@RequestBody person: Person): ResponseEntity<Person>{
        var obj = personServiceAPI.save(person)

        return ResponseEntity<Person>(person, HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Person>{
        val personForDelete = personServiceAPI.get(id)
        if(personForDelete != null){
            personServiceAPI.delete(id)
        }else{
            ResponseEntity<Person>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(personForDelete, HttpStatus.OK)
    }
}