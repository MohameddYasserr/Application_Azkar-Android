package com.example.hp.applicationazkar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Page2 extends AppCompatActivity
{
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        b1 = (Button)findViewById(R.id.Button1);
        b2 = (Button)findViewById(R.id.Button2);
        b3 = (Button)findViewById(R.id.Button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String developerName = "Mohamed Yasser";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://search?q=" + developerName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/search?q="+developerName)));
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String appPackageName = getPackageName();
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                }

            }
        });

        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "تطبيق اذكارات للمبتدئين");
                i.putExtra(Intent.EXTRA_TEXT, "تطبيق اذكارات منوعة , جرب التطبيق اكثر من رائع .. إلخ \n https://play.google.com/store/apps/details?id=com.andrody.azkar");
                startActivity(Intent.createChooser(i,"اختر التطبيق"));
            }
        });

    }
}
