package numberguess.pelkeycj.com.numberguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
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

        // clear text
        guess.setText("");

        Log.i("INFO", "Guess=" + guessNum);

        if (guessNum == this.targetNumber) {
            this.giveFeedback("Correct! Try again.");
            setTargetNumber();
        }
        else if (guessNum < this.targetNumber) {
            this.giveFeedback("Higher");
        }
        else {
            this.giveFeedback("Lower");
        }

    }

    public void giveFeedback(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void setTargetNumber() {
        Random ran = new Random();
        this.targetNumber = ran.nextInt(20) + 1;
        Log.i("INFO", "Target=" + this.targetNumber);
    }
}
