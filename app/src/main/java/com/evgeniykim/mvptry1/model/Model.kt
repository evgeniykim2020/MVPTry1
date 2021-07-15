package com.evgeniykim.mvptry1.model

import com.evgeniykim.mvptry1.contract.Contract
import java.util.*
import java.util.logging.Handler
import kotlin.random.Random as Random1

class Model : Contract.Model {

    private val arrayList = Arrays.asList(
        "DSA Self Paced: Master the basics of Data Structures and Algorithms to solve complex problems efficiently. ",
        "Placement 100: This course will guide you for placement with theory,lecture videos, weekly assignments " +
                "contests and doubt assistance.",
        "Amazon SDE Test Series: Test your skill & give the final touch to your preparation before applying for " +
                "product based against like Amazon, Microsoft, etc.",
        "Complete Interview Preparation: Cover all the important concepts and topics required for the interviews. " +
                "Get placement ready before the interviews begin",
        "Low Level Design for SDE 1 Interview: Learn Object-oriented Analysis and Design to prepare for " +
                "SDE 1 Interviews in top companies"
    )

    override fun getNextCourse(onFinishedListener: Contract.Model.OnFinishedListener?) {
        android.os.Handler().postDelayed({onFinishedListener!!.onFinished(getRandomString)}, 1200)
    }

    private val getRandomString: String
        private get() {
            val random = Random()
            val index = random.nextInt(arrayList.size)
            return arrayList[index]
        }
}