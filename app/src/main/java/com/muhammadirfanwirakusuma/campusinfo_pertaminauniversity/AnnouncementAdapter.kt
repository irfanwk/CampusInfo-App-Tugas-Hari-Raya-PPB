package com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity.databinding.ItemAnnouncementBinding

// Menggunakan Lambda (Announcement) -> Unit untuk menangani klik sesuai PDF 2.2
class AnnouncementAdapter(private val onClick: (Announcement) -> Unit) :
    ListAdapter<Announcement, AnnouncementAdapter.AnnouncementViewHolder>(DiffCallback) {

    // ViewHolder menggunakan View Binding sesuai PDF 2.4
    class AnnouncementViewHolder(private val binding: ItemAnnouncementBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(announcement: Announcement, onClick: (Announcement) -> Unit) {
            binding.tvTitle.text = announcement.title
            binding.tvDate.text = announcement.date
            binding.tvCategory.text = announcement.category

            // Set klik pada seluruh area item
            binding.root.setOnClickListener { onClick(announcement) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementViewHolder {
        val binding = ItemAnnouncementBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AnnouncementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnnouncementViewHolder, position: Int) {
        val announcement = getItem(position)
        holder.bind(announcement, onClick)
    }

    // Implementasi DiffUtil sesuai PDF 2.2
    object DiffCallback : DiffUtil.ItemCallback<Announcement>() {
        override fun areItemsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
            return oldItem == newItem
        }
    }
}