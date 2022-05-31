package com.example.daniwebandroidvalidateintents

import android.content.Intent.ACTION_VIEW
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.*

import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun startCapturingIntent(){
        Intents.init()
    }

    @After
    fun clearIntentsState() {
        Intents.release()
    }

    @Test
    fun intentTest(){
        onView(withId(R.id.button_launchIntent))
            .perform(click())

        Intents.intended(allOf(
            hasAction(ACTION_VIEW),
            hasData(MainActivity.intentData)
        ))
    }

}