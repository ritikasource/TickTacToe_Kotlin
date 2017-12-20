package megha.ticktacktoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var player1=ArrayList<Int>()
    var player2= ArrayList<Int>()
    var curPlayer=1

    fun onBtnClick(view : View){
        val btnSelected=view as Button
        var cellId=0
        when(btnSelected.id){
            R.id.b1->cellId=1
            R.id.b2->cellId=2
            R.id.b3->cellId=3
            R.id.b4->cellId=4
            R.id.b5->cellId=5
            R.id.b6->cellId=6
            R.id.b7->cellId=7
            R.id.b8->cellId=8
            R.id.b9->cellId=9
        }
         play(cellId,btnSelected)
    }

    fun play(cellIndex:Int,btnSelected:Button){
        if(curPlayer==1){
            btnSelected.text="X"
            btnSelected.textSize="20".toFloat()
            btnSelected.setBackgroundColor(Color.YELLOW)
            player1.add(cellIndex)
            curPlayer=2
        }
        else{
            btnSelected.text="O"
            btnSelected.textSize="20".toFloat()
            btnSelected.setBackgroundColor(Color.GREEN)
            player2.add(cellIndex)
            curPlayer=1
        }
        btnSelected.isEnabled=false
        checkWinner(btnSelected)
    }

    fun checkWinner(button: Button) {
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            button.isSelected=false
            winner = 2
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {

            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if(winner!=-1){
            if(winner==1){
                button.isEnabled=false
                Toast.makeText(this,"player 1 wins the game",Toast.LENGTH_LONG).show()
            }
            else if(winner==2){
                button.isEnabled=false
                Toast.makeText(this,"player 2 wins the game",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"this is a draw",Toast.LENGTH_LONG).show()
            }
        }

    }
}
