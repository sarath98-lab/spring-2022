package com.example.icp11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTTS);
        btn = findViewById(R.id.btnTTS);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status == TextToSpeech.SUCCESS) {
                            int result = tts.setLanguage(Locale.US);
                            if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA)
                            {
                                Log.e("message","Language is not supported");
                            }
                            else {
                                //tts.speak("Text to Speech", TextToSpeech.QUEUE_ADD, null);
                                speak();
                            }
                        }
                        else{
                            Log.e("message","TTS is not supported");
                        }
                    }
                });
            }
        });
    }
    void speak()
    {
        String text = editText.getText().toString();
        tts.setSpeechRate(0.5f);
        tts.speak(text,TextToSpeech.QUEUE_ADD,null);
    }
    @Override
    protected void onPause(){
        super.onPause();
        tts.stop();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        tts.stop();
        tts.shutdown();
    }
}