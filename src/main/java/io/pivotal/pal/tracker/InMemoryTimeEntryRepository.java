package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class InMemoryTimeEntryRepository implements TimeEntryRepository  {
    private TimeEntry timeEntry  = new TimeEntry();
    private HashMap<Long,TimeEntry> timeEntryList = new HashMap();
    private long timeEntryId =1;

    public TimeEntry create(TimeEntry any){
         System.out.println( "timeEntryId in create "+timeEntryId );
        this.timeEntry=any;
        if(any.getId() == 0){
            timeEntry.setId(timeEntryId);
        }
        timeEntryList.put(timeEntryId,timeEntry);
        timeEntryId++;

        return timeEntry;
    }
    public TimeEntry find(Long timeEntryId){
        System.out.println( "timeEntryId in find "+timeEntryId );
        return timeEntryList.get(timeEntryId);
               //return timeEntry;
    }

    public List list(){

            return new ArrayList<TimeEntry>(timeEntryList.values());
    }

    public void delete(Long timeEntryId){

        timeEntryList.remove(timeEntryId);

    }

    public TimeEntry update(Long eq, TimeEntry any){
        System.out.println("update in TimeEntry and id is  "+eq);
        System.out.println("TimeEntry any.getProjectId()  "+any.getProjectId() +"  any.getUserId() = "+ any.getUserId() + " any.getDate() = "+any.getDate() + " any.getHours() = " +any.getHours() );

        if(timeEntryList.get(eq)== null){
            return null;
        }else{
            System.out.println(" getting any.getId() ");
            System.out.println(" any.getId() " + any.getId());
            this.timeEntry=any;
            System.out.println(" Before  any.getId() == 0 " + any.getId());
            if(any.getId() == 0 ){
                System.out.println(" In any.getId() == 0 ");
                timeEntry.setId(eq);
            }
            System.out.println(" Before replace");
            timeEntryList.replace(eq,timeEntry);
            System.out.println(" After replace");
            return timeEntry;
        }
    }

}
