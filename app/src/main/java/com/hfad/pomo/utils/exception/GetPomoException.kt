package ru.ischenko.roman.focustimer.domain.error

import com.hfad.pomo.utils.exception.ApplicationLevelException


class GetPomoException(override val message: String?, override val cause: Throwable?):
        ApplicationLevelException(message, cause)