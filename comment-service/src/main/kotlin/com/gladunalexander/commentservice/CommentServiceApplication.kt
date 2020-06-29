package com.gladunalexander.commentservice

import org.springframework.beans.factory.SmartInitializingSingleton
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CommentServiceApplication {

    @Bean
    fun initComments(repository: CommentRepository) = SmartInitializingSingleton {
        repository.saveAll(
                listOf(
                        Comment(postId = 1, username = "bill", text = "Yes, indeed"),
                        Comment(postId = 1, username = "angela", text = "The best language ever"),
                        Comment(postId = 2, username = "bill", text = "Yes, I don't like it as well")
                )
        )
    }
}

fun main(args: Array<String>) {
    runApplication<CommentServiceApplication>(*args)
}
