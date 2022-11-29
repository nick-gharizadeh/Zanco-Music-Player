package com.example.zancomusicplayer

import android.net.Uri


class Utils {
    companion object {
        val rawFolderPath = "android.resource://com.example.zancomusicplayer/"
    }

    enum class Song {
        Masalan, BoroSamteAli, RadePaa, KhoshamMiad
    }

    enum class SongUri(var uri: Uri) {
        Masalan(Uri.parse(rawFolderPath + R.raw.masalan)), BoroSamteAli(Uri.parse(rawFolderPath + R.raw.boro_samte_ali)), RadePaa(
            Uri.parse(rawFolderPath + R.raw.radepaa)
        ),
        KhoshamMiad(Uri.parse(rawFolderPath + R.raw.khosham_miyad)),

    }

    enum class SongName(var songName: String) {
        Masalan(App.resourses.getString(R.string.masalan_song_name)), BoroSamteAli(
            App.resourses.getString(
                R.string.boro_samte_ali_song_name
            )
        ),
        RadePaa(App.resourses.getString(R.string.rade_paa_song_name)), KhoshamMiad(
            App.resourses.getString(
                R.string.khosham_miad_song_name
            )
        )
    }

}