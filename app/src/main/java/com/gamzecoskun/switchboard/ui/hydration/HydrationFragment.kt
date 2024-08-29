package com.gamzecoskun.switchboard.ui.hydration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamzecoskun.switchboard.common.viewBinding
import com.gamzecoskun.switchboard.databinding.FragmentHydrationBinding

class HydrationFragment : Fragment() {

    private val binding by viewBinding(FragmentHydrationBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}