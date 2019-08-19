package br.com.ronaldo.roomwordsample.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import br.com.ronaldo.roomwordsample.dao.WordDao
import br.com.ronaldo.roomwordsample.model.Word

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }

}