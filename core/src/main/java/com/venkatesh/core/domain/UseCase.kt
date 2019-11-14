package com.venkatesh.core.domain

abstract class UseCase<T> {
    abstract fun executeUseCase(onStatus: (status: T) -> Unit)
}