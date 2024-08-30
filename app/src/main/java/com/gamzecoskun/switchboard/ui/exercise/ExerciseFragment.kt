package com.gamzecoskun.switchboard.ui.exercise


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamzecoskun.switchboard.R
import com.gamzecoskun.switchboard.common.viewBinding
import com.gamzecoskun.switchboard.databinding.FragmentExerciseBinding

class ExerciseFragment : Fragment(R.layout.fragment_exercise) {

    private val binding by viewBinding (FragmentExerciseBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}