package main_fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.annotation.RequiresApi

import com.example.socket.R


import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions

import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import java.net.URISyntaxException


class cameraFragment : Fragment() {

    lateinit var mSocket: Socket


    val onConnect = Emitter.Listener {
        mSocket.emit("connectReceive", "hihi")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


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
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }


    fun init(){
         val send_button:Button=requireView().findViewById(R.id.sendbutton)

        send_button.setOnClickListener{
            val s1:EditText=requireView().findViewById(R.id.edittext)
            var msg=s1.text.toString()
            var s2=1
            val s=object{ val 감자="1"
                val 나이="2"}
            mSocket.emit("connectReceive",msg)
            mSocket.emit("connectReceive",s1)

        }

    }

}