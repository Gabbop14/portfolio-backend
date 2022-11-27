package com.portfolio.demo.service.impl

import com.portfolio.demo.commons.GenericServiceImpl
import com.portfolio.demo.model.Person
import com.portfolio.demo.repository.PersonRepository
import com.portfolio.demo.service.api.PersonServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl : GenericServiceImpl<Person, Long>(), PersonServiceAPI {
    @Autowired
    lateinit var personRepository: PersonRepository

    override val dao: CrudRepository<Person, Long>
        get() {
            return personRepository
        }
}