package com.uniyaz.core.service;

import com.uniyaz.core.dao.KisiDao;

import com.uniyaz.core.domain.Kisi;

import java.util.List;

public class KisiService {
    KisiDao kisiDao = new KisiDao();

    public void saveKisi (Kisi kisi){kisiDao.saveKisi(kisi);}

    public List<Kisi> findAllHql() {
        return KisiDao.findAllHql();
    }

}
