package com.hfad.pomo.model.local.entity

import androidx.room.Embedded

//Embedded 는 'Room'에서 필드를 꺼내서 'Task' 테이블에서 'Pomo' 테이블로 불러와야 한다고 제안한다.

data class TaskDto(
    @Embedded  val taskEntity: TaskEntity,
    @Embedded  val projectEntity: ProjectEntity?
)
