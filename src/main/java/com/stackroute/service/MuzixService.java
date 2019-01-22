/*
methods defined for different operations..
*/

package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.MuzixAlreadyExistsException;

import java.util.List;

public interface MuzixService {

    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistsException;
    public List<Muzix> getAllMuzixs();
    public Muzix updateMuzix(Muzix muzix);
    public Muzix removeMuzix(int trackId);

}
