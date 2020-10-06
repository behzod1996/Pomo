package com.hfad.pomo.model.local.entity

import androidx.room.Embedded

data class TaskDto(
@Embedded  val taskEntity: TaskEntity,
@Embedded  val projectEntity: ProjectEntity?
)