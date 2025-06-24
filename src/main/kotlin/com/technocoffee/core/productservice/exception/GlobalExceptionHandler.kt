package com.technocoffee.core.productservice.exception

import com.technocoffee.core.productservice.domain.dto.response.BaseResponse
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequest(exception: BadRequestException): ResponseEntity<BaseResponse<*>> {
        exception.printStackTrace()
        return ResponseEntity.badRequest().body(BaseResponse<Any?>(
            UUID.randomUUID(),
            "F",
            "Invalid Request",
            exception.message,
            data = exception.data
        ))
    }
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValid(exception: MethodArgumentNotValidException): ResponseEntity<BaseResponse<*>>{
        val errors = mutableListOf<String>()
        exception.bindingResult.fieldErrors.forEach {
            errors.add(it.defaultMessage!!)
        }
        return ResponseEntity.badRequest().body(BaseResponse<Any?>(
            UUID.randomUUID(),
            "F",
            "Invalid Request",
            errors
        ))
    }
}
