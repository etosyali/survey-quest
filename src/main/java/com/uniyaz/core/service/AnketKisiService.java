package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketKisiDao;
import com.uniyaz.core.domain.AnketKisi;


import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class AnketKisiService {
    private AnketKisi anketKisiList;
    AnketKisiDao anketKisiDao = new AnketKisiDao();


    public void saveAnketKisi(AnketKisi anketKisi) {
        anketKisiDao.saveAnketKisi(anketKisi);
    }

    public void saveAnketKisi(List<AnketKisi> AnketKisiList) { anketKisiDao.saveAnketKisi(anketKisiList);
    }

    public List<AnketKisi> findAllHql() {
        return anketKisiDao.findAllHql();
    }

    //public List<AnketKisi> findAllByAnketId(Long anketId) { return anketKisiDao.findAllByAnketId(anketId);}
    public List<AnketKisi> findAllByKisiId(Long kisiId) { return anketKisiDao.findAllByKisiId(kisiId);}
}