package com.allanmcculloch.martianrobots.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.allanmcculloch.martianrobots.R
import com.allanmcculloch.martianrobots.extensions.checkHasText
import com.allanmcculloch.martianrobots.extensions.clearText
import com.allanmcculloch.martianrobots.extensions.click
import com.allanmcculloch.martianrobots.extensions.typeText

class MainActivityScreen {
    val commandText = R.id.commandsText
    val commandButton = R.id.commandButton
    val resultText = R.id.resultText

    fun checkResultTextHasValue(text : String) {
        resultText.checkHasText(text)
    }

    fun clearCommands() {
        commandText.clearText()
    }

    fun enterCommand(command : String) {
        commandText.typeText(command)
    }

    fun clickCommandButton() {
        commandButton.click()
    }

    fun closeKeyboard(){
        Espresso.onView(ViewMatchers.withId(R.id.commandsText)).perform(ViewActions.closeSoftKeyboard())
    }
}