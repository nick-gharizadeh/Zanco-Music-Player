package com.example.zancomusicplayer

import android.app.Application
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class HomeViewModel(var app: Application) : AndroidViewModel(app) {

    var mMediaPlayer: MediaPlayer = MediaPlayer()
    var timeThatPaused = 0
    var songName = MutableLiveData<String>()
    var isPaused = false


    fun playMusic(song: Utils.Song) {
        when (song) {
            Utils.Song.Masalan -> {
                makeMediaPlayerReadyForPlaying(Utils.SongUri.Masalan.uri)
                songName.value = Utils.SongName.Masalan.songName
            }
            Utils.Song.BoroSamteAli -> {
                makeMediaPlayerReadyForPlaying(Utils.SongUri.BoroSamteAli.uri)
                songName.value = Utils.SongName.BoroSamteAli.songName
            }
            Utils.Song.RadePaa -> {
                makeMediaPlayerReadyForPlaying(Utils.SongUri.RadePaa.uri)
                songName.value = Utils.SongName.RadePaa.songName
            }
            Utils.Song.KhoshamMiad -> {
                makeMediaPlayerReadyForPlaying(Utils.SongUri.KhoshamMiad.uri)
                songName.value = Utils.SongName.KhoshamMiad.songName
            }
        }
    }

    fun makeMediaPlayerReadyForPlaying(uri: Uri) {
        if (mMediaPlayer.isPlaying or isPaused) {
            stopPlaying()
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

    fun pausePlaying() {
        mMediaPlayer.pause()
        isPaused = true
        timeThatPaused = mMediaPlayer.currentPosition
    }

    fun startPlaying(): Boolean {
        if (isPaused) {
            mMediaPlayer.seekTo(timeThatPaused)
            mMediaPlayer.start()
            return true
        }
        return false
    }

    fun stopPlaying() {
        isPaused = false
        mMediaPlayer.stop()
        mMediaPlayer.reset()
    }


}