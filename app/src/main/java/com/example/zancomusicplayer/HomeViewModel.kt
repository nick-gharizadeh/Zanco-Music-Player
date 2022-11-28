package com.example.zancomusicplayer

import android.app.Application
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.AndroidViewModel


class HomeViewModel(var app: Application) : AndroidViewModel(app) {

    var mMediaPlayer: MediaPlayer = MediaPlayer()


    fun playMusic(songName: Utils.SongName) {
        when (songName) {

            Utils.SongName.Masalan -> {
                makeMediaPlayerReadyForPlaying(Utils.SongUri.Masalan.uri)
            }
            Utils.SongName.BoroSamteAli -> {
                makeMediaPlayerReadyForPlaying(Utils.SongUri.BoroSamteAli.uri)
            }
            Utils.SongName.RadePaa -> {
                makeMediaPlayerReadyForPlaying(Utils.SongUri.RadePaa.uri)
            }
            Utils.SongName.KhoshamMiad -> {
                makeMediaPlayerReadyForPlaying(Utils.SongUri.KhoshamMiad.uri)
            }
        }
    }

    fun makeMediaPlayerReadyForPlaying(uri: Uri) {
        if (mMediaPlayer.isPlaying) {
            mMediaPlayer.stop()
            mMediaPlayer.reset()
        }
        try {
            mMediaPlayer.setDataSource(
                app.applicationContext,
                uri
            )
            mMediaPlayer.prepare()
            mMediaPlayer.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}