package com.gladunalexander.postcomposerservice.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.gladunalexander.postcomposerservice.Post
import com.gladunalexander.postcomposerservice.PostStatistic
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class PostStatisticResolver(private val restTemplate: RestTemplate) : GraphQLResolver<Post> {

    private val statisticUrl = "http://localhost:8083/statistic/search/findByPostId?postId={id}"

    fun getStatistic(post: Post) =
            restTemplate.getForObject(statisticUrl, PostStatistic::class.java, post.id)
}