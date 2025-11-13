import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        List<Music> list = new ArrayList<>(); 
        
        for(int i=0; i<musicinfos.length; i++){
            String[] musicinfo = musicinfos[i].split(",");
            int time = calculateTime(musicinfo[0], musicinfo[1]);
            if(isContains(m, musicinfo[3], time)){
                list.add(new Music(musicinfo[2], time, i));
            }
        }
        
        Collections.sort(list, (a,b) ->{
            if(a.time==b.time) return a.index-b.index;
            return b.time-a.time;
        });
        
        if(list.size()==0) return "(None)";
        return list.get(0).name;
    }
    
    private int calculateTime(String start, String end){
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        int startHour = Integer.valueOf(startTime[0]);
        int startMinutes = Integer.valueOf(startTime[1]);
        int endHour = Integer.valueOf(endTime[0]);;
        int endMinutes = Integer.valueOf(endTime[1]);;
        
        if(startHour==endHour) return endMinutes-startMinutes;
        else return (endHour-startHour)*60+endMinutes-startMinutes;
    }
    
    private boolean isContains(String m, String music, int time){
        m = convertSharp(m);
        music = convertSharp(music);

        if(m.length() > time) return false;

        StringBuilder played = new StringBuilder();
        for(int i=0; i<time; i++){
            played.append(music.charAt(i % music.length()));
        }

        return played.toString().contains(m);
    }

    private String convertSharp(String s){
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }
    
    class Music{
        String name;
        int time;
        int index;
        
        Music(String name, int time, int index){
            this.name = name;
            this.time = time;
            this.index = index;
        }
    }
}