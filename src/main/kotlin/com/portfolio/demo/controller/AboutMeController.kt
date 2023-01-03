package com.portfolio.demo.controller

import com.portfolio.demo.model.AboutMe
import com.portfolio.demo.service.api.AboutMeServiceAPI
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
@RequestMapping("/api/about-me")
@CrossOrigin("*")
class AboutMeController {
    @Autowired
    lateinit var aboutMeServiceAPI: AboutMeServiceAPI

    @GetMapping("/all")
    fun getAll() : MutableList<AboutMe>? {
        return aboutMeServiceAPI.all
    }

    @PostMapping("/save")
    fun save(@RequestBody aboutMe: AboutMe): ResponseEntity<AboutMe>{
        var obj = aboutMeServiceAPI.save(aboutMe)

        return ResponseEntity<AboutMe>(aboutMe, HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<AboutMe>{
        val aboutMeForDelete = aboutMeServiceAPI[id]
        if(aboutMeForDelete != null){
            aboutMeServiceAPI.delete(id)
        }else{
            ResponseEntity<AboutMe>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(aboutMeForDelete, HttpStatus.OK)
    }
}