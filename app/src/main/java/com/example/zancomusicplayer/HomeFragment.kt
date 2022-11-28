package com.example.zancomusicplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.zancomusicplayer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cvMasalan.setOnClickListener {
            homeViewModel.playMusic(Utils.SongName.Masalan)
        }
        binding.cvBoroSamteAli.setOnClickListener {
            homeViewModel.playMusic(Utils.SongName.BoroSamteAli)
        }
        binding.cvRadePaa.setOnClickListener {
            homeViewModel.playMusic(Utils.SongName.RadePaa)
        }
        binding.cvKhoshamMiad.setOnClickListener {
            homeViewModel.playMusic(Utils.SongName.KhoshamMiad)
        }

    }


}