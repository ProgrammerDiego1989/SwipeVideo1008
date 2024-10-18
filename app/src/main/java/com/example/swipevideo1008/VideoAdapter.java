//import packages
package com.example.swipevideo1008;

//import modules
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//initialize video adapter
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    //new data comes in from videoItem
    private List<VideoItem> videoItems;

    // create videoAdapter method for videoItems
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    //create onCreate sub function
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video,parent,false)
        );
    }

    //create onBind sub function
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    //create getItem sub function
    @Override
    public int getItemCount() {
        return videoItems.size();
    }


    //initialize videoViewHolder to grab the URL and hold it somewhere (library) store contents inside android which is called a recyclerView
    static class VideoViewHolder extends RecyclerView.ViewHolder {
        ////initialize textVideoTitle and textVideoDescription
        TextView textVideoTitle1, textVideoDescription1;
        //initialize videoView item
        VideoView videoView;
        //initialize progressBar item
        ProgressBar progressBar;
        //create constructor for VideoViewHolder
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription1 = itemView.findViewById(R.id.textVideoDescription);
            progressBar = itemView.findViewById(R.id.videoProgressBar);

        }

        //create setVideoData method for VideoItems, set videoData to specific input
        void setVideoData(VideoItem videoItem){
            textVideoTitle1.setText(videoItem.videoTitle);
            textVideoDescription1.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);

            //set videoview to setonpreparedlistner for the video to be automatically played
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                //insert package mediaplayer to play video
                @Override
                public void onPrepared(MediaPlayer mp) {
                    //set progress bar to gone
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    //identify video ratios, make it consistent
                    float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                    float screenRatio = videoView.getWidth()/(float) videoView.getHeight();

                    //compare videoRatio and screenRatio
                    float scale = videoRatio / screenRatio;
                    //conditional to check if they're equal
                    if (scale >=1f){
                        videoView.setScaleX(scale);
                    } else {
                        videoView.setScaleY(1f / scale);
                    }
                }
            });

            //play the video by using videoView dot setOnCompletionListener
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });

        }
    }


}
