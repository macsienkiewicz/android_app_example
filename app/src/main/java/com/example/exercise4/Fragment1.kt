package com.example.exercise4

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences
import android.graphics.Color
import android.widget.*
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.findFragment as findFragment1



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val DEFAULT = "N/A"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var images = arrayOf(R.drawable.android_blue, R.drawable.android_green, R.drawable.android_red)

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
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user: TextView? = view.findViewById(R.id.textView)
        val image: ImageView? = view.findViewById(R.id.img1)
        val information: TextView? = view.findViewById(R.id.textView2)
        val rat_ing_bar: TextView? = view.findViewById(R.id.textView3)
        user?.setText("User")
        image?.setImageResource(images[0])
        information?.setText("Some information")
        rat_ing_bar?.setText("Rate: ?/5")
        val sharedPref = activity?.getPreferences(MODE_PRIVATE)
        val us = sharedPref?.getString("user", "User")
        val img = sharedPref?.getInt("img", 0)
        val info = sharedPref?.getString("info", "Some information")
        val rate = sharedPref?.getString("rating_bar", "Rate: ?/5")
        val red = sharedPref?.getInt("red", 0)
        val green = sharedPref?.getInt("green", 0)
        val blue = sharedPref?.getInt("blue", 0)

        if (user != null) {
            user.setText(us)
        }

        if (information != null) {
            information.setText(info)
        }

        if (img != null) {
            if (img == 3) {
                image?.setVisibility(View.INVISIBLE)
            }
            else {
                image?.setVisibility(View.VISIBLE)
                image?.setImageResource(images[img])
            }

        }

        if (rat_ing_bar != null) {
            rat_ing_bar.setText("Rate: "+rate+"/5")
        }


        view.setBackgroundColor(Color.rgb(red!!, green!!, blue!!))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}