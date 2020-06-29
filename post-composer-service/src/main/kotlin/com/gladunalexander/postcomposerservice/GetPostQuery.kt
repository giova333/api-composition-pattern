package com.gladunalexander.postcomposerservice

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class GetPostQuery(private val restTemplate: RestTemplate) : GraphQLQueryResolver {

    private val postsUrl = "http://localhost:8081/posts/{id}"

    fun getPost(id: Long) =
            restTemplate.getForObject(postsUrl, Post::class.java, id)
}