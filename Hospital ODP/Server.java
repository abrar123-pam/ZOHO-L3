import java.util.*;

class Server {
    static Map<String, User> user_map = new HashMap<>();
    Queue<User> queue = new LinkedList<>();
    ArrayList<User> list = new ArrayList<>();
    Map<String, Double> waitingTimeMap = new HashMap<>();

    public void addUser(String name, User user) {
        user_map.put(name, user);
        list.add(user);
        queue.add(user);
    }

    public void completeCheckUp(String name, double outTime) {
        User user = user_map.get(name);
        user.setTime(outTime); 
        list.remove(user);
        queue.remove(user);
        updateWaitingTime();
    }

    public void addNextUser() {
        if (!queue.isEmpty()) {
            User nextUser = queue.poll();
            list.add(nextUser);
            user_map.put(nextUser.getName(), nextUser);
        }
    }

    private double getCurrentTime() {
        return 3.00;
    }

    public void updateWaitingTime() {
        double currentTime = getCurrentTime();
        for (User user : list) {
            double waitingTime = currentTime - user.getTime();
            waitingTimeMap.put(user.getName(), waitingTime);
        }
        for (User user : queue) {
            double waitingTime = currentTime - user.getTime();
            waitingTimeMap.put(user.getName(), waitingTime);
        }
    }

    public double addTime(double baseTime, int minutes) {
        return baseTime + (minutes / 60.0);
    }
}
