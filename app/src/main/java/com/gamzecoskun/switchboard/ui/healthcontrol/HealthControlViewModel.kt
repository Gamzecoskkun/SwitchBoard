package com.gamzecoskun.switchboard.ui.healthcontrol

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gamzecoskun.switchboard.R

/***
 * Created on 28.08.2024
 *@author Gamze Coşkun
 */
class HealthControlViewModel : ViewModel() {

    private val _addedItemsOrder = MutableLiveData<List<NavigationItem>>(emptyList())
    val addedItemsOrder: LiveData<List<NavigationItem>> get() = _addedItemsOrder

    private val _healthControlChecked = MutableLiveData<Boolean>(true)
    val healthControlChecked: LiveData<Boolean> get() = _healthControlChecked

    fun updateAddedItemsOrder(switchId: Int, isChecked: Boolean) {
        val currentOrder = _addedItemsOrder.value?.toMutableList() ?: mutableListOf()

        if (switchId == R.id.healthControl) {
            _healthControlChecked.value = isChecked
            if (isChecked) {
                resetAddedItemsOrder()
                _addedItemsOrder.value = emptyList()
            }
        } else {
            val item = when (switchId) {
                R.id.meals -> NavigationItem.MEALS
                R.id.exercise -> NavigationItem.EXERCISE
                R.id.sleep -> NavigationItem.SLEEP
                R.id.steps -> NavigationItem.STEPS
                R.id.hydration -> NavigationItem.HYDRATION
                else -> null
            }

            if (item != null) {
                if (isChecked) {
                    currentOrder.add(item)
                } else {
                    currentOrder.remove(item)
                }
                _addedItemsOrder.value = currentOrder
            }
        }
    }

    private fun resetAddedItemsOrder() {
        _addedItemsOrder.value = emptyList()
    }
}

