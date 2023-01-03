package com.portfolio.demo.model

import javax.persistence.*

@Entity(name = "about_me")
data class AboutMe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column
    val banner_url: String = "",
    @Column
    val profile_url: String = "",
    @Column
    val full_name: String = "",
    @Column
    val current_position: String = "",
    @Column
    val current_company_icon_url: String = "",
    @Column
    val current_company: String = "",
    @Column
    val current_address: String = "",
    @Column
    val detail: String = "",
    ) {}