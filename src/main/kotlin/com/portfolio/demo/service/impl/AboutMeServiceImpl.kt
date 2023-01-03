package com.portfolio.demo.service.impl

import com.portfolio.demo.commons.GenericServiceImpl
import com.portfolio.demo.model.AboutMe
import com.portfolio.demo.repository.AboutMeRepository
import com.portfolio.demo.service.api.AboutMeServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class AboutMeServiceImpl : GenericServiceImpl<AboutMe, Long>(), AboutMeServiceAPI {
    @Autowired
    lateinit var aboutMeRepository: AboutMeRepository

    override val dao: CrudRepository<AboutMe, Long>
        get() {
            return aboutMeRepository
        }
}