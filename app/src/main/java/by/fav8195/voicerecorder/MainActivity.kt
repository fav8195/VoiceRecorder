package by.fav8195.voicerecorder

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Активизация меню переключения:
        //передаем имя меню навигации (элемент) и основной вьюшки
        //Имена пунктов меню должны совпадать с именями фрагментов в файле навигации!!!
        NavigationUI.setupWithNavController(bottom_navigation,
        Navigation.findNavController(this,R.id.nav_host_fragment_container))
    }

    fun isServiceRunning(): Boolean {
        val  manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if ("by.fav8195.voicerecorder.record.RecordService" == service.service.className) {
                return true
            }
        }
        return false
    }
}
