package eu.example.decisionmaker.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.example.decisionmaker.data.DecisionProblemRepository
import eu.example.decisionmaker.data.DecisionProblemRepositoryImpl
import eu.example.decisionmaker.data.ProblemDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDecisionProblemDatabase(app: Application): ProblemDatabase {
        return Room.databaseBuilder(
            app,
            ProblemDatabase::class.java,
            "problem_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDecisionProblemRepository(db: ProblemDatabase): DecisionProblemRepository {
        return DecisionProblemRepositoryImpl(db.dao)
    }

}