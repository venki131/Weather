package com.venkatesh.core.rx

import io.reactivex.Scheduler

interface SchedulerProvider {

    val mainThread: Scheduler
    val io: Scheduler
    val newThread: Scheduler
}