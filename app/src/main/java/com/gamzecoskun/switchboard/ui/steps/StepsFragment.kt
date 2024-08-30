package com.gamzecoskun.switchboard.ui.steps

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamzecoskun.switchboard.R
import com.gamzecoskun.switchboard.common.viewBinding
import com.gamzecoskun.switchboard.databinding.FragmentStepsBinding

class StepsFragment : Fragment(R.layout.fragment_steps) {
    private val binding by viewBinding (FragmentStepsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}