package com.example.socket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import main_fragment.*

class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // 하단 탭이 눌렸을 때 화면을 전환하기 위해선 이벤트 처리하기 위해 BottomNavigationView 객체 생성
        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView

        // OnNavigationItemSelectedListener를 통해 탭 아이템 선택 시 이벤트를 처리
        // navi_menu.xml 에서 설정했던 각 아이템들의 id를 통해 알맞은 프래그먼트로 변경하게 한다.
        bnv_main.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.first -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val homeFragment = homeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, homeFragment).commit()
                }
                R.id.second -> {
                    val boardFragment = boardFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, boardFragment).commit()
                }
                R.id.third -> {
                    val badgeFragment = badgeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, badgeFragment).commit()
                }
                R.id.fourth -> {
                    val youtubeFragment = youtubeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, youtubeFragment).commit()
                }
                R.id.fifth -> {
                    val cameraFragment = cameraFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, cameraFragment).commit()
                }
            }
            true
        }
            selectedItemId = R.id.first
        }
    }
}