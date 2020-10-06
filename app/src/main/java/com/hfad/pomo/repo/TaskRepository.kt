package com.hfad.pomo.repo


import com.hfad.pomo.model.Task
import com.hfad.pomo.model.local.dao.TaskDao
import com.hfad.pomo.repo.converter.TaskConverter

interface TaskRepository {

    suspend fun getTaskById(id: Long): Task

    suspend fun getTaskByGoal(goal: String): Task

    suspend fun addTask(task: Task)

    suspend fun saveTask(task: Task)

    suspend fun deleteTask(task: Task)
}
class TaskRepositoryImpl(private val taskDao: TaskDao,
                         private val taskConverter: TaskConverter
): TaskRepository {

    override suspend fun getTaskById(id: Long): Task {
        val taskDto = taskDao.getById(id)
        return taskConverter.convert(taskDto)
    }

    override suspend fun getTaskByGoal(goal: String): Task {
        val taskDto = taskDao.getByGoal(goal)
        return taskConverter.convert(taskDto)
    }

    override suspend fun addTask(task: Task) {
        val taskDto = taskConverter.convertBack(task)
        task.id = taskDao.insert(taskDto.taskEntity)
    }

    override suspend fun saveTask(task: Task) {
        val taskDto = taskConverter.convertBack(task)
        taskDao.update(taskDto.taskEntity)
    }

    override suspend fun deleteTask(task: Task) {
        val taskDto = taskConverter.convertBack(task)
        taskDao.delete(taskDto.taskEntity)
    }
}