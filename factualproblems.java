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

/* Problem 2
const solution = (clients) => {
let avgX = 0
let avgY = 0
for (let i = 0; i < clients.length; i++) avgX += clients[i][0]
for (let i = 0; i < clients.length; i++) avgY += clients[i][1]
avgX /= clients.length
avgY /= clients.length

let avgCenter = [avgX, avgY]
let bestLocus = clients[0]
let bestDistance = displacement(bestLocus, avgCenter)

for (let i = 1; i < clients.length; i++) {
  let currDistance = displacement(clients[i], avgCenter)
  if (bestDistance > currDistance) {
    bestDistance = currDistance
    bestLocus = clients[i]
  }
}

return clients.reduce((sum, dist) => sum + distance(dist, bestLocus), 0)
};

const displacement = (pos1, pos2) => {
  return ((pos1[0] - pos2[0])**2 + (pos1[1] - pos2[1])**2)**.5
}
const distance = (pos1, pos2) => {
  return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1])
}
*/

/* Problem 3
def mapifyArgument(arg):
    map = {}
    for i in range(0, len(arg)):
        module = arg[i][0]
        dep = arg[i][1]
        if not module in map:
            map[module] = []
        map[module].append(dep)
    return map


def solution(modulesToBuild, dependencies):
    deps = mapifyArgument(dependencies)
    from collections import deque
    queue = deque(modulesToBuild)
    res = set(modulesToBuild)
    while queue:
        node = queue.popleft()
        if node in deps:
            for neighbor in deps[node]:
                if neighbor not in res:
                    res.add(neighbor)
                    queue.append(neighbor)
        else:
            res.add(node)
    return len(res)

    # Type your solution here
    pass
*/
