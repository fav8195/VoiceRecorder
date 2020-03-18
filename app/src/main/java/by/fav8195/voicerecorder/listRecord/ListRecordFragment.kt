package by.fav8195.voicerecorder.listRecord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import by.fav8195.voicerecorder.R
import by.fav8195.voicerecorder.R.layout.fragment_list_record

/**
 * A simple [Fragment] subclass.
 */
class ListRecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(fragment_list_record, container, false)
    }

}
