package com.portfolio.demo.model

import javax.persistence.*

@Entity(name = "person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column
    val name: String = "",
    @Column
    val surname: String = "",
    @Column
    val address: String = "",
    @Column
    val phone: String = "",
    @Column
    val birthday: String = "",
    @Column
    val email: String = "",
    @Column
    val about: String = "",
    @Column
    val photo_url: String = "",
    ) {}