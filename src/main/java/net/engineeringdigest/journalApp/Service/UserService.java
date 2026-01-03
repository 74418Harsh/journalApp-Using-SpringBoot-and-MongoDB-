package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User journalEntry)
    {
        userRepository.save(journalEntry);
    }

    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id)
    {
        return userRepository.findById(id);
    }

    public Boolean deleteById(ObjectId id)
    {
        userRepository.deleteById(id);
        return true;
    }

    public User findByUserName(String userName)
    {
        return userRepository.findByuserName(userName);
    }

}
//controller -> Service -> Repository


//If a class is annotated with @Component, then Spring automatically creates its object (bean) —
// and you can use @Autowired to inject that object wherever you need it.
//@Component → tells Spring to create an object (bean).
//@Autowired → tells Spring to give you that object wherever you need it.
//✅ In short:
//@Component → create object
//@Autowired → use that object
