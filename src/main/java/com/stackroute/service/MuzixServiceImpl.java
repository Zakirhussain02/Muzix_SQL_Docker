
package com.stackroute.service;

        import com.stackroute.domain.Muzix;
        import com.stackroute.exceptions.MuzixAlreadyExistsException;
        import com.stackroute.exceptions.MuzixTrackNotFoundException;
        import com.stackroute.repository.MuzixRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class MuzixServiceImpl implements MuzixService
{

    MuzixRepository muzixRepository;
    int a=9;

    //constructor

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){
        this.muzixRepository=muzixRepository;
    }

    //saving user by ID

    @Override
    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistsException {

        if(muzixRepository.existsById(muzix.getTrackId())){
            throw new MuzixAlreadyExistsException("user already exists");
        }

        Muzix savedUser = muzixRepository.save(muzix);

        if(savedUser == null)
            throw new MuzixAlreadyExistsException("user already exists");

        return savedUser;
    }


    //getting all users

    @Override
    public List<Muzix> getAllMuzixs() {
        return muzixRepository.findAll();
    }

    //updating users

    @Override
    public Muzix updateMuzix(Muzix muzix) {

        return muzixRepository.save(muzix);
    }

    // Deleting the track by ID
    @Override
    public Muzix removeMuzix(int trackId) throws MuzixTrackNotFoundException{
        if (!muzixRepository.existsById(trackId)) {
            throw new MuzixTrackNotFoundException("Sorry!The Track is Empty");
        }
            Muzix deleteMuzix = muzixRepository.getOne(trackId);
            muzixRepository.delete(deleteMuzix);

            return deleteMuzix;
        }
        @Override
    public List<Muzix> trackByName(String trackName) {
        return muzixRepository.findBytrackName(trackName);
    }
}
