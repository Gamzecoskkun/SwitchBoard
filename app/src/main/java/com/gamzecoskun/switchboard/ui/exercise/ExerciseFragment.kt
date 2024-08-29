package com.gamzecoskun.switchboard.ui.exercise


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamzecoskun.switchboard.common.viewBinding
import com.gamzecoskun.switchboard.databinding.FragmentExerciseBinding

class ExerciseFragment : Fragment() {

    private val binding by viewBinding (FragmentExerciseBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}