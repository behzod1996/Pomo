package com.hfad.pomo.utils

open class ApplicationLevelException(override val message: String?,
                                     override val cause: Throwable? = null) : Exception(message, cause)