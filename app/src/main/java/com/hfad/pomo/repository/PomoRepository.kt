package com.hfad.pomo.repository

import com.hfad.pomo.model.Pomo
import com.hfad.pomo.model.local.dao.PomoDao
import com.hfad.pomo.model.local.dao.ProjectDao
import com.hfad.pomo.model.local.dao.TaskDao
import com.hfad.pomo.repository.converter.PomoConverter
import java.util.*

interface PomoRepository {

    suspend fun getPomoById(id: Long): Pomo

    suspend fun getCountPomoInPeriod(beginDate: Date, endDate: Date): Long

    suspend fun getPomoInPerioid(beginDate: Date, endDate: Date): List<Pomo>

    suspend fun addPomo(pomo : Pomo)

    suspend fun savePomo(pomo : Pomo)

    suspend fun deletePomo(pomo : Pomo)
}

class PomoRepositoryImp(private val pomoDao: PomoDao,
                        private val taskDao : TaskDao,
                        private val projectDao : ProjectDao,
                        private val pomoConverter: PomoConverter
) : PomoRepository {
    override suspend fun getPomoById(id: Long): Pomo {
        val getPomoDto = pomoDao.getById(id)
        return pomoConverter.convert(getPomoDto)
    }

    override suspend fun getCountPomoInPeriod(beginDate: Date, endDate: Date): Long {
        return pomoDao.getCountInPeriod(beginDate, endDate)
    }

    override suspend fun getPomoInPerioid(beginDate: Date, endDate: Date): List<Pomo> {
        val pomo = pomoDao.getPomodorosInPeriod(beginDate, endDate)
        return pomo.map { pomoConverter.convert(it) }
    }

    override suspend fun addPomo(pomo: Pomo) {
        val pomoDto = pomoConverter.convertBack(pomo)
        pomo.id = pomoDao.insert(pomoDto.pomoEntity)
    }

    override suspend fun deletePomo(pomo: Pomo) {
        val pomoDto = pomoConverter.convertBack(pomo)
        pomoDao.delete(pomoDto.pomoEntity)
    }

    override suspend fun savePomo(pomo: Pomo) {
        val pomoDto = pomoConverter.convertBack(pomo)
        pomoDao.update(pomoDto.pomoEntity)
    }
}