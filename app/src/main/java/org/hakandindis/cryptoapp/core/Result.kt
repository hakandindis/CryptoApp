package org.hakandindis.cryptoapp.core

/**
 * CREATED BY HAKAN DINDIŞ on 1.01.2024
 */
sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Failure(val throwable: Throwable, val message: String = "0000") : Result<Nothing>()
}