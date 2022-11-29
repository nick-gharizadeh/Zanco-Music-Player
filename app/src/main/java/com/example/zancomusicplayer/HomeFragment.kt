package com.example.zancomusicplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.zancomusicplayer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cvMasalan.setOnClickListener {
            homeViewModel.setVisible(binding.cvControl)
            homeViewModel.playMusic(Utils.Song.Masalan)
            binding.imageViewMasalan.matchSrc(binding.imageViewSong)
        }
        binding.cvBoroSamteAli.setOnClickListener {
            homeViewModel.setVisible(binding.cvControl)
            homeViewModel.playMusic(Utils.Song.BoroSamteAli)
            binding.imageViewBoroSamteAli.matchSrc(binding.imageViewSong)

        }
        binding.cvRadePaa.setOnClickListener {
            homeViewModel.setVisible(binding.cvControl)
            homeViewModel.playMusic(Utils.Song.RadePaa)
            binding.imageViewRadePaa.matchSrc(binding.imageViewSong)

        }
        binding.cvKhoshamMiad.setOnClickListener {
            homeViewModel.setVisible(binding.cvControl)
            homeViewModel.playMusic(Utils.Song.KhoshamMiad)
            binding.imageViewKhoshamMiad.matchSrc(binding.imageViewSong)

        }
        binding.imageViewPause.setOnClickListener {
            homeViewModel.pausePlaying()
        }
        binding.imageViewPlay.setOnClickListener {
            homeViewModel.startPlaying()
        }
        binding.imageViewStop.setOnClickListener {
            homeViewModel.stopPlaying()
            homeViewModel.setInvisible(binding.cvControl)
        }
        homeViewModel.songName.observe(viewLifecycleOwner) {
            binding.textViewSongName.text = it
        }
        homeViewModel.mMediaPlayer.setOnCompletionListener {
            homeViewModel.stopPlaying()
            homeViewModel.setInvisible(binding.cvControl)
        }

    }


}