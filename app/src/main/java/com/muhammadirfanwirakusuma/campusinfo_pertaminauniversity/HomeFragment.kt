package com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // Inisialisasi View Binding dengan null-safe
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Inisialisasi ViewModel
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Adapter dengan Lambda Click Listener
        val adapter = AnnouncementAdapter { announcement ->
            // Navigasi ke Detail menggunakan Safe Args sesuai PDF 2.3
            val action = HomeFragmentDirections
                .actionHomeFragmentToAnnouncementDetailFragment(announcement.id)
            findNavController().navigate(action)
        }

        // Setup RecyclerView
        binding.rvAnnouncements.layoutManager = LinearLayoutManager(context)
        binding.rvAnnouncements.adapter = adapter

        // Observasi data dari ViewModel
        viewModel.announcements.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    // Menghindari Memory Leak
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}