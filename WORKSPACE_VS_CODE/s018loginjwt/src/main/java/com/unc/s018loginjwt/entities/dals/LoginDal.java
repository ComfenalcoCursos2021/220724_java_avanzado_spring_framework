package com.unc.s018loginjwt.entities.dals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unc.s018loginjwt.entities.LoginEntity;
import com.unc.s018loginjwt.repositories.ILoginRepository;

@Service
public class LoginDal {

    @Autowired
    private ILoginRepository repo;
    
    public List<LoginEntity> findAll() {
        return this.repo.findAll();
    }
    
    public LoginEntity findById(long id) {
        return this.repo.findById(id).get();
    }

    public LoginEntity save(LoginEntity entity) {
        return this.repo.save(entity);        
    }

    public LoginEntity update(LoginEntity entity) {
        return this.repo.findById(entity.getId())
            .map(x -> {
                x.setPassword(entity.getPassword());
                x.setUser(entity.getUser());
                return this.repo.save(x);
            }).get();
    }

    public void delete(long id) {
        if(this.repo.existsById(id)){
            this.repo.deleteById(id);
        }
    }


}
