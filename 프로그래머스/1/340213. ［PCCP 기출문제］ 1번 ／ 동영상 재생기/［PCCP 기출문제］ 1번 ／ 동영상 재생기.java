class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // video_len, pos, op_start, op_end을 초로 변환
        int videoSeconds = toSeconds(video_len);
        int positionSeconds = toSeconds(pos);
        int opStartSeconds = toSeconds(op_start);
        int opEndSeconds = toSeconds(op_end);

        // 명령 수행
        for (String command : commands) {
            positionSeconds = processCommand(command, positionSeconds, videoSeconds, opStartSeconds, opEndSeconds);
        }

        // 결과를 "mm:ss" 형식으로 반환
        return formatTime(positionSeconds);
    }

    // 문자열 "mm:ss"를 초로 변환하는 함수
    private int toSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        
        return minutes * 60 + seconds;
    }

    // 초로 된 시간을 "mm:ss" 형식으로 변환하는 함수
    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        
        // 결과를 "mm:ss" 형식으로 반환
        StringBuilder sb = new StringBuilder();
        if(minutes < 10) sb.append(0);
        sb.append(minutes);
        sb.append(":");
        if(seconds < 10) sb.append(0);
        sb.append(seconds);
    
        return sb.toString();
    }

    // 명령 처리 함수
    private int processCommand(String command, int positionSeconds, int videoSeconds, int opStartSeconds, int opEndSeconds) {
        // 오프닝 구간을 건너뛰기 (처리 전에)
        positionSeconds = skipOpening(positionSeconds, opStartSeconds, opEndSeconds);

        switch (command) {
            case "next":
                positionSeconds += 10;  // 10초 후로 이동
                break;
            case "prev":
                positionSeconds -= 10;  // 10초 전으로 이동
                break;
        }

        // 비디오 길이 넘어가지 않도록 처리
        if (positionSeconds > videoSeconds) {
            positionSeconds = videoSeconds;  // 비디오 끝으로 이동
        }

        // 음수로 넘어가지 않도록 처리
        if (positionSeconds < 0) {
            positionSeconds = 0;  // 비디오 시작으로 이동
        }

        // 오프닝 구간을 다시 건너뛰기 (처리 후)
        return skipOpening(positionSeconds, opStartSeconds, opEndSeconds);
    }

    // 오프닝 구간을 건너뛰는 함수
    private int skipOpening(int positionSeconds, int opStartSeconds, int opEndSeconds) {
        // 오프닝 구간에 있으면 오프닝 끝으로 이동
        if (positionSeconds >= opEndSeconds) {
            return positionSeconds;  // 오프닝 구간을 지나면 그대로
        } else if (positionSeconds >= opStartSeconds) {
            return opEndSeconds;  // 오프닝 구간이면 오프닝 끝으로 이동
        } else {
            return positionSeconds;  // 오프닝 구간 외에서는 그대로
        }
    }
}
