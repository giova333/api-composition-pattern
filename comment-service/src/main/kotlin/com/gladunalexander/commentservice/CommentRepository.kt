package com.gladunalexander.commentservice

import org.springframework.data.mongodb.repository.MongoRepository

interface CommentRepository : MongoRepository<Comment, String> {

    fun findByPostId(postId: Long): List<Comment>

}