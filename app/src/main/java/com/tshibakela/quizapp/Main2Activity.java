package com.tshibakela.quizapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {


    //Declare varia
    public static TabHost tabHost;
    public static TextView memoTxt, namTxt, mrktxt, idtxt, numbtxt, emailtext, namtxt, p1, p2, p3, p4, p5, p6, pp6;
    public int total, e1, e2, e3, e4, e5, e6;
    String Speak;

    public  static  String Myname, Myid,Mycell;

    /*
    The above is for text to speak
     */


    /*
    For attempting to make android quiz speakth (Below)
     */
    RadioButton p;
    ImageButton imageButton, imageButton2;
    String N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22, N23, N24;  // to use on
    RadioButton rBtn1, rBtn2, rBtn3, rBtn4; //for question 1
    RadioButton r1, r2, r3, r4; //For question 2
    RadioButton rr1, rr2, rr3, rr4; //for question 3
    RadioButton br1, br2, br3, br4; //for qusetion 4
    RadioButton b1, b2, b3, b4; //for question 5
    RadioButton q61btn, q62btn, q63btn, q64btn; //for question 6
    String how1;
    Button button3;
    /*
    end attempt
     */
    int Tot;

    int Sco1 = 0;
    int good = 0;
    String Answers, take, T1, T2, T3, T4, T5, T6, correctAnswer, FinalSolo; //FOR RANDOM QUESTION
    RadioButton pbtn, p1btn, p2btn, p3btn; //RadioButton for the Random Quiz (Science)
    Another prob = new Another();    //Calling class For random
    int QQ = prob.Problem.length; //for random Quiz
    Random zz; //To randomise
    TextView Randtext;//for Randomize
    int doo;
    // CALL THE JAVE CLASS HERE FIRST
    Button Dubai;  // for Random Question
    Exams myAnswer = new Exams();
    TabWidget tabs;
    FrameLayout tabcontent;
    RadioGroup radiogroup1, yeboRad, radiogroup2, radiogroup3, radiogroup4, radiogroup5, radiogroup6; //for Android Quiz
    Button btn, Ansbtn, sembtn;// button3 for reqister this is control button for semsester marks, solution *Android Quiz*
    RadioButton answer1, answer2, answer3, answer4, answer5, answer6; //for android Quiz
    LinearLayout Login;// for reqister

    TableLayout tbLayout;
    /*

    I want to make an app to speak
     */
    private TextToSpeech helloSpeak;


    //                   END DECLARING

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//==================================================================================================
        //======================TABLE ANDROID======================================================
//================================================================================================
        //                      CASTING
        //              FOR QUESTIONS
        p1 = (TextView) findViewById(R.id.p1);
        p2 = (TextView) findViewById(R.id.p2);
        p3 = (TextView) findViewById(R.id.p3);
        p4 = (TextView) findViewById(R.id.p4);
        p5 = (TextView) findViewById(R.id.p5);
        p6 = (TextView) findViewById(R.id.p6);
        pp6 = (TextView) findViewById(R.id.pp6);

        //                     CASTING  RADIOGROUP
        radiogroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radiogroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radiogroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radiogroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        radiogroup5 = (RadioGroup) findViewById(R.id.radioGroup5);
        radiogroup6 = (RadioGroup) findViewById(R.id.radioGroup6);

        tabHost = (TabHost) findViewById(R.id.tabHost);

        // for radio button
        answer1 = (RadioButton) findViewById(R.id.rBtn1);
        answer2 = (RadioButton) findViewById(R.id.r2);
        answer3 = (RadioButton) findViewById(R.id.rr3);
        answer4 = (RadioButton) findViewById(R.id.br3);
        answer5 = (RadioButton) findViewById(R.id.b4);
        answer6 = (RadioButton) findViewById(R.id.q64btn);

        //for tablesLayout text
        mrktxt = (TextView) findViewById(R.id.mrktxt);
        idtxt = (TextView) findViewById(R.id.idtxt);
        namtxt = (TextView) findViewById(R.id.namtxt);
        numbtxt = (TextView) findViewById(R.id.numbtxt);

        Dubai = (Button) findViewById(R.id.Dubai);//for random
        Randtext = (TextView) findViewById(R.id.Randtext);// For Random

        //                  Casting Button

        btn = (Button) findViewById(R.id.btn); // not used for here onclick methods is used


//        Ansbtn = (Button) findViewById(R.id.Ansbtn); //for the answer
//
//        sembtn = (Button) findViewById(R.id.sembtn);// for the semester marks

        tbLayout = (TableLayout) findViewById(R.id.tbLayout);// for display of semester marks


        //                   CASTING TABHOST
        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //For Android tab1
        TabHost.TabSpec spec = host.newTabSpec("Tab one");
        spec.setContent(R.id.android);
        spec.setIndicator("Android");
        host.addTab(spec);

        //for Town tab2
        spec = host.newTabSpec("Tab two");
        spec.setContent(R.id.town);
        spec.setIndicator("Science");
        host.addTab(spec);

        //for textView for memo

        memoTxt = (TextView) findViewById(R.id.memoTxt);

        //for names and headings
        namTxt = (TextView) findViewById(R.id.namTxt);

        pbtn = (RadioButton) findViewById(R.id.pbtn);//for random
        p1btn = (RadioButton) findViewById(R.id.p1btn);//for random
        p2btn = (RadioButton) findViewById(R.id.p2btn);//for random
        p3btn = (RadioButton) findViewById(R.id.p3btn);//for random


        //                    END OF CASTING


        // For text to speak

        helloSpeak = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status != TextToSpeech.ERROR) {
                    helloSpeak.setLanguage(Locale.ENGLISH);
                }

            }
        });

        /*
        Casting for the text to speak the radiobutton

         */

        if (MainActivity.button3.isClickable()) {

            String Myname = MainActivity.nameEdit.getText().toString();
            namtxt.setText(Myname);

            String Mycell = MainActivity.cellEdit.getText().toString();
            numbtxt.setText(Mycell);

            String Myid = MainActivity.idEdit.getText().toString();
            idtxt.setText(Myid);

//            if (MainActivity.nameEdit.getText().toString().isEmpty() || MainActivity.cellEdit.getText().toString().isEmpty() || MainActivity.idEdit.getText().toString().isEmpty())
//
//            {
//                Toast.makeText(getApplicationContext(), "You cannot procede without entering ID no, Cell no and Names", Toast.LENGTH_SHORT).show();
//            } else {
//
//                String welmsg, mmName, OOID, cellPP, Instruct;
//                welmsg = "Welcome to Quiz App";
//
//
//                mmName = "  Your names are;";
//
//                OOID = "ID number ;";
//
//                cellPP = "Cell no ;";
//
//                Instruct = "...;Read instructioin before attempting any question";
//
//                helloSpeak.speak(welmsg + mmName+Myname + OOID +Myid+ cellPP +Mycell + Instruct, TextToSpeech.QUEUE_FLUSH, null);
//
//
//
//            }


        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int count = 0;
                int count1 = 0;
                int count2 = 0;
                int count3 = 0;
                int count4 = 0;
                int count5 = 0;
                int count6 = 0;


                //for 1st question
                myAnswer.setQ11(5);
                myAnswer.setQ12(0);
                myAnswer.setQ13(0);
                myAnswer.setQ14(0);


                if (radiogroup1.getCheckedRadioButtonId() == R.id.rBtn1) {
                    count1 = myAnswer.getQ11();


                } else if (radiogroup1.getCheckedRadioButtonId() == R.id.rBtn2) {
                    count1 = myAnswer.getQ12();

                } else if (radiogroup1.getCheckedRadioButtonId() == R.id.rBtn3) {
                    count1 = myAnswer.getQ13();

                } else if (radiogroup1.getCheckedRadioButtonId() == R.id.rBtn2) {
                    count1 = myAnswer.getQ14();

                }


                //for 2nd question
                myAnswer.setQ21(0);
                myAnswer.setQ22(5);
                myAnswer.setQ23(0);
                myAnswer.setQ24(0);

                if (radiogroup2.getCheckedRadioButtonId() == R.id.r1) {
                    count2 = myAnswer.getQ21();


                } else if (radiogroup2.getCheckedRadioButtonId() == R.id.r2) {
                    count2 = myAnswer.getQ22();

                } else if (radiogroup2.getCheckedRadioButtonId() == R.id.r3) {
                    count2 = myAnswer.getQ23();

                } else if (radiogroup2.getCheckedRadioButtonId() == R.id.r4) {
                    count2 = myAnswer.getQ24();

                }


                //for the  3rd

                myAnswer.setQ31(0);
                myAnswer.setQ32(0);
                myAnswer.setQ33(5);
                myAnswer.setQ34(0);

                if (radiogroup3.getCheckedRadioButtonId() == R.id.rr1) {
                    count3 = myAnswer.getQ31();


                } else if (radiogroup3.getCheckedRadioButtonId() == R.id.rr2) {
                    count3 = myAnswer.getQ32();


                } else if (radiogroup3.getCheckedRadioButtonId() == R.id.rr3) {
                    count3 = myAnswer.getQ33();

                } else if (radiogroup3.getCheckedRadioButtonId() == R.id.rr4) {
                    count3 = myAnswer.getQ34();

                }


                // for the 4th
                myAnswer.setQ41(0);
                myAnswer.setQ42(0);
                myAnswer.setQ43(5);
                myAnswer.setQ44(0);


                if (radiogroup4.getCheckedRadioButtonId() == R.id.br1) {
                    count4 = myAnswer.getQ41();


                } else if (radiogroup4.getCheckedRadioButtonId() == R.id.br2) {
                    count4 = myAnswer.getQ42();

                } else if (radiogroup4.getCheckedRadioButtonId() == R.id.br3) {
                    count4 = myAnswer.getQ43();

                } else if (radiogroup4.getCheckedRadioButtonId() == R.id.br4) {
                    count4 = myAnswer.getQ44();

                }

                // for the 5th
                myAnswer.setQ51(0);
                myAnswer.setQ52(0);
                myAnswer.setQ53(0);
                myAnswer.setQ54(5);

                if (radiogroup5.getCheckedRadioButtonId() == R.id.b1) {
                    count5 = myAnswer.getQ51();

                } else if (radiogroup5.getCheckedRadioButtonId() == R.id.b2) {
                    count5 = myAnswer.getQ52();

                } else if (radiogroup5.getCheckedRadioButtonId() == R.id.b3) {
                    count5 = myAnswer.getQ53();

                } else if (radiogroup5.getCheckedRadioButtonId() == R.id.b4) {
                    count5 = myAnswer.getQ54();

                }
                //for the 6th

                myAnswer.setQ61(0);
                myAnswer.setQ62(0);
                myAnswer.setQ63(0);
                myAnswer.setQ64(5);


                if (radiogroup6.getCheckedRadioButtonId() == R.id.q61btn) {
                    count6 = myAnswer.getQ61();

                } else if (radiogroup6.getCheckedRadioButtonId() == R.id.q62btn) {
                    count6 = myAnswer.getQ62();

                } else if (radiogroup6.getCheckedRadioButtonId() == R.id.q63btn) {
                    count6 = myAnswer.getQ63();

                } else if (radiogroup6.getCheckedRadioButtonId() == R.id.q64btn) {
                    count6 = myAnswer.getQ64();

                }
                total = count1 + count2 + count3 + count4 + count5 + count6; //for total this determines if answers must be or not and if the user can proceed or not


                good++; // Determines the out


                // Number of grace or chance to modify answer to correct values
                if (good == 1) {
                    Toast.makeText(Main2Activity.this, "You have one chance to modify your answer correct before submitting", Toast.LENGTH_SHORT).show();
                    helloSpeak.speak("You have one chance to modify your answer correct before submitting", TextToSpeech.QUEUE_FLUSH, null);
                }

                if (total >= 12) {
                    if (good == 2) {
                        btn.setText("Semester Marks");
                        //FOR COLOR
                        answer1.setTextColor(Color.GREEN & Color.CYAN);
                        answer2.setTextColor(Color.GREEN);
                        answer3.setTextColor(Color.GREEN);
                        answer4.setTextColor(Color.GREEN);
                        answer5.setTextColor(Color.GREEN);
                        answer6.setTextColor(Color.GREEN);


                        Animation myAnswer = new AlphaAnimation(0.0f, 1.0f);
                        myAnswer.setDuration(50);
                        myAnswer.setStartOffset(20);
                        myAnswer.setRepeatMode(Animation.REVERSE);
                        myAnswer.setRepeatCount(20);
   /*
           myAnswer.setRepeatCount(20); Here is the number of count but we can use Animation.Infinite to do it forever

              These method runs for all answers

   */                   answer1.startAnimation(myAnswer);
                        answer2.startAnimation(myAnswer);
                        answer3.startAnimation(myAnswer);
                        answer4.startAnimation(myAnswer);
                        answer5.startAnimation(myAnswer);
                        answer6.startAnimation(myAnswer);


                        //                 FOR APPEARENCE TEXT
                        // namTxt.startAnimation(myAnswer); removed because it was entering semseter marks content
                        namTxt.setVisibility(View.VISIBLE);
                        namTxt.setText("Android Test 1 Memo");

                        namTxt.setTextColor(Color.BLUE);
                        memoTxt.setVisibility(View.VISIBLE);

                        //                  FOR TOAST MESSAGES


                        //Ansbtn.setVisibility(View.VISIBLE);


                        Toast.makeText(getApplicationContext(), "Well done!!\n" + "Grades " + total + " of 30", Toast.LENGTH_LONG).show();
                        helloSpeak.speak("Well done!!\n" + "Grades " + total + " of 30\n" + "Android Test 1 Memo" + "You can click button to view semester", TextToSpeech.QUEUE_FLUSH, null);


                    } else if (good == 3)

                    {
                        namTxt.setVisibility(View.GONE);
                        btn.setVisibility(View.GONE);
                        tbLayout.setVisibility(View.VISIBLE);

                                /*
                                Here i want to display a table with results on the same xml i used by making some content gone
                                and some appear
                                 */


                        mrktxt.setText(String.valueOf(total) + "/30 Pass");
                        radiogroup1.setVisibility(View.GONE);
                        radiogroup2.setVisibility(View.GONE);
                        radiogroup3.setVisibility(View.GONE);
                        radiogroup4.setVisibility(View.GONE);
                        radiogroup5.setVisibility(View.GONE);
                        radiogroup6.setVisibility(View.GONE);


                        p1.setVisibility(View.GONE);
                        p2.setVisibility(View.GONE);
                        p3.setVisibility(View.GONE);
                        p4.setVisibility(View.GONE);
                        p5.setVisibility(View.GONE);
                        p6.setVisibility(View.GONE);
                        pp6.setVisibility(View.GONE);

                        namTxt.setVisibility(View.GONE);
                        memoTxt.setVisibility(View.GONE);

                        ImageButton uuImage=(ImageButton)findViewById(R.id.uuImage);
                        ImageButton uu1Image=(ImageButton)findViewById(R.id.uu1Image);
                        ImageButton uu2Image=(ImageButton)findViewById(R.id.uu2Image);
                        ImageButton uu3Image=(ImageButton)findViewById(R.id.uu3Image);
                        ImageButton uu4Image=(ImageButton)findViewById(R.id.uu4Image);
                        ImageButton uu5Image=(ImageButton)findViewById(R.id.uu5Image);

                        uuImage.setVisibility(View.GONE);
                        uu1Image.setVisibility(View.GONE);
                        uu2Image.setVisibility(View.GONE);
                        uu3Image.setVisibility(View.GONE);
                        uu4Image.setVisibility(View.GONE);
                        uu5Image.setVisibility(View.GONE);



                        //  sembtn.setVisibility(View.GONE);
                        helloSpeak.speak("Here is your \n Semester Marks", TextToSpeech.QUEUE_FLUSH, null);
                        Toast.makeText(getApplicationContext(), "Here is your \n Semester Marks", Toast.LENGTH_SHORT).show();


                    }


                } else if (total < 10) {

                    if (good == 1) {
                        memoTxt.setVisibility(View.INVISIBLE);

                        helloSpeak.speak("Failed!!\n" + total + " of 30", TextToSpeech.QUEUE_FLUSH, null);
                        Toast.makeText(getApplicationContext(), "Failed!! \n" + total + " of 30", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (good == 2)

                    {

                        btn.setVisibility(View.GONE);


                        helloSpeak.speak("You are disqualified", TextToSpeech.QUEUE_FLUSH, null);
                        Toast.makeText(Main2Activity.this, "You are disqualified ", Toast.LENGTH_LONG).show();
                    }

                }

                        /*
                        for Student details & semester marks
                        After clicking three times the semester will display to the used

                         */

                //                if (good==2)
                //
                //                {
                //                   // namTxt.setVisibility(View.GONE);
                //                    Toast.makeText(getApplicationContext(),"Click Again Please!",Toast.LENGTH_SHORT);
                //                }


                // for the 7th question
                myAnswer.setQ1(5);
                myAnswer.setQ2(0);
                myAnswer.setQ3(0);
                myAnswer.setQ4(0);

                //int perc= (total/30)*100;

            }


        });

        /*
                 For Science random question
         */

        zz = new Random();

        shuffle(zz.nextInt(QQ));
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);


        Dubai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (pbtn.isChecked()) {
                    if (pbtn.getText().toString().equalsIgnoreCase(correctAnswer)) {
                        Sco1++;

                    }
                    shuffle(zz.nextInt(QQ));

                } else if (p1btn.isChecked())

                {
                    if (p1btn.getText().toString().equalsIgnoreCase(correctAnswer)) {
                        Sco1++;
                    }
                    shuffle(zz.nextInt(QQ));

                } else if (p2btn.isChecked()) {
                    if (p2btn.getText().toString().equalsIgnoreCase(correctAnswer)) {
                        Sco1++;
                    }
                    shuffle(zz.nextInt(QQ));
                } else if (p3btn.isChecked()) {
                    if (p3btn.getText().toString().equalsIgnoreCase(correctAnswer)) {
                        Sco1++;


                    }
                    shuffle(zz.nextInt(QQ));
                }

                //shuffle(Ca.nextInt(QQ));  one of error encounter
                doo++;
                //  Toast.makeText(getApplicationContext(), Sco, Toast.LENGTH_SHORT).show(); one of error encounter
                RadioGroup yeboRad = (RadioGroup) findViewById(R.id.yeboRad);

                Tot = Sco1;


                if (doo <= 6) {

                    Toast.makeText(getApplicationContext(), "Score " + Sco1, Toast.LENGTH_SHORT).show();


                    helloSpeak.speak("You have Score" + Sco1, TextToSpeech.QUEUE_FLUSH, null);
                }

            }
        });

    }

    private void shuffle(int a) {

        take = prob.getProblem(a).toString();

        T1 = prob.getPickSolo1(a).toString();
        T2 = prob.getPickSolo2(a).toString();
        T3 = prob.getPickSolo3(a).toString();
        T4 = prob.getPickSolo4(a).toString();

        correctAnswer = prob.getFinal(a).toString();
        TextView TestTxt = (TextView) findViewById(R.id.TestTxt);


        if (doo <= 5) {

            TestTxt.setText("Understanding World Of Science\n\tTest 1\n");
            TestTxt.setTextColor(Color.BLUE);
            Randtext.setText(take);

        } else if (doo >= 5)

        {
            //For blink text
            Animation myText = new AlphaAnimation(0.0f, 1.0f);
            myText.setDuration(50);
            myText.setStartOffset(20);
            myText.setRepeatMode(Animation.REVERSE);
            myText.setRepeatCount(3);
            TestTxt.startAnimation(myText);

            TestTxt.setText("Understandi World of Science" + "Test Solutions\n");

            Dubai.setText("Solution");
            TestTxt.setTextColor(Color.BLACK);
            Randtext.setText(take + "\n\t");
            TextView FineText = (TextView) findViewById(R.id.FineText);
            FineText.setVisibility(View.VISIBLE);
            FineText.setText("\t" + correctAnswer);
            FineText.setTextColor(Color.RED);

            helloSpeak.speak("The answer is" + correctAnswer, TextToSpeech.QUEUE_FLUSH, null);


            if (Tot <= 3)

            {
                Toast.makeText(getApplicationContext(), "Due to low grades you are terminated. Thank you!", Toast.LENGTH_LONG).show();

            }


        } else if (doo < 9)

        {
            Toast.makeText(getApplicationContext(), "We will call you soon", Toast.LENGTH_SHORT).show();
        }

        pbtn.setText(T1);
        p1btn.setText(T2);
        p2btn.setText(T3);
        p3btn.setText(T4);

    }
    //The following is for text to speak


    public void Speaking(View v) {

        String Ques, AnnnS, T1T, T2T, T3T, T4T;
        Ques = "Question:";

        AnnnS = "Pick the possible answer: ";

        T1T = "1st Answer:";
        T2T = "2nd Answer:";
        T3T = "3rd Answer:";
        T4T = "4th Answer:";

        helloSpeak.speak(Ques + take + AnnnS
                + T1T + T1 + T2T + T2 + T3T + T3 + T4T + T4, TextToSpeech.QUEUE_FLUSH, null); //For it to speak
    }

    ;
    //======End of Text to speak


    /*
        The following is to stop the text to speak for random Question
     */
    public void Pause(View v) {
        helloSpeak.stop();
        //helloSpeak.shutdown();
    }

    //End methods for stopping


    //attempt to make Android quiz speaks

    public void playP1(View V) {

        String low;
        low = p1.getText().toString();

        rBtn2 = (RadioButton) findViewById(R.id.rBtn2);
        rBtn3 = (RadioButton) findViewById(R.id.rBtn3);
        rBtn4 = (RadioButton) findViewById(R.id.rBtn4);

        String low2;
        low2 = rBtn2.getText().toString();
        String low3;
        low3 = rBtn3.getText().toString();
        String low4;
        low4 = rBtn4.getText().toString();

        RadioButton rBtn1 = (RadioButton) findViewById(R.id.rBtn1);
        String low1;
        low1 = rBtn1.getText().toString();

        e1++;

        if (e1 == 1 || e1 == 3 || e1 == 5 || e1 == 7 || e1 == 9 || e1 == 11 || e2 == 13 || e2 == 15 || e2 == 17 || e2 == 19 || e2 == 21) {

            helloSpeak.speak(low + low1 + low2 + low3 + low4, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            helloSpeak.stop();
        }
    }

    public void playP2(View V) {

        p2 = (TextView) findViewById(R.id.p2);

        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);

        String leHeadl;
        leHeadl = p2.getText().toString();

        N1 = r1.getText().toString();
        N2 = r2.getText().toString();
        N3 = r3.getText().toString();
        N4 = r4.getText().toString();

        e2++;

        if (e2 == 1 || e2 == 3 || e2 == 5 || e2 == 7 || e2 == 9 || e2 == 11 || e2 == 13 || e2 == 15 || e2 == 17 || e2 == 19 || e2 == 21) {

            helloSpeak.speak(leHeadl + N1 + N2 + N3 + N4, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            helloSpeak.stop();
        }

    }

    public void playP3(View V) {
        p3 = (TextView) findViewById(R.id.p3);

        rr1 = (RadioButton) findViewById(R.id.rr1);
        rr2 = (RadioButton) findViewById(R.id.rr2);
        rr3 = (RadioButton) findViewById(R.id.rr3);
        rr4 = (RadioButton) findViewById(R.id.rr4);

        String leHead2;
        leHead2 = p3.getText().toString();

        N5 = rr1.getText().toString();
        N6 = rr2.getText().toString();
        N7 = rr3.getText().toString();
        N8 = rr4.getText().toString();


        e3++;
        if (e3 == 1 || e3 == 3 || e3 == 5 || e3 == 7 || e3 == 9 || e3 == 11 || e3 == 13 || e3 == 15 || e3 == 17 || e3 == 19 || e3 == 21) {

            helloSpeak.speak(leHead2 + N5 + N6 + N7 + N8, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            helloSpeak.stop();
        }
    }

    public void playP4(View V) {
        p4 = (TextView) findViewById(R.id.p4);

        br1 = (RadioButton) findViewById(R.id.br1);
        br2 = (RadioButton) findViewById(R.id.br2);
        br3 = (RadioButton) findViewById(R.id.br3);
        br4 = (RadioButton) findViewById(R.id.br4);

        String leHead3;
        leHead3 = p4.getText().toString();

        N9 = br1.getText().toString();
        N10 = br2.getText().toString();
        N11 = br3.getText().toString();
        N12 = br4.getText().toString();

        e4++;
        if (e4 == 1 || e4 == 3 || e4 == 5 || e4 == 7 || e4 == 9 || e4 == 11 || e4 == 13 || e4 == 15 || e4 == 17 || e4 == 19 || e4 == 21) {

            helloSpeak.speak(leHead3 + N9 + N10 + N11 + N12, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            helloSpeak.stop();
        }

    }

    public void playP5(View V) {
        p5 = (TextView) findViewById(R.id.p5);

        b1 = (RadioButton) findViewById(R.id.b1);
        b2 = (RadioButton) findViewById(R.id.b2);
        b3 = (RadioButton) findViewById(R.id.b3);
        b4 = (RadioButton) findViewById(R.id.b4);

        String leHead4;
        leHead4 = p5.getText().toString();

        N13 = b1.getText().toString();
        N14 = b2.getText().toString();
        N15 = b3.getText().toString();
        N16 = b4.getText().toString();

        e5++;

        if (e5 == 1 || e5 == 3 || e5 == 5 || e5 == 7 || e5 == 9 || e5 == 11 || e5 == 13 || e5 == 15 || e5 == 17 || e5 == 19 || e5 == 21) {
            helloSpeak.speak(leHead4 + N13 + N14 + N15 + N16, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            helloSpeak.stop();
        }

    }

    public void playP6(View V) {
        p6 = (TextView) findViewById(R.id.p6);
        pp6 = (TextView) findViewById(R.id.pp6);

        q61btn = (RadioButton) findViewById(R.id.q61btn);
        q62btn = (RadioButton) findViewById(R.id.q62btn);
        q63btn = (RadioButton) findViewById(R.id.q63btn);
        q64btn = (RadioButton) findViewById(R.id.q64btn);

        String leHead5;
        leHead5 = p6.getText().toString();
        N21 = pp6.getText().toString();

        N17 = q61btn.getText().toString();
        N18 = q62btn.getText().toString();
        N19 = q63btn.getText().toString();
        N20 = q64btn.getText().toString();

        e6++;

        if (e6 == 1 || e6 == 3 || e6 == 5 || e6 == 7 || e6 == 9 || e6 == 11 || e6 == 13 || e6 == 15 || e6 == 17 || e6 == 19 || e6 == 21) {

            helloSpeak.speak(leHead5 + N21 + N17 + N18 + N19 + N20, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            helloSpeak.stop();
        }


    }

//==================THE FOLLOWING METHODS WORKS IN ALL TABLES TO HOLD THEM=================

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.android) {
            return true;
        }

        return super.onOptionsItemSelected(item);


    }


}





