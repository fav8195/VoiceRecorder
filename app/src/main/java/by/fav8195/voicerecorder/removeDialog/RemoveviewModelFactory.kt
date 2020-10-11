package by.fav8195.voicerecorder.removeDialog

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.fav8195.voicerecorder.database.RecordDatabaseDao
import java.lang.IllegalArgumentException

class RemoveViewModelFactory(
    private val databaseDao: RecordDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RemoveViewModel::class.java)) {
            return RemoveViewModel(
                databaseDao,
                application
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}