package com.hfad.pomo.repository.converter

import com.hfad.pomo.model.Task
import com.hfad.pomo.model.local.entity.TaskDto
import com.hfad.pomo.model.local.entity.TaskEntity

class TaskConverter(private val projectConverter: ProjectConverter) {

    fun convert(taskDto: TaskDto): Task {
        with (taskDto.taskEntity) {
            return Task(projectConverter.convert(taskDto.projectEntity), goal, estimatedPomodorosCount, spendPomodorosCount,
                done, scheduledTime, idTask)
        }
    }

    fun convertBack(task: Task): TaskDto {
        with (task) {
            val taskEntity = TaskEntity(id, goal, estimatedPomoCount, spendPomoCount,
                done, scheduledTime, task.project?.id)
            val projectEntity = projectConverter.convertBack(task.project)
            return TaskDto(taskEntity, projectEntity)
        }
    }
}