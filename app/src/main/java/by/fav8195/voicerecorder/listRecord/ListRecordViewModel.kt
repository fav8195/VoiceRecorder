package by.fav8195.voicerecorder.listRecord

import androidx.lifecycle.ViewModel
import by.fav8195.voicerecorder.database.RecordDatabaseDao

class ListRecordViewModel(
    dataSource: RecordDatabaseDao
) : ViewModel() {

    val database = dataSource
    val records = database.getAllRecords()

}