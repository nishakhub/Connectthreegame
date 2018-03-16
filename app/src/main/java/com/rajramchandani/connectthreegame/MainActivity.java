package com.rajramchandani.connectthreegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int flag=0;
    boolean draw=true;
    int tapped[]={2,2,2,2,2,2,2,2,2};
    int[][] combinations={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropin(View view)
    {
        draw=true;
        ImageView im=(ImageView)view;
        int tappedcounter= Integer.parseInt(im.getTag().toString());
        if(tapped[tappedcounter]==2) {
            tapped[tappedcounter]=flag;
            im.setTranslationY(-1000f);
            if (flag == 0) {
                im.setImageResource(R.drawable.red);
                flag = 1;
            } else {
                im.setImageResource(R.drawable.blue);
                flag = 0;
            }
            im.animate().translationYBy(1000f).setDuration(300);
            for(int[] combination:combinations)
            {
                if(tapped[combination[0]]==tapped[combination[1]] && tapped[combination[1]]==tapped[combination[2]]
                        &&tapped[combination[0]]!=2)
                {
                      if(flag==1)
                      {
                          TextView message=(TextView)findViewById(R.id.textview);
                          message.setText("RED HAS WON!");
                          LinearLayout ly=(LinearLayout)findViewById(R.id.linearlayout);
                          ly.setVisibility(View.VISIBLE);
                          draw=false;

                          for(int i=0;i<tapped.length;i++)
                          {
                              tapped[i]=1;
                          }
                      }
                      else
                      {
                          TextView message=(TextView)findViewById(R.id.textview);
                          message.setText("BLUE HAS WON!");
                          LinearLayout ly=(LinearLayout)findViewById(R.id.linearlayout);
                          ly.setVisibility(View.VISIBLE);
                          draw=false;

                          for(int i=0;i<tapped.length;i++)
                          {
                              tapped[i]=0;
                          }
                      }


                }


                else
                {
                    boolean gameover=true;
                    for(int i=0;i<tapped.length;i++)
                    {
                        if(tapped[i]==2)
                            gameover=false;

                    }
                    if(gameover && draw)
                    {
                            TextView message=(TextView)findViewById(R.id.textview);
                            message.setText("DRAW!");
                            LinearLayout ly=(LinearLayout)findViewById(R.id.linearlayout);
                            ly.setVisibility(View.VISIBLE);




                    }

                }


            }




        }


    }

    public void playagain(View view)
    {
        LinearLayout ly=(LinearLayout)findViewById(R.id.linearlayout);
        ly.setVisibility(View.INVISIBLE);
        int flag=0;
        for(int i=0;i<tapped.length;i++)
        {
            tapped[i]=2;
        }
        GridLayout grid=(GridLayout)findViewById(R.id.gridlayout);
        for(int i=0;i<grid.getChildCount();i++)//getchildcount returns how many childs r in the grid
        {
            ( (ImageView)grid.getChildAt(i)).setImageResource(0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
