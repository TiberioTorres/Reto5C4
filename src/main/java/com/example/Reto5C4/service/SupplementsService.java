/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto5C4.service;

import com.example.Reto5C4.model.Supplements;
import com.example.Reto5C4.repository.SupplementsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeremy
 */
@Service
public class SupplementsService {
    
    @Autowired
    private SupplementsRepository supplementsRepository;

    public List<Supplements> getAll() {
        return supplementsRepository.getAll();
    }

   public Optional<Supplements> getSupplement(Integer id) {
        return supplementsRepository.getSupplement(id);
    }

    public Supplements save(Supplements accesory) {
        if (accesory.getId() == null) {
            return accesory;
        } else {
            return supplementsRepository.create(accesory);
        }
    }

    public Supplements update(Supplements accesory) {

        if (accesory.getId() != null) {
            Optional<Supplements> accesoryDb = supplementsRepository.getSupplement(accesory.getId());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                if(accesory.getProcesor()!= null){
                    accesoryDb.get().setProcesor(accesory.getProcesor());
                }
                if(accesory.getOs() != null){
                    accesoryDb.get().setOs(accesory.getOs());
                }
                if(accesory.getMemory() != null){
                    accesoryDb.get().setMemory(accesory.getMemory());
                }
                if(accesory.getHardDrive() != null){
                    accesoryDb.get().setHardDrive(accesory.getHardDrive());
                }
                
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                supplementsRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getSupplement(id).map(accesory -> {
            supplementsRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List <Supplements> findByPrice (double price){
        return  supplementsRepository.findByPrice(price);
    }
    
    public List <Supplements> findByDescription (String description){
        List <Supplements> suplementos = supplementsRepository.getAll();
        ArrayList<Supplements> suplementos2 = new ArrayList();
        for(Supplements suplemento: suplementos){
            String descripcion = suplemento.getDescription();
            int j = 0;
            for(int i = 0; i < descripcion.length(); i++){
                char caracter = descripcion.charAt(i);
               
                if(caracter==description.charAt(j)){
                    
                }
            }
            
        }
        return suplementos2;
    }

}
