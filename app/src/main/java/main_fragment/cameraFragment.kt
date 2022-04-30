package main_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.socket.R

import com.example.socket.databinding.FragmentCameraBinding
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import java.net.URISyntaxException


class cameraFragment : Fragment() {

    lateinit var mSocket: Socket
    lateinit var binding: FragmentCameraBinding
    val onConnect = Emitter.Listener {
        mSocket.emit("connectReceive", "hihi")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentCameraBinding.inflate(layoutInflater,container,false)
        try {

            mSocket = IO.socket("http://192.168.56.1:8080")
            mSocket.connect()
            print ("연결")
            Log.d("Connected", "OK12")

        } catch (e: URISyntaxException) {
            Log.d("ERR", e.toString())
        }
        mSocket.on(Socket.EVENT_CONNECT, onConnect)
        init()
        return binding!!.root
    }


    fun init(){
        binding.sendbutton.setOnClickListener{
            var msg=binding.edittext.text.toString()
            var s1=1
            val s=object{ val 감자="1"
                val 나이="2"}
            mSocket.emit("connectReceive",msg)
            mSocket.emit("connectReceive",s1)

        }
    }

}