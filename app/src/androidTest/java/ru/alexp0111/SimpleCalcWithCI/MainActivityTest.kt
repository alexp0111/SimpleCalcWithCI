package ru.alexp0111.SimpleCalcWithCI

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @JvmField
    @Rule
    val mActivityRule = ActivityTestRule(
        MainActivity::class.java,
        true,
        false,
    )

    @Before
    fun setUp() {
        // Before actions
    }

    @Test
    fun shouldSumToValues() {
        mActivityRule.launchActivity(null)
        onView(withId(R.id.et_first_value)).perform(typeText("60"))
        onView(withId(R.id.et_second_value)).perform(typeText("9"))
        onView(withId(R.id.btn_find_sum)).perform(click())
        onView(withId(R.id.txt_result)).check(matches(withText("69.0")))
    }
}