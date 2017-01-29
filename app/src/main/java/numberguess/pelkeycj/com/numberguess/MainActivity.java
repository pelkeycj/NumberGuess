package numberguess.pelkeycj.com.numberguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random ran = new Random();
    int targetNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTargetNumber();
    }

    public void onGuessClicked(View v) {
        EditText guess = (EditText) findViewById(R.id.guessEdit);
        int guessNum = Integer.parseInt(guess.getText().toString()); // users guessed num

        Log.i("INFO", "Guess=" + guessNum);

        if (guessNum == this.targetNumber) {
            Toast.makeText(this, "Correct! Try again.", Toast.LENGTH_SHORT).show();
            setTargetNumber();
        }
        else if (guessNum < this.targetNumber) {
            Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show();
        }

    }

    public void setTargetNumber() {
        this.targetNumber = ran.nextInt(20) + 1;
        Log.i("INFO", "Target=" + this.targetNumber);
    }
}
