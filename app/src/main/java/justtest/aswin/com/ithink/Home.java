package justtest.aswin.com.ithink;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    static int myNo,guessNo,tri;
    EditText guessGet;
    AlertDialog.Builder alert;
    Button mainBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tri=0;
        myNo=(int) (Math.random()*10);
        alert=new AlertDialog.Builder(this);
        guessGet=(EditText) findViewById(R.id.enter_option);
        mainBut=(Button) findViewById(R.id.button);
    }
    public void checkGuess(View view){
        String got=guessGet.getText().toString().trim();
        if(!got.isEmpty()){
            guessNo=Integer.parseInt(got);
            if(myNo==guessNo){
                if(tri==0)
                {
                    alert.setTitle("Result").setMessage("Brilliant! You took "+tri+" tries")
                            .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            guessGet.setText("");
                        }
                    }).show();
                }
                else
                {
                    alert.setTitle("Result").setMessage("Congratulations! You took "+tri+" tries")
                            .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            guessGet.setText("");
                        }
                    }).show();
                }
                mainBut.setVisibility(View.INVISIBLE);
            }
            else {
                alert.setTitle("Result").setMessage("Sorry! Wrong Answer")
                        .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                tri++;
            }
        }
        else {
            Toast.makeText(this,"Enter option",Toast.LENGTH_LONG).show();
        }
    }
    public void newTry(View view){
        guessGet.setText("");
        myNo=(int) (Math.random()*10);
        tri=0;
        Toast.makeText(this,"I thought a New Number",Toast.LENGTH_LONG).show();
        mainBut.setVisibility(View.VISIBLE);
    }
}