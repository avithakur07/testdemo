package com.eduztech.testdemo

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    public var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun recyclerViewTest(){
        Espresso.onView(withId(R.id.randomUserRv))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,click()))
    }
    @Test
    fun recyclerViewTestValueOnItem(){
        Espresso.onView(ViewMatchers.withId(R.id.randomUserRv))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5,click()))
        val nameItemGender: String = "female"
        Espresso.onView(withText(nameItemGender)).check(matches(isDisplayed()))
    }

    @Test
    fun countTotalNoOfItems(){
        var recyclerView:RecyclerView = activityRule.activity.findViewById(R.id.randomUserRv)
        var itemCount = recyclerView.adapter?.itemCount
        if (itemCount != null){
            Espresso.onView(withId(R.id.randomUserRv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemCount.minus(1)))
        }
    }

    @After
    fun tearDown() {
    }
}