package com.example.zancomusicplayer

import android.net.Uri


class Utils {
    companion object {
        val rawFolderPath = "android.resource://com.example.zancomusicplayer/"
    }

    enum class SongName {
        Masalan, BoroSamteAli, RadePaa, KhoshamMiad
    }

    enum class SongUri(var uri: Uri) {
        Masalan(Uri.parse(rawFolderPath + R.raw.masalan)),
        BoroSamteAli(Uri.parse(rawFolderPath + R.raw.boro_samte_ali)),
        RadePaa(Uri.parse(rawFolderPath + R.raw.radepaa)),
        KhoshamMiad(Uri.parse(rawFolderPath + R.raw.khosham_miyad)),

    }


}