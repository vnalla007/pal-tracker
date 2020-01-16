package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry any);

    public TimeEntry find(long timeEntryId);

    public List list();

    public void delete(long timeEntryId);

    public TimeEntry update(long eq, TimeEntry any);
}
