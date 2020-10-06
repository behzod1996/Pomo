package com.hfad.pomo.repository.converter

import com.hfad.pomo.model.Pomo
import com.hfad.pomo.model.local.entity.PomoDto
import com.hfad.pomo.model.local.entity.PomoEntity
import java.util.*

class PomoConverter(private val taskConverter: TaskConverter) {

    fun convert(pomodoroDto: PomoDto): Pomo {
        with (pomodoroDto.pomoEntity) {
            return Pomo(taskConverter.convert(pomodoroDto.taskDto), Date(completeDate),
                pomoTime, goalAchieved, efficiencyMark, retrospectiveComment, distractionCount)
        }
    }

    fun convertBack(pomo: Pomo): PomoDto {
        with (pomo) {
            val pomodoroEntity = PomoEntity(id, completeDate.time, pomodoroTime, goalAchieved,
                efficiencyMark, retrospectiveComment, distractionCount, pomo.task.id)
            val taskDto = taskConverter.convertBack(pomo.task)
            return PomoDto(pomodoroEntity, taskDto)
        }
    }
}