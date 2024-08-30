package com.gamzecoskun.switchboard.ui.meals

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamzecoskun.switchboard.R
import com.gamzecoskun.switchboard.common.viewBinding
import com.gamzecoskun.switchboard.databinding.FragmentMealsBinding

class MealsFragment : Fragment(R.layout.fragment_meals) {

    private val binding by viewBinding(FragmentMealsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}