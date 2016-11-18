package cl.click;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toast toast1;
    private Toast toast2;
    public float press;
    public int vis=1,vis1=1,vis2=1,winner=1;
    //public String res;
    CountDownTimer Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


        //Chronometer cm=(Chronometer)findViewById(R.id.chronometer) ;
        final TextView win1=(TextView)findViewById(R.id.textView6);
        final TextView win2=(TextView)findViewById(R.id.textView5);
        final TextView mTextView = (TextView) findViewById(R.id.mTextView);
        final TextView nTextView = (TextView) findViewById(R.id.nTextView);



            Timer = new CountDownTimer(20000, 1) { //Sets 10 second remaining

                public void onTick(long time) {

//                    if(time<5000){
//                        Button again= new Button(getApplicationContext());
//                        again.setText("Play again");
//                        again.setOnClickListener(new View.OnClickListener()
//                        {
//                            public void onClick(View view)
//                            {
//                                //your write code
//                            }
//                        });
//                    }

                    if(time >15000)
                    {
                        win1.setText(Html.fromHtml("Tap after 0<sup><small>th</small></sup> count"));
                        win2.setText(Html.fromHtml("Tap after 0<sup><small>th</small></sup> count"));
                    }
                    else if(winner==1){ win1.setText("PLAYER 1");
                        win2.setText("PLAYER 2");}

                    press = time - 10000;
                    if (time < 15000 && (vis==1)) {
                        mTextView.setVisibility(View.INVISIBLE);
                        nTextView.setVisibility(View.INVISIBLE);
                        vis=0;

                    }
                    else
                    {
                        if(vis1==1)
                        {
                            mTextView.setTextSize(time / 300);
                            mTextView.setText("" + (time - 10000) / 1000);


                        }
                        if(vis2==1)
                        {
                            nTextView.setTextSize(time / 300);
                            nTextView.setText("" + (time - 10000) / 1000);

                        //vis=0;
                            }
                    }

                }



                public void onFinish() {
                    mTextView.setVisibility(View.VISIBLE);
                    mTextView.setText("Done!");
                    nTextView.setVisibility(View.VISIBLE);
                    nTextView.setText("Done!");


//                Intent i=new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(i);
                }
            }.start();



        //cm.setBase(SystemClock.elapsedRealtime());
        //cm.start();

        toast1 = Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT);
        toast2 = Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT);


        final LinearLayout ll1 = (LinearLayout) findViewById(R.id.linearLayout1);
        final LinearLayout ll2 = (LinearLayout) findViewById(R.id.linearLayout2);

        ll1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (press > 0) {
                    ll1.setBackgroundColor(Color.parseColor("#ef2f2f"));
                    toast1 = Toast.makeText(getApplicationContext(), "Bad Move " + -(press / 1000), Toast.LENGTH_SHORT);
                    ll1.setOnClickListener(null);
                    mTextView.setVisibility(View.VISIBLE);
                    mTextView.setTextSize(75);
                    mTextView.setText("You lose");
                    vis1=0;
                    if(press<5000)
                    vis=0;
                } else {
                    ll1.setBackgroundColor(Color.parseColor("#60ef53"));
                    toast1 = Toast.makeText(getApplicationContext(), "Well played.Your delay:" + -(press / 1000), Toast.LENGTH_SHORT);
                    if(winner==1){
                        win1.setText("Player 2 WINNER");
                        win2.setText("Player 2 WINNER");
                        winner=0;}
                    ll1.setOnClickListener(null);
                    // ll2.setOnClickListener(null);
                }
                // toast2.cancel();
                toast1.setGravity(Gravity.TOP, 0, 0);

                toast1.show();
//                Handler handler1 = new Handler();
//                handler1.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        toast1.cancel();
//                    }
//                }, 3000);

            }
        });


        ll2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ll2.setBackgroundColor(Color.parseColor("#60ef53"));
                //toast1.cancel();
                if (press > 0) {
                    ll2.setBackgroundColor(Color.parseColor("#ef2f2f"));
                    toast2 = Toast.makeText(getApplicationContext(), "Bad Move " + -(press / 1000), Toast.LENGTH_SHORT);
                    ll2.setOnClickListener(null);
                    nTextView.setVisibility(View.VISIBLE);
                    nTextView.setTextSize(75);
                    nTextView.setText("You lose");
                    vis2=0;
                    if(press<5000)
                    vis=0;

                } else {
                    ll2.setBackgroundColor(Color.parseColor("#60ef53"));
                    toast2 = Toast.makeText(getApplicationContext(), "Well played.Your delay:" + -(press / 1000), Toast.LENGTH_SHORT);
                    if(winner==1){
                    win1.setText("Player 1 WINNER");
                    win2.setText("Player 1 WINNER");
                    winner=0;}
                    //ll1.setOnClickListener(null);
                    ll2.setOnClickListener(null);
                }

                toast2.show();

//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        toast2.cancel();
//                    }
//                }, 3000);
            }


        });


        }




}