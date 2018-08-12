package com.insomnia.example.domain.executor

import io.reactivex.Scheduler

/**
 * Created by pparrado on 21/06/2018.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}