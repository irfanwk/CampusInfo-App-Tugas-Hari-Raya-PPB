package com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity

data class Announcement(
    val id: Int,
    val title: String,
    val date: String,
    val category: String, // Akademik, Event, Beasiswa
    val content: String   // detail pengumuman
)