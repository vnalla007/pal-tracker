package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry any);

    public TimeEntry find(Long timeEntryId);

    public List list();

    public void delete(Long timeEntryId);

    public TimeEntry update(Long eq, TimeEntry any);
}
