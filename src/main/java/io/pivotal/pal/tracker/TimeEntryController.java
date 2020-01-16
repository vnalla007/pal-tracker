package io.pivotal.pal.tracker;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;// = new InMemoryTimeEntryRepository();

    private ResponseEntity  responseEntity;


    public TimeEntryController(TimeEntryRepository timeEntryRepository){
    this.timeEntryRepository = timeEntryRepository;

    }

    @PostMapping("/time-entries")
    @ResponseBody
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        System.out.println( " create of TimeEntryRepository");

        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
        //return new ResponseEntity<String>(""+timeEntryToCreate.)+""+timeEntryToCreate.userId+"",  HttpStatus.CREATED);
        //return new ResponseEntity<String>("Hello World",  HttpStatus.CREATED);

       // return ResponseEntity.ok(timeEntryToCreate);
        System.out.println( " listing timeEntryRepository in TimeController "+timeEntryRepository.list());
        String body = ""+timeEntry.getId()+timeEntry.getProjectId()+timeEntry.getUserId()+timeEntry.getDate()+timeEntry.getHours();
        System.out.println("timeEntry.getId() "+timeEntry.getId());
        System.out.println(" timeEntry.getProjectId() "+timeEntry.getProjectId());
        System.out.println(" timeEntry.getUserId() "+timeEntry.getUserId());
        System.out.println(" timeEntry.getDate() "+timeEntry.getDate());
        System.out.println(" timeEntry.getHours() "+timeEntry.getHours());


        System.out.println(body);
        return new ResponseEntity(timeEntry, HttpStatus.CREATED);

    }


    @ResponseBody
    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        System.out.println( "timeEntryId "+timeEntryId);

        TimeEntry timeEntryToCreate = timeEntryRepository.find(timeEntryId);

        if(timeEntryToCreate ==null){
            return new ResponseEntity(timeEntryToCreate, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity(timeEntryToCreate, HttpStatus.OK);
        }

    }

    @ResponseBody
    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable("id") long timeEntryId) {

        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity("", HttpStatus.NO_CONTENT);
    }

    @ResponseBody
    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {

         return new ResponseEntity(timeEntryRepository.list(), HttpStatus.OK);

    }

    @ResponseBody
    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable("id") long timeEntryId, HttpEntity<TimeEntry> httpEntity) {
        System.out.println( " In update of TimeEntryController PutMapping "+httpEntity.getBody());
        System.out.println( " timeEntryId "+ timeEntryId);
        TimeEntry expected = httpEntity.getBody();
        ResponseEntity responseEntity = update(timeEntryId,expected);

        return responseEntity;
    }


    public ResponseEntity update( long timeEntryId,  TimeEntry expected) {
        System.out.println( " In update of TimeEntryController ");
        TimeEntry timeEntry = timeEntryRepository.update(timeEntryId,expected);

        if(timeEntry== null){

             return new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);


        }else{

            return new ResponseEntity(timeEntry, HttpStatus.OK);

        }
    }
}
