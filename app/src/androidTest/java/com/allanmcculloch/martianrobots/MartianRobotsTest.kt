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
        with(mainActivityScreen) {
            clearCommands()
            enterCommand(testData)
            closeKeyboard()
            clickCommandButton()
            checkResultTextHasValue(expectedOutput)
        }
    }

    @Test
    fun badCommandShowsError() {
        with(mainActivityScreen) {
            clearCommands()
            enterCommand(badCommand)
            closeKeyboard()
            clickCommandButton()
            checkResultTextHasValue(invalidCommandError)
        }
    }

    @Test
    fun coordinateHigherThan50ShowsError() {
        with(mainActivityScreen) {
            clearCommands()
            enterCommand(commandWithTooHighCoordinate)
            closeKeyboard()
            clickCommandButton()
            checkResultTextHasValue(tooLargeCoordinateError)
        }
    }

    @Test
    fun commandMoreThan100CharactersShowsError() {
        with(mainActivityScreen) {
            clearCommands()
            enterCommand(commandMoreThan100Characters)
            closeKeyboard()
            clickCommandButton()
            checkResultTextHasValue(tooLongCommmandError)
        }
    }

    private val testData ="""5 3
1 1 E
RFRFRFRF

3 2 N
FRRFLLFFRRFLL

0 3 W
LLFFFLFLFL
"""

    private val expectedOutput ="""1 1 E
3 3 N LOST
2 3 S
"""

    private val badCommand = "BADCOMMAND"
    private val commandWithTooHighCoordinate = "5 3\n99 1 E"
    private val commandMoreThan100Characters = "sadfasdfhadsjkfhasdfjkshdfjkahsdfjkhsdfjweurfhafnasidnviosdfsgdsfgdfsadnvsadfasdfisadjfsjdfoijsdfijsdfoisajdfojaisdfadosfijifj"
    private val tooLargeCoordinateError = "Failed at line 2 - The value for any co-ordinate cannot be higher than 50 or lower than 0"
    private val invalidCommandError = "Failed at line 1 - For input string: \"BADCOMMAND\""
    private val tooLongCommmandError = "Failed at line 1 - Command length more than 100 characters"
}
