package com.example.exercise4

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var images = arrayOf(R.drawable.android_blue, R.drawable.android_green, R.drawable.android_red, )
    var index = 3



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
        return inflater.inflate(R.layout.fragment_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vPager2: ViewPager2? = view.findViewById(R.id.pager2)
        val vAdapter = MySwipeAdapter(this)
        vPager2?.adapter = vAdapter

        val image: ImageView? = view.findViewById(R.id.img1)
        childFragmentManager.setFragmentResultListener("image", viewLifecycleOwner) {
            requestKey, bundle ->
            index = bundle.getInt("img")
            if (!image?.isVisible!!) {
                image?.setVisibility(View.VISIBLE)
            }
            image?.setImageResource(images[index])

        }

        val button_save: Button? = view.findViewById(R.id.button)
        if (button_save != null) {
            button_save.setOnClickListener { view ->
                val img: Int = index
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return@setOnClickListener
                with(sharedPref.edit()) {
                    if (img != null) {
                        putInt("img", img)
                    }
                    apply()
                }

            }
        }

        val button_cancel: Button? = view.findViewById(R.id.button2)
        if (button_cancel != null) {
            button_cancel.setOnClickListener { view ->
                image?.setImageResource(images[0])
                image?.setVisibility(View.INVISIBLE)
                index = 3

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
         * @return A new instance of fragment Fragment3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}