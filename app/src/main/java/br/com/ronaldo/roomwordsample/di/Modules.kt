package br.com.ronaldo.roomwordsample.di

import androidx.room.Room
import br.com.ronaldo.roomwordsample.WordViewModel
import br.com.ronaldo.roomwordsample.adapter.WordListAdapter
import br.com.ronaldo.roomwordsample.dao.WordDao
import br.com.ronaldo.roomwordsample.dao.WordRoomDatabase
import br.com.ronaldo.roomwordsample.repository.WordRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single {
        WordRepository(get())
    }
}

val dbModule = module {
    single {
        Room.databaseBuilder(
            get(), // pega o contexto
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single {
        get<WordRoomDatabase>().wordDao()
    }


}

val uiModule = module {

    factory { WordListAdapter(get()) }

}

val viewModelModule = module {
    viewModel { WordViewModel(get(), get()) }
}