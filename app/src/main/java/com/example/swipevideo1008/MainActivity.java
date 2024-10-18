//include package for project
package com.example.swipevideo1008;

//import modules
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


//create MainActivity class that extends appcompatActivity
public class MainActivity extends AppCompatActivity {

    //create a onCreate method for video app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //create function to get final version of xml
        final ViewPager2 videosViewPager= findViewById(R.id.videosViewPager);
        //insert the data using List
        List<VideoItem> videoItemsList = new ArrayList<>();
        //change videoCelebration for your video title
        VideoItem videoCelebration = new VideoItem();

        //upload video url
        videoCelebration.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-connection-3b12a.appspot.com/o/Beach%20video.mp4?alt=media&token=542c7a65-8b20-4aff-9575-7331c9dd5e61";
        //insert title for video
        videoCelebration.videoTitle = "Hawaii seaside view   ID:19490583";
        //insert video description
        videoCelebration.videoDescription = "Hawaiian shore during the spring season";
        videoItemsList.add(videoCelebration);

        //create new video item for second video
        VideoItem videoCelebration2 = new VideoItem();
        //url for video
        videoCelebration2.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-connection-3b12a.appspot.com/o/Los%20angeles%20Shore.mp4?alt=media&token=71b9df34-45db-466d-b7f3-3392712b5896";
        //title for video
        videoCelebration2.videoTitle = "LA Shore    ID:40605967";
        //description for video
        videoCelebration2.videoDescription = "Walking at Los Angeles Shore";
        //add video 2 to list of videos to display
        videoItemsList.add(videoCelebration2);

        //create new video item for third video
        VideoItem videoCelebration3 = new VideoItem();
        //url for video
        videoCelebration3.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-connection-3b12a.appspot.com/o/5001e097e57a4978b4245a12ae79b5ed%20(2).mp4?alt=media&token=a6a72b7c-a197-4bd5-823b-bf0789a6e2d7";
        //title for video
        videoCelebration3.videoTitle = "Disney performance  ID:24085907";
        //description for video
        videoCelebration3.videoDescription = "A lovely musical performance by Disney Musicians";
        //add video 3 to list of videos to display
        videoItemsList.add(videoCelebration3);

        //prepare all items for video
        videosViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}