package com.example.zancomusicplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieAnimationView
import com.example.zancomusicplayer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private var tempEqualizer: LottieAnimationView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cvMasalan.setOnClickListener {
            setActiveEqualizerInvisible()
            setVisible(binding.cvControl, binding.animationViewMasalan)
            homeViewModel.playMusic(Utils.Song.Masalan)
            binding.imageViewMasalan.matchSrc(binding.imageViewSong)
        }
        binding.cvBoroSamteAli.setOnClickListener {
            setActiveEqualizerInvisible()
            setVisible(binding.cvControl, binding.animationViewBoroSamteAli)
            homeViewModel.playMusic(Utils.Song.BoroSamteAli)
            binding.imageViewBoroSamteAli.matchSrc(binding.imageViewSong)

        }
        binding.cvRadePaa.setOnClickListener {
            setActiveEqualizerInvisible()
            setVisible(binding.cvControl, binding.animationViewRadePaa)
            homeViewModel.playMusic(Utils.Song.RadePaa)
            binding.imageViewRadePaa.matchSrc(binding.imageViewSong)

        }
        binding.cvKhoshamMiad.setOnClickListener {
            setActiveEqualizerInvisible()
            setVisible(binding.cvControl, binding.animationViewKhoshamMiad)
            homeViewModel.playMusic(Utils.Song.KhoshamMiad)
            binding.imageViewKhoshamMiad.matchSrc(binding.imageViewSong)

        }
        binding.imageViewPause.setOnClickListener {
            homeViewModel.pausePlaying()
            setActiveEqualizerInvisible()
        }

        binding.imageViewPlay.setOnClickListener {
            if (homeViewModel.startPlaying())
                tempEqualizer?.let { equalizer -> setVisible(equalizer) }
        }
        binding.imageViewStop.setOnClickListener {
            homeViewModel.stopPlaying()
            setInvisible(binding.cvControl)
            setActiveEqualizerInvisible()
        }
        homeViewModel.songName.observe(viewLifecycleOwner) {
            binding.textViewSongName.text = it
        }
        homeViewModel.mMediaPlayer.setOnCompletionListener {
            homeViewModel.stopPlaying()
            setInvisible(binding.cvControl)
            setActiveEqualizerInvisible()
        }

    }

    private fun setVisible(vararg viewItems: View) {
        for (view in viewItems)
            view.visibility = View.VISIBLE
    }

    private fun setInvisible(vararg viewItems: View) {
        for (view in viewItems)
            view.visibility = View.INVISIBLE
    }

    private fun setActiveEqualizerInvisible() {
        val equalizerList = listOf(
            binding.animationViewMasalan,
            binding.animationViewBoroSamteAli,
            binding.animationViewRadePaa,
            binding.animationViewKhoshamMiad
        )
        for (equalizer in equalizerList)
            if (equalizer.visibility == View.VISIBLE) {
                tempEqualizer = equalizer
                tempEqualizer?.let { it -> setInvisible(it) }
            }

    }
}