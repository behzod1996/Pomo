package com.hfad.pomo.repo.converter

import com.hfad.pomo.model.Project
import com.hfad.pomo.model.local.entity.ProjectEntity

class ProjectConverter {

    fun convert(projectEntity: ProjectEntity?): Project? {
        if (projectEntity == null) {
            return null
        }
        with (projectEntity) {
            return Project(projectName, idProject)
        }
    }

    fun convertBack(project: Project?): ProjectEntity? {
        if (project == null) {
            return null
        }
        with (project) {
            return ProjectEntity(id, projectName)
        }
    }
}