package com.technocoffee.core.productservice.exception

class BadRequestException (s: String, val data: Any? = null): RuntimeException(s) {
}