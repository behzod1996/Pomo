package ru.ischenko.roman.focustimer.domain.error

import com.hfad.pomo.utils.exception.ApplicationLevelException


class CreateTaskException(override val message: String?, override val cause: Throwable?):
        ApplicationLevelException(message, cause)