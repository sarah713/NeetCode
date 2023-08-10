package Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetings {
    public static int maxMeetings(int start[], int end[], int n) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.end - m2.end;
            }
        });

        int meets = 1;
        int e = meetings.get(0).end;
        for (int i = 1; i < n; i++) {
            int s = meetings.get(i).start;
            if (s > e) {
                meets++;
                e = meetings.get(i).end;
            }
        }
        return meets;
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}