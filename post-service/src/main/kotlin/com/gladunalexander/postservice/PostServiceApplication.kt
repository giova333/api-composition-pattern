package com.gladunalexander.postservice

import org.springframework.beans.factory.SmartInitializingSingleton
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PostServiceApplication {

    @Bean
    fun initPosts(repository: PostRepository) = SmartInitializingSingleton {
        repository.saveAll(
                listOf(
                        Post(username = "bob", text = "Kotlin is cool!"),
                        Post(username = "bob", text = "I don't like golang. Worst language ever."),
                        Post(username = "alex", text = "Covid19 has ruined all my plans")
                )
        )
    }
}

fun main(args: Array<String>) {
    runApplication<PostServiceApplication>(*args)
}
