package com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    // Menggunakan LiveData agar Fragment bisa memantau perubahan data
    private val _announcements = MutableLiveData<List<Announcement>>()
    val announcements: LiveData<List<Announcement>> = _announcements

    init {
        loadDummyData()
    }

    private fun loadDummyData() {
        val list = listOf(
            Announcement(1, "Pendaftaran Wisuda Ke-10", "20 Maret 2026", "Akademik", "Segera daftarkan diri Anda untuk wisuda periode Mei..."),
            Announcement(2, "Lomba Inovasi Teknologi", "22 Maret 2026", "Event", "Tunjukkan karya terbaikmu di ajang tahunan UP..."),
            Announcement(3, "Beasiswa Prestasi Semester Genap", "25 Maret 2026", "Beasiswa", "Dibuka pendaftaran beasiswa bagi mahasiswa dengan IPK > 3.5..."),
            Announcement(4, "Libur Idul Fitri 1446 H", "27 Maret 2026", "Umum", "Sesuai kalender akademik, perkuliahan diliburkan mulai..."),
            Announcement(5, "Workshop UI/UX Design", "30 Maret 2026", "Event", "Belajar desain aplikasi modern bersama praktisi industri...")
        )
        _announcements.value = list
    }
}