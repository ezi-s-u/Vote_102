package kr.hs.emirim.evie.vote_102

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "미피 선호도 투표"

        var voteCount = IntArray(9) // int[] voteCount = new int[9];

        // voteCount 초기화
        for(i in 0 .. 8)
            voteCount[i] = 0

        var imgV = arrayOfNulls<ImageView>(9)

        var imgVId = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9)

        var imgName = arrayOf("초록 미피", "만세 미피", "풍선 미피", "피리 미피", "점프 미피", "허그 미피", "엄마 미피", "고민 미피", "구름 미피")

        for(i in imgVId.indices) { // 0부터 끝까지 차례대로
            imgV[i] = findViewById(imgVId[i])
            imgV[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i]+" : "+voteCount[i]+"표", Toast.LENGTH_LONG).show()
            }
        }

        var btnResult = findViewById<Button>(R.id.btnResult)
        btnResult.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("voteCount", voteCount)
            intent.putExtra("imgName", imgName)
            startActivity(intent)
        }
    }
}