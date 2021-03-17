package com.uniyaz.core.service;

import com.uniyaz.core.dao.SoruDao;
import com.uniyaz.core.domain.Soru;

import java.util.List;

public class SoruService {
    SoruDao soruDao = new SoruDao();

    public void saveSoru(Soru soru){soruDao.saveSoru(soru);}
    public List<Soru> findAllHql() {
        return soruDao.findAllHql();
    }
}
