package com.example.eslami.ui.radio

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.eslami.R
import com.example.eslami.databinding.FragmentRadioBinding
import com.example.eslami.ui.radio.api.ApiManager
import com.example.eslami.ui.radio.model.Radio
import com.example.eslami.ui.radio.model.RadioList
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class radioFragment:Fragment (){
    lateinit var binding: FragmentRadioBinding
   var isStream:Boolean =false
    var mediaPlayer = MediaPlayer()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showVisibility(true)
        initApi()
       binding.tryagain.setOnClickListener{
           initApi()
       }
    }
fun showVisibility(isVisible:Boolean){
    binding.progressBar.isVisible=isVisible
}
    private fun initApi() {
        ApiManager.webService().getRadio().enqueue(
            object:Callback<RadioList> {
                override fun onResponse(call: Call<RadioList>, response: Response<RadioList>) {
                 if(response.isSuccessful){
                     showVisibility(false)
                     response.body()?.let { initRec(it.radios) }
                     Log.e("dd", "ok")
                     return
                 }
                    Log.e("dd", "error")
                    val responseJson = response.errorBody()?.string()
                    val errporResponse = Gson().fromJson(responseJson,RadioList::class.java)
                    changeErrors(errporResponse.toString())
                }

                override fun onFailure(call: Call<RadioList>, t: Throwable) {
                    Log.e("dd", t.message.toString())
                    changeErrors(t.message)
                    showVisibility(true)
                }


            },
        )
    }
    private fun changeErrors(message: String?) {
     binding.errorMessage.text = message
        binding.tryagain.isVisible = true
    }

    private var currentMediaItem: Radio? = null

    private fun initRec(radioList: List<Radio?>?) {
        binding.tryagain.isVisible = false
        binding.progressBar.isVisible = false
        val adapter = adapterRadio(radioList)
        binding.radioRv.adapter = adapter

        adapter.clickOfMusic = adapterRadio.clickMusic { position, item, toggle ->
            if (isStream) {
                if (mediaPlayer.isPlaying) {
                    toggle.setImageResource(R.drawable.start)
                    Log.e("dd", "pause music")
                    mediaPlayer.pause()
                    initApi()
                    Toast.makeText(context, "pause ${item.name}", Toast.LENGTH_SHORT).show()
                    // Clear the current media item when pausing
                    currentMediaItem = null
                } else {
                    toggle.setImageResource(R.drawable.sharp_autopause_24)
                    Log.e("dd", "play music")
                    Log.e("dd", item.url ?: "")
                    if (item != currentMediaItem) {
                        mediaPlayer.apply {
                            reset()
                            setAudioStreamType(AudioManager.STREAM_MUSIC)
                            setDataSource(item.url ?: "")
                            prepare()
                            setVolume(1f, 1f)
                            isLooping = false
                            start()
                            currentMediaItem = item
                            isStream = true
                            Toast.makeText(context, "play ${item.name}", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        mediaPlayer.start()
                    }
                }
            } else {
                mediaPlayer.apply {
                    reset()
                    setAudioStreamType(AudioManager.STREAM_MUSIC)
                    setDataSource(item.url ?: "")
                    prepare()
                    setVolume(1f, 1f)
                    isLooping = false
                    start()
                    currentMediaItem = item
                    isStream = true
                    toggle.setImageResource(R.drawable.sharp_autopause_24)
                    Toast.makeText(context, "play ${item.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }




}