package com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity.databinding.FragmentAnnouncementDetailBinding

class AnnouncementDetailFragment : Fragment() {

    private var _binding: FragmentAnnouncementDetailBinding? = null
    private val binding get() = _binding!!

    // Menggunakan activityViewModels agar bisa mengakses data yang sama dengan HomeFragment
    private val viewModel: HomeViewModel by activityViewModels()

    // Mengambil argumen yang dikirim via Safe Args
    private val args: AnnouncementDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnnouncementDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val announcementId = args.announcementId

        // Mencari data pengumuman berdasarkan ID dari ViewModel
        viewModel.announcements.observe(viewLifecycleOwner) { list ->
            val announcement = list.find { it.id == announcementId }
            announcement?.let {
                binding.tvDetailTitle.text = it.title
                binding.tvDetailDate.text = "Tanggal: ${it.date}"
                binding.tvDetailCategory.text = it.category
                binding.tvDetailContent.text = it.content
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}