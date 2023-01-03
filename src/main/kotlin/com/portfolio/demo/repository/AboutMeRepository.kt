package com.portfolio.demo.repository

import com.portfolio.demo.model.AboutMe
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AboutMeRepository : CrudRepository<AboutMe, Long> {
}