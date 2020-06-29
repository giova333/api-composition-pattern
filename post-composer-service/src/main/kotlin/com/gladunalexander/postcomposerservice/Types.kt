package com.gladunalexander.postcomposerservice

data class Post(
        var id: Long?,
        var text: String? = null,
        var username: String? = null,
        var statistic: PostStatistic? = null,
        var comments: List<Comment>? = null
)

data class PostStatistic(
        var viewsNumber: Long? = null,
        var clicksNumber: Long? = null,
        var repostNumber: Long? = null
)

data class Comment(
        var id: String?,
        var username: String? = null,
        var text: String? = null
)