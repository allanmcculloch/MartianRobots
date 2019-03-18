package com.allanmcculloch.martianrobots

import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.allanmcculloch.martianrobots.screens.MainActivityScreen
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MartianRobotsTest {
    val mainActivityScreen = MainActivityScreen()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.allanmcculloch.martianrobots", appContext.packageName)
    }

    @Test
    fun processSampleInputAndCheckOutput() {
        mainActivityScreen.clearCommands()
        mainActivityScreen.enterCommand(testData)
        mainActivityScreen.closeKeyboard()
        mainActivityScreen.clickCommandButton()
        mainActivityScreen.checkResultTextHasValue(expectedOutput)
    }

    @Test
    fun badCommandShowsError() {
        mainActivityScreen.clearCommands()
        mainActivityScreen.enterCommand(badCommand)
        mainActivityScreen.closeKeyboard()
        mainActivityScreen.clickCommandButton()
        mainActivityScreen.checkResultTextHasValue(invalidCommandError)
    }

    @Test
    fun coordinateHigherThan50ShowsError() {
        mainActivityScreen.clearCommands()
        mainActivityScreen.enterCommand(commandWithTooHighCoordinate)
        mainActivityScreen.closeKeyboard()
        mainActivityScreen.clickCommandButton()
        mainActivityScreen.checkResultTextHasValue(tooLargeCoordinateError)
    }

    @Test
    fun commandMoreThan100CharactersShowsError() {
        mainActivityScreen.clearCommands()
        mainActivityScreen.enterCommand(commandMoreThan100Characters)
        mainActivityScreen.closeKeyboard()
        mainActivityScreen.clickCommandButton()
        mainActivityScreen.checkResultTextHasValue(tooLongCommmandError)
    }

    val testData ="""5 3
1 1 E
RFRFRFRF

3 2 N
FRRFLLFFRRFLL

0 3 W
LLFFFLFLFL
"""

    val expectedOutput ="""1 1 E
3 3 N LOST
2 3 S
"""

    val badCommand = "BADCOMMAND"
    val commandWithTooHighCoordinate = "5 3\n99 1 E"
    val commandMoreThan100Characters = "sadfasdfhadsjkfhasdfjkshdfjkahsdfjkhsdfjweurfhafnasidnviosdfsgdsfgdfsadnvsadfasdfisadjfsjdfoijsdfijsdfoisajdfojaisdfadosfijifj"
    val tooLargeCoordinateError = "Failed at line 2 - The value for any co-ordinate cannot be higher than 50"
    val invalidCommandError = "Failed at line 1 - For input string: \"BADCOMMAND\""
    val tooLongCommmandError = "Failed at line 1 - Command length more than 100 characters"
}
