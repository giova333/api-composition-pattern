package com.gladunalexander.statisticservice

import org.springframework.beans.factory.SmartInitializingSingleton
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class StatisticServiceApplication {

    @Bean
    fun initPostStatistics(repository: PostStatisticRepository) = SmartInitializingSingleton {
        repository.saveAll(
                listOf(
                        PostStatistic(1, 22000, 800, 432),
                        PostStatistic(2, 1230, 16, 3)
                )
        )
    }
}

fun main(args: Array<String>) {
    runApplication<StatisticServiceApplication>(*args)
}
