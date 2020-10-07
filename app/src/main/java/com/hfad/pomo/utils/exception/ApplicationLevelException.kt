package com.hfad.pomo.utils.exception

open class ApplicationLevelException(override val message: String?,
                                     override val cause: Throwable? = null) : Exception(message, cause)