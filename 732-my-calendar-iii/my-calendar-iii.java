class MyCalendarThree {

    private TreeMap<Integer, Integer> timeline;

    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        // mark start and end
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        int ongoing = 0;
        int maxBooking = 0;

        // sweep line
        for (int change : timeline.values()) {
            ongoing += change;
            maxBooking = Math.max(maxBooking, ongoing);
        }

        return maxBooking;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */