package com.technical.cats.ui.main

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.technical.cats.R

import com.technical.cats.databinding.FragmentMainBinding

import com.technical.cats.ui.card.CardActivity
import com.technical.cats.ui.common.EventObserver
import com.technical.cats.ui.common.app
import com.technical.cats.ui.common.bindingInflate
import com.technical.cats.ui.common.getViewModelF
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {




    private lateinit var adapter: CatNameAdapter
    private lateinit var navController: NavController
    private var binding: FragmentMainBinding? = null

    private lateinit var component: MainFragmentComponent

    private val viewModel:MainViewModel by lazy { getViewModelF { component.mainViewModel } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = container?.bindingInflate(R.layout.fragment_main, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()


        val list = resources.getStringArray(R.array.countries);
        val adapterSpinner: ArrayAdapter<String> = object : ArrayAdapter<String>(
            app,
            android.R.layout.simple_spinner_dropdown_item,
            list
        ) {
            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(
                    position,
                    convertView,
                    parent
                ) as TextView

                view.setTypeface(view.typeface, Typeface.BOLD)


                if (position == spinner_nav.selectedItemPosition && position != 0) {
                    view.background = ColorDrawable(Color.parseColor("#F7E7CE"))
                    view.setTextColor(Color.parseColor("#333399"))
                }


                if (position == 0) {
                    view.setTextColor(Color.LTGRAY)
                }

                return view
            }

            override fun isEnabled(position: Int): Boolean {

                return position != 0
            }
        }
        spinner_nav.adapter = adapterSpinner

        spinner_nav.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                if (position != 0) {
                    tv_spinner.text = "Selected: "


                    val intent = Intent(activity, CardActivity::class.java)
                    intent.putExtra("key", parent.getItemAtPosition(position).toString())
                    startActivity(intent)

                    tv_spinner.append(parent.getItemAtPosition(position).toString())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }


        component=app.component.plus(MainFragmentModule())




        viewModel.model.observe(viewLifecycleOwner, EventObserver {
            viewModel.getAllCats()
        })

        setHasOptionsMenu(true);
        adapter = CatNameAdapter()
        recycler.adapter = adapter

        binding?.apply {
            viewmodel = viewModel
            lifecycleOwner = this@MainFragment
        }


    }

}
