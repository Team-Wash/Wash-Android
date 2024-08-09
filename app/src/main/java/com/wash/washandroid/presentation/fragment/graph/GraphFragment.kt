package com.wash.washandroid.presentation.fragment.graph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wash.washandroid.R
import com.wash.washandroid.databinding.FragmentGraphBinding
import com.wash.washandroid.presentation.adapter.Problem
import com.wash.washandroid.presentation.adapter.ProblemImageAdapter
import com.wash.washandroid.presentation.adapter.Subject
import com.wash.washandroid.presentation.adapter.SubjectsAdapter

class GraphFragment : Fragment() {

    private var _binding: FragmentGraphBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGraphBinding.inflate(inflater, container, false)

        setupRecyclerViews()

        return binding.root
    }

    private fun setupRecyclerViews() {
        val subjects = listOf(
            Subject(1, "수학", "미적분"),
            Subject(2, "수학", "기하"),
            Subject(3, "영어", "토플")
        )
        val problems = listOf(
            Problem(1, "문제 1", R.drawable.temporary_img_test),
            Problem(2, "문제 2", R.drawable.temporary_img_test),
            Problem(3, "문제 3", R.drawable.temporary_img_test),
            Problem(4, "문제 4", R.drawable.temporary_img_test),
            Problem(5, "문제 5", R.drawable.temporary_img_test)
        )

        // SubjectsRecyclerView 설정
        val SJadapter = SubjectsAdapter(subjects) { subject ->
            // 네비게이션을 사용하여 ViewPieChartFragment로 이동
            findNavController().navigate(R.id.action_navigation_graph_to_viewPieChartFragment)
        }
        binding.subjectsRecyclerView.adapter = SJadapter

        // ProblemsRecyclerView 설정
        val PBadapter = ProblemImageAdapter(problems)
        binding.problemsRecyclerView.adapter = PBadapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
