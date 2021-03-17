package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketSoruDao;
import com.uniyaz.core.domain.AnketSoru;


import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class AnketSoruService {
    private AnketSoru anketSoruList;
    AnketSoruDao anketSoruDao = new AnketSoruDao();


    public void saveAnketSoru(AnketSoru anketSoru) {
        anketSoruDao.saveAnketSoru(anketSoru);
    }

    public void saveAnketSoru(List<AnketSoru> AnketSoruList) { anketSoruDao.saveAnketSoru(anketSoruList);
    }

    public List<AnketSoru> findAllHql() {
        return anketSoruDao.findAllHql();
    }

    public List<AnketSoru> findAllByAnketId(Long anketId) { return anketSoruDao.findAllByAnketId(anketId);
    }
}