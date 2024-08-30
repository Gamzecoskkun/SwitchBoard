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

    private val _hydrationChecked = MutableLiveData<Boolean>(false)
    val hydrationChecked: LiveData<Boolean> get() = _hydrationChecked

    private val _exerciseChecked = MutableLiveData<Boolean>(false)
    val exerciseChecked: LiveData<Boolean> get() = _exerciseChecked

    private val _sleepChecked = MutableLiveData<Boolean>(false)
    val sleepChecked: LiveData<Boolean> get() = _sleepChecked

    private val _stepsChecked = MutableLiveData<Boolean>(false)
    val stepsChecked: LiveData<Boolean> get() = _stepsChecked

    private val _mealsChecked = MutableLiveData<Boolean>(false)
    val mealsChecked: LiveData<Boolean> get() = _mealsChecked

    fun updateAddedItemsOrder(switchId: Int, isChecked: Boolean) {
        val currentOrder = _addedItemsOrder.value?.toMutableList() ?: mutableListOf()

        val previousOrder = currentOrder.toList()

        when (switchId) {
            R.id.healthControl -> {
                _healthControlChecked.value = isChecked
                if (isChecked) {
                    resetAddedItemsOrder()
                }else{
                    resetAddedItemsOrder()
                    clearAllSwitch()
                }
            }
            R.id.hydration -> _hydrationChecked.value = isChecked
            R.id.exercise -> _exerciseChecked.value = isChecked
            R.id.sleep -> _sleepChecked.value = isChecked
            R.id.steps -> _stepsChecked.value = isChecked
            R.id.meals -> _mealsChecked.value = isChecked
        }

        val item = getNavigationItemForSwitch(switchId)
        if (item != null) {
            if (isChecked && !currentOrder.contains(item)) {
                currentOrder.add(item)
            } else if (!isChecked && currentOrder.contains(item)) {
                currentOrder.remove(item)
            }
        }

        if (currentOrder != previousOrder) {
            _addedItemsOrder.value = currentOrder
        }
    }
    private fun getNavigationItemForSwitch(switchId: Int): NavigationItem? {
        return when (switchId) {
            R.id.meals -> NavigationItem.MEALS
            R.id.exercise -> NavigationItem.EXERCISE
            R.id.sleep -> NavigationItem.SLEEP
            R.id.steps -> NavigationItem.STEPS
            R.id.hydration -> NavigationItem.HYDRATION
            else -> null
        }
    }

    private fun resetAddedItemsOrder() {
        _addedItemsOrder.value = emptyList()
    }

    private fun clearAllSwitch(){
       _hydrationChecked.value=false
        _stepsChecked.value=false
        _sleepChecked.value=false
        _mealsChecked.value=false
        _exerciseChecked.value=false
    }
}


