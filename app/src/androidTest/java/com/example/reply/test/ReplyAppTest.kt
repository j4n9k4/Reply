package com.example.reply.test

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.reply.ui.ReplyApp
import org.junit.Rule
import org.junit.Test
import com.example.reply.R

class ReplyAppTest {
    @get:Rule
    val composeTestRule =  createAndroidComposeRule<ComponentActivity>()

    @Test
    @TestCompactWidth
    fun compactDevice_verifyingUsingBottomNavigation()
    {
        composeTestRule.setContent {
            ReplyApp(WindowWidthSizeClass.Compact)
        }

        composeTestRule.onNodeWithTagForStringId(
            R.string.navigation_bottom
        ).assertExists()
    }

    @Test
    @TestMediumWidth
    fun mediumDevice_verifyingUsingNavigationRail()
    {
        composeTestRule.setContent {
            ReplyApp(WindowWidthSizeClass.Medium)
        }
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_rail).assertExists()
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_verifyingUsingNavigationDrawer()
    {
        composeTestRule.setContent {
            ReplyApp(WindowWidthSizeClass.Expanded)
        }

        composeTestRule.onNodeWithTagForStringId(R.string.navigation_drawer).assertExists()
    }
}