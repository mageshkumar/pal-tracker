package io.pivotal.pal.tracker.dao;

import io.pivotal.pal.tracker.bean.TimeEntry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> timeEntryHashMap = new HashMap<Long, TimeEntry>();
    private long counter = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        if (timeEntry.getId() == null || timeEntry.getId() == 0) {
            timeEntry.setId(counter);
        }
        timeEntryHashMap.put(timeEntry.getId(), timeEntry);
        counter = counter + 1;
        return timeEntry;
    }

    public TimeEntry find(long timeEntryId) {
        return timeEntryHashMap.get(timeEntryId);
    }

    public List<TimeEntry> list() {
        List<TimeEntry> timeEntryLis = new ArrayList<TimeEntry>();
        for (Map.Entry<Long, TimeEntry> it : timeEntryHashMap.entrySet()) {
            timeEntryLis.add(it.getValue());
        }
        return timeEntryLis;
    }

    public TimeEntry update(long eq, TimeEntry timeEntry) {
        if (timeEntryHashMap.containsKey(eq)) {
            timeEntry.setId(eq);
            timeEntryHashMap.replace(eq, timeEntry);
            return timeEntryHashMap.get(eq);
        } else {
            return null;
        }

    }

    public TimeEntry delete(long timeEntryId) {
        if (timeEntryHashMap.containsKey(timeEntryId)) {
            TimeEntry timeEntry = timeEntryHashMap.get(timeEntryId);
            timeEntryHashMap.remove(timeEntryId);
            return timeEntry;
        } else {
            return null;
        }

    }
}
