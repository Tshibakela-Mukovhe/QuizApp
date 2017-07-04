package com.tshibakela.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import static com.tshibakela.quizapp.Main2Activity.Mycell;
import static com.tshibakela.quizapp.Main2Activity.Myid;
import static com.tshibakela.quizapp.Main2Activity.Myname;
import static com.tshibakela.quizapp.Main2Activity.idtxt;
import static com.tshibakela.quizapp.Main2Activity.namtxt;
import static com.tshibakela.quizapp.Main2Activity.numbtxt;
import static com.tshibakela.quizapp.Main2Activity.tabHost;

public class MainActivity extends AppCompatActivity {

   public static Button button3;
  public  static   EditText nameEdit, idEdit, cellEdit;
    int Onregister;


    TextToSpeech helloSpeak;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // for Text to Speak

        helloSpeak = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status != TextToSpeech.ERROR) {
                    helloSpeak.setLanguage(Locale.ENGLISH);
                }

            }
        });

        //                                                      REGISTER
        //============================================For REGISTRATION [login content]

        button3=(Button)findViewById(R.id.button3);

        nameEdit=(EditText)findViewById(R.id.nameEdit);
        cellEdit=(EditText)findViewById(R.id.cellEdit);
        idEdit=(EditText)findViewById(R.id.idEdit);



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Onregister++;



                if (nameEdit.getText().toString().isEmpty() || cellEdit.getText().toString().isEmpty() || idEdit.getText().toString().isEmpty())

                {
                    Toast.makeText(getApplicationContext(), "You cannot procede without entering ID no, Cell no and Names", Toast.LENGTH_SHORT).show();

                }


                if (nameEdit.getText().toString().length()<=3 && cellEdit.getText().toString().length()!=10 && idEdit.getText().toString().length()!=13)

                {
                    Toast.makeText(getApplicationContext(), "Invalid Inputs", Toast.LENGTH_SHORT).show();

                }



                else if(nameEdit.getText().toString().length()<=3 )
                {
                    Toast.makeText(MainActivity.this, "Invalid Name, must be at least 4 letters", Toast.LENGTH_SHORT).show();
                }


                else if (cellEdit.getText().toString().length()!=10 )
                {

                    Toast.makeText(MainActivity.this, "Invalid Number, number must be 10 digist", Toast.LENGTH_SHORT).show();
                }


                else if (idEdit.getText().toString().length()<=5)
                {
                    Toast.makeText(MainActivity.this, "Invalid ID, Must be 6 digits", Toast.LENGTH_SHORT).show();
                }
                else

                    {

                    String MyN = nameEdit.getText().toString();


                    String Myc = cellEdit.getText().toString();


                    String Myi = idEdit.getText().toString();


                    String welmsg, mmName, OOID, cellPP, Instruct;
                    welmsg = "Welcome to Quiz App";


                    mmName = "  Your names are;";

                    OOID = "ID number ;";

                    cellPP = "Cell no ;";

                    Instruct = "...;Read instructioin before attempting any question";

                    helloSpeak.speak(welmsg + mmName+MyN + OOID +Myc+ cellPP +Myi + Instruct, TextToSpeech.QUEUE_FLUSH, null);

                       Intent i=  new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(i);
                }

  /* =======================================================================================
                                     END REGISTRATION
                                       ANDROID TEST
                             ======  END TABLE ANDROID =========
*/
            }

        });



    }
}
