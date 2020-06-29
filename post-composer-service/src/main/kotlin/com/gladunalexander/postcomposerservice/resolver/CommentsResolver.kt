package com.gladunalexander.postcomposerservice.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.gladunalexander.postcomposerservice.Comment
import com.gladunalexander.postcomposerservice.Post
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class CommentsResolver(private val restTemplate: RestTemplate,
                       private val mapper: ObjectMapper) : GraphQLResolver<Post> {

    private val postsUrl = "http://localhost:8082/comments/search/findByPostId?postId={id}"

    fun getComments(post: Post): List<Comment> {
        val commentsNode = restTemplate.exchange(
                postsUrl,
                HttpMethod.GET,
                null,
                JsonNode::class.java,
                post.id
        ).body?.get("_embedded")?.get("comments")

        return mapper.convertValue(commentsNode, object : TypeReference<List<Comment>>() {})
    }
}