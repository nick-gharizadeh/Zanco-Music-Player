package com.example.zancomusicplayer

import android.app.Application
import android.media.MediaPlayer
import android.net.Uri
import android.view.View
import androidx.lifecycle.AndroidViewModel


class HomeViewModel(var app: Application) : AndroidViewModel(app) {

    var mMediaPlayer: MediaPlayer = MediaPlayer()
    var timeThatPaused = 0


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

    fun pausePlaying() {
        mMediaPlayer.pause()
        timeThatPaused = mMediaPlayer.currentPosition
    }

    fun startPlaying() {
        mMediaPlayer.seekTo(timeThatPaused)
        mMediaPlayer.start()
    }

    fun stopPlaying(){
        mMediaPlayer.stop()
        mMediaPlayer.reset()
    }

    fun setVisible(view: View) {
        view.visibility = View.VISIBLE
    }

    fun setInvisible(view: View) {
        view.visibility = View.INVISIBLE
    }


}