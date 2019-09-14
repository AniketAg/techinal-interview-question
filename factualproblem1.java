// readings: list of [timestamp, speed] tuples.
//   timestamp is in seconds
//   speed is in km/h
// endTime: time at which truck speed is requested, in seconds

class Solution {
    public static double solution(double[][] readings, long end_time) {
        double total_distance = 0;
        for(int i = 1; i < readings.length; i++)
        {
            double speed = readings[i - 1][1];
            double time = (readings[i][0] - readings[i - 1][0]) / 3600;
            double curr_distance = speed * time;
            total_distance += curr_distance;
        }
        double last_speed = readings[readings.length - 1][1];
        double last_time = (end_time - readings[readings.length - 1][0]) / 3600;
        double last_distance = last_speed * last_time;
        return total_distance + last_distance;
        // Type your solution here
    }
}

