package com.xanthenite.isining.composeapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xanthenite.isining.composeapp.component.bottombar.BottomBarHomeItem
import com.xanthenite.isining.composeapp.ui.screens.home.*

@Composable
fun MainNavGraph(navController : NavHostController)
{
    NavHost(
        navController = navController ,
        route = Graph.HOME,
        startDestination = BottomBarHomeItem.Home.route) {

        composable(route = BottomBarHomeItem.Home.route)
        {
            HomeScreen(
                viewModel = hiltViewModel(),
                onNavigateToAr = {}
            )
        }

        composable(route = BottomBarHomeItem.Exhibits.route) {
            ExhibitScreen(
                viewModel = hiltViewModel(),
                onNavigateToExhibitDetail = {/*TODO:Implement navigation to exhibit detail screen*/}
            )
        }

        composable(route = BottomBarHomeItem.Artworks.route) {
            ArtworkScreen(
                viewModel = hiltViewModel(),
                onNavigateToArtworkDetail = {/*TODO:Implement navigation to artwork detail screen*/}
            )
        }

        composable(route = BottomBarHomeItem.Artists.route) {
            ArtistScreen(
                viewModel = hiltViewModel(),
                onNavigateToArtistDetail = {/*TODO:Implement navigation to artist detail screen*/}
            )
        }

        composable(route = BottomBarHomeItem.Profile.route) {
            ProfileScreen(
                viewModel = hiltViewModel(),
                onNavigateToLogin = {
                    navController.popBackStack()
                    navController.navigate(Graph.AUTHENTICATION)
                },
                onAboutAppCLick = {},
                onTransactionClick = {},
                onManageProfileClick = {},
                onChangePasswordClick = {}
            )
        }

        authNavGraph(navController)

    }
}
