package dao;

import org.springframework.stereotype.Component;
@component("dao")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        System.out.println("Version Base de données");
        return Math.random()*5897;
    }
}
