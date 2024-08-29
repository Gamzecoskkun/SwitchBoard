package com.gamzecoskun.switchboard.ui.healthcontrol

import com.gamzecoskun.switchboard.R

enum class NavigationItem(
    val fragmentId: Int,
    val switchId: Int,
    val iconRes: Int
) {
    HEALTHCONTROL(R.id.healthControlFragment, R.id.healthControl, R.drawable.ic_home),
    MEALS(R.id.mealsFragment, R.id.meals, R.drawable.ic_cart),
    EXERCISE(R.id.exerciseFragment, R.id.exercise, R.drawable.ic_exercise),
    SLEEP(R.id.sleepFragment, R.id.sleep, R.drawable.ic_sleep),
    STEPS(R.id.stepsFragment, R.id.steps, R.drawable.ic_steps),
    HYDRATION(R.id.hydrationFragment, R.id.hydration, R.drawable.ic_hydration)
}
