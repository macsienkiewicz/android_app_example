package com.example.exercise4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.os.bundleOf

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment23.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment23 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_23, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var red = 0
        var green = 0
        var blue = 0
        val barRed: SeekBar? = view.findViewById(R.id.seekBar)
        val barGreen: SeekBar? = view.findViewById(R.id.seekBar2)
        val barBlue: SeekBar? = view.findViewById(R.id.seekBar3)
        val textRed: TextView? = view.findViewById(R.id.textView)
        val textGreen: TextView? = view.findViewById(R.id.textView2)
        val textBlue: TextView? = view.findViewById(R.id.textView3)

        barRed?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(p0: SeekBar?, currentValue: Int, p2: Boolean) {
                val seek_value: Int = barRed.progress.toInt()
                textRed?.setText("R: "+seek_value)
                red = seek_value
                //textView.setTextColor(Color.rgb(seekBar.progress.toInt(),0,0))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        barGreen?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(p0: SeekBar?, currentValue: Int, p2: Boolean) {
                val seek_value: Int = barGreen.progress.toInt()
                textGreen?.setText("G: "+seek_value)
                green = seek_value
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        barBlue?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(p0: SeekBar?, currentValue: Int, p2: Boolean) {
                val seek_value: Int = barBlue.progress.toInt()
                textBlue?.setText("B: "+seek_value)
                blue = seek_value
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })



        val button: Button? = view.findViewById(R.id.button)
        if (button != null) {
            button.setOnClickListener { view ->
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return@setOnClickListener
                with(sharedPref.edit()) {
                    putInt("red", red)
                    putInt("green", green)
                    putInt("blue", blue)
                    apply()
                }

            }
        }




    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment23.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment23().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}