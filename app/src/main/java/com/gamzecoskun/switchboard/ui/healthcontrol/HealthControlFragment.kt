package com.gamzecoskun.switchboard.ui.healthcontrol

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.gamzecoskun.switchboard.R
import com.gamzecoskun.switchboard.common.viewBinding
import com.gamzecoskun.switchboard.databinding.FragmentHealthControlBinding

class HealthControlFragment : Fragment(R.layout.fragment_health_control) {

    private val binding by viewBinding(FragmentHealthControlBinding::bind)
    private val viewModel: HealthControlViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSwitches()

        viewModel.healthControlChecked.observe(viewLifecycleOwner) { isChecked ->
            binding.healthControl.isChecked = isChecked
            setSwitchesEnabled(!isChecked)
        }

        viewModel.hydrationChecked.observe(viewLifecycleOwner) { isChecked ->
            binding.hydration.isChecked = isChecked
        }

        viewModel.exerciseChecked.observe(viewLifecycleOwner) { isChecked ->
            binding.exercise.isChecked = isChecked
        }

        viewModel.sleepChecked.observe(viewLifecycleOwner) { isChecked ->
            binding.sleep.isChecked = isChecked
        }

        viewModel.stepsChecked.observe(viewLifecycleOwner) { isChecked ->
            binding.steps.isChecked = isChecked
        }

        viewModel.mealsChecked.observe(viewLifecycleOwner) { isChecked ->
            binding.meals.isChecked = isChecked
        }

        binding.healthControl.apply {
            isChecked = viewModel.healthControlChecked.value ?: true
            setOnCheckedChangeListener { _, isChecked ->
                setSwitchesEnabled(!isChecked)
                viewModel.updateAddedItemsOrder(R.id.healthControl, isChecked)
            }
            setSwitchesEnabled(!(viewModel.healthControlChecked.value ?: true))
        }
    }

    private fun setSwitchesEnabled(isEnabled: Boolean) {
        with(binding) {
            listOf(hydration, steps, sleep, exercise, meals).forEach {
                it.isEnabled = isEnabled

            }
        }
    }

    private fun setupSwitches() {
        binding.hydration.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateAddedItemsOrder(R.id.hydration, isChecked)
        }

        binding.exercise.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateAddedItemsOrder(R.id.exercise, isChecked)
        }

        binding.sleep.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateAddedItemsOrder(R.id.sleep, isChecked)
        }

        binding.steps.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateAddedItemsOrder(R.id.steps, isChecked)
        }

        binding.meals.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateAddedItemsOrder(R.id.meals, isChecked)
        }

        binding.healthControl.setOnCheckedChangeListener { _, isChecked ->
            setSwitchesEnabled(!isChecked)
            viewModel.updateAddedItemsOrder(R.id.healthControl, isChecked)
        }
    }
}

