package ua.vinni.firstproject.springlibrary.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.vinni.firstproject.springlibrary.dao.interfaces.GenreDao;
import ua.vinni.firstproject.springlibrary.entities.Genre;

import java.util.List;

@Component
public class GenreDaoImpl implements GenreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Genre> getGenres() {
        return sessionFactory.getCurrentSession().createCriteria(Genre.class).list();
    }


}
