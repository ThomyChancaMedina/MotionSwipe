package com.technical.cats.ui.card


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import com.technical.cats.R

import com.technical.cats.data.database.RoomDataSource
import com.technical.cats.data.server.CatDbDataSource
import com.technical.cats.ui.EmptyCard
import com.technical.cats.ui.common.appA
import com.technical.cats.ui.common.getViewModel
import com.technical.data.repository.CatsRepository
import com.technical.domain.Cat
import com.technical.usecases.FindCatByCountry

import kotlinx.android.synthetic.main.activity_card.*


class CardActivity : AppCompatActivity() {


    val TAG = CardActivity::class.java.simpleName

    val data: ArrayList<Cat> = ArrayList()
     var currentIndex:Int = 0


    private lateinit var component: CardActivityComponent
    private val viewModel by lazy { getViewModel { component.cardViewModel } }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        val intent = intent
        val country = intent.getStringExtra("key")


        component=appA.component.plus(CardActivityModule(country!!))


        viewModel.cat.observe(this, Observer(::updateUi))
        viewModel.modelStream.observe(this, Observer {
            bindCard(it)
        })

        motionLayout.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {

                when (currentId) {
                    R.id.offScreenPass,
                    R.id.offScreenLike -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.rest, R.id.like)
                       viewModel.swipe()


                    }
                }
            }

        })

        likeButton.setOnClickListener {
            motionLayout.transitionToState(R.id.like)

        }

        passButton.setOnClickListener {
            motionLayout.transitionToState(R.id.pass)
        }


    }


    private fun updateUi(uiModelCard: CardViewModel.UiModelCard?) {

        when (uiModelCard) {
            is CardViewModel.UiModelCard.GetAllUser -> {


                if (uiModelCard.cats.size != null) {
                    viewModel.setCats(uiModelCard.cats)
                    data.addAll(uiModelCard.cats)
                    currentIndex+=1
                    topImage.setImageDrawable(getResources().getDrawable(uiModelCard.cats[0].image))
                    bottomImage.setImageDrawable(getResources().getDrawable(uiModelCard.cats[1].image))
                }

            }
        }

    }


    private fun bindCard(model: CardView) {
        Log.d(TAG, "bindCard: thomy:: "+currentIndex)
        if (data.size > currentIndex){
            topImage.setImageDrawable(resources.getDrawable(model.top.image))
            bottomImage.setImageDrawable(getResources().getDrawable(model.bottom.image))
            currentIndex+=1

        }else{
            val intent = Intent(this, EmptyCard::class.java)
            startActivity(intent)
        }

    }
}

