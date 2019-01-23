package com.stackroute.controller;

        import com.stackroute.domain.Muzix;
        import com.stackroute.exceptions.MuzixAlreadyExistsException;
        import com.stackroute.exceptions.MuzixTrackNotFoundException;
        import com.stackroute.service.MuzixService;
        import io.swagger.annotations.Api;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class MuzixController {

    //variable of type for interface
    MuzixService muzixService;


    //constructor

    @Autowired
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }


    //saving the files in db

    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) {
        ResponseEntity responseEntity;
        try {
            muzixService.saveMuzix(muzix);
            responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        } catch (MuzixAlreadyExistsException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }


    //getting all the list from db

    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzixs() {
        return new ResponseEntity<List<Muzix>>(muzixService.getAllMuzixs(), HttpStatus.OK);
    }


    //update the list

    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) {
        ResponseEntity responseEntity;
        try {
            muzixService.updateMuzix(muzix);
            responseEntity = new ResponseEntity<String>("Successfully Updated", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }


    //deleting by ID

    @DeleteMapping("muzix")
    public ResponseEntity<?> removeMuzix(@RequestParam int trackId) {
        ResponseEntity responseEntity;
        try {
            muzixService.removeMuzix(trackId);
            responseEntity = new ResponseEntity<String>("Successfully Deleted", HttpStatus.CREATED);
        } catch (MuzixTrackNotFoundException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    //gettrackName method
    @GetMapping("muzix1/{trackName}")
    public ResponseEntity<?> gettrackName(@PathVariable String trackName) {
        return new ResponseEntity<List<Muzix>>(muzixService.trackByName(trackName),HttpStatus.OK);
    }

    }

