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

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEnrtyController {

    @Autowired
    JournalEntryService journalEntryService;

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


    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myENtry, @PathVariable String userName)
    {
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

    @DeleteMapping("id/{userName}/{myId}")
    public ResponseEntity<?>  deleteJournalEntryById(@PathVariable ObjectId myId, @PathVariable String userName)
    {

        journalEntryService.deleteById(myId,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT );
    }
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
