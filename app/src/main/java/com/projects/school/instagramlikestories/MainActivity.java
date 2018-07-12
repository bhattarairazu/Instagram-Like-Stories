package com.projects.school.instagramlikestories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class MainActivity extends AppCompatActivity {
    StoriesProgressView storiesProgressview;
    ImageView mimgeview;
    int counter = 0;
    int [] resources = new int[]{
            R.drawable.am1,
            R.drawable.am2,
            R.drawable.am3
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storiesProgressview =(StoriesProgressView)findViewById(R.id.stories);
        storiesProgressview.setStoriesCount(3);
        storiesProgressview.setStoryDuration(1500L);
        storiesProgressview.setStoriesListener(new StoriesProgressView.StoriesListener() {
            @Override
            public void onNext() {
                mimgeview.setImageResource(resources[++counter]);
            }

            @Override
            public void onPrev() {
                mimgeview.setImageResource(resources[--counter]);
            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "Completed Stories", Toast.LENGTH_SHORT).show();
            }
        });
        mimgeview = (ImageView) findViewById(R.id.images);
        mimgeview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storiesProgressview.skip();
            }
        });
        mimgeview.setImageResource(resources[counter]);
    }

    @Override
    protected void onDestroy() {
        storiesProgressview.destroy();
        super.onDestroy();
    }
}
