package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Service.JournalEntryService;
import net.engineeringdigest.journalApp.Service.UserService;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/XYX")
public class JournalEnrtyControllerV2 {

    @Autowired
    JournalEntryService journalEntryService;
    //METHOD INSIDE A CONTROLLER CLASS SHOULD BE PUBLIC SO THAT THEY CAN BE ACCESSED AND INVOKED BY THE SPRING FRAMEWORK OR EXTERNAL HTTP REQUESTS

    @Autowired
    private UserService userService;
    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName)
    {
        User user = userService.findByUserName(userName);
         List<JournalEntry>all = user.getJournalEntries() ;
        if(all!= null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Selecting "raw" and "JSON"in the body of a POST request in Postman indicates that the request body will contain
    //data in JSON format,allowing the server to parse and process the incoming data accurately. This ensures that the data is
    //transmitted and recived in a structured manner,following the JSON format conventions.


    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myENtry, @PathVariable String userName)
    {
        //RequestBody:It is Saying like that="Hey SPRING,please take the data from the request and turn it into a JAVA object that i can use in my code
        try
        {
            journalEntryService.saveEntry(myENtry,userName);
            return new ResponseEntity<>(myENtry, HttpStatus.CREATED);
        } catch (Exception e)
        {
             return new ResponseEntity<>(myENtry, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId)
    {
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent())
        {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

/*    @DeleteMapping("id/{myId}")
    public ResponseEntity<?>  deleteJournalEntryById(@PathVariable ObjectId myId)
    {
        journalEntryService.deleteById(myId, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT );
    }*/
/*
    @PutMapping("id/{id}")
    public ResponseEntity<?> UpdateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry)
    {
      JournalEntry old = journalEntryService.findById(id).orElse(null);
      if(old!=null)
      {
            old.setTitle(newEntry.getTitle()!=null&& !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getTitle()!=null&& !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            journalEntryService.saveEntry(old, user);
          return new ResponseEntity<>(HttpStatus.OK);
      }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }*/
}
