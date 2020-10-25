package com.grudnov.lessons.lesson9.playlist;

import java.util.Objects;

public class Playlist implements Cloneable {
    private Track[] tracks;

    public Playlist() {
        tracks = new Track[10];
    }

    public void addTrack(Track track){
        Objects.requireNonNull(track, "track must not be null");
        for (int i = 0; i < tracks.length; i++) {
            if(track.equals(tracks[i]) && tracks[i].hashCode() == track.hashCode()) {
                System.out.println("This playlist already have this track");
                return;
            }
            if(tracks[i] == null) {
                tracks[i] = track;
                //System.out.println("Track " + track + " add in playlist");
                return;
            }
        }
        System.out.println("This playlist already is full");
    }

    public Track[] getTracks() {
        return tracks;
    }

    public int getGeneralDuration() {
        int sum = 0;
        for (Track track : tracks) {
            if(track != null){
                sum += track.getDuration();
            }
        }
        return sum;
    }

    @Override
    protected Playlist clone() {
        Playlist tempplaylist = new Playlist();
        tempplaylist.tracks = this.tracks.clone();
        return tempplaylist;

    }

    public Playlist copyPlaylist()  {
       return this.clone();
    }


}
