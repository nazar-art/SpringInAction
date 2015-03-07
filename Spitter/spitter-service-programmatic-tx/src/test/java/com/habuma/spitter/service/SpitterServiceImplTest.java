package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.SpitterDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import static org.easymock.EasyMock.*;

public class SpitterServiceImplTest {
    private SpitterServiceImpl spitterService;
    private SpitterDao spitterDao;
    private Spitter newSpitter;
    private Spitter oldSpitter;

    @Before
    public void setup() {
        PlatformTransactionManager txMgr = new FakeTransactionManager();

        TransactionTemplate txTemplate = new TransactionTemplate(txMgr);

        newSpitter = new Spitter();
        newSpitter.setUsername("testuser");
        newSpitter.setPassword("password");
        newSpitter.setFullName("Michael McTest");

        oldSpitter = new Spitter();
        oldSpitter.setId(12345L);
        oldSpitter.setUsername("olduser");
        oldSpitter.setPassword("letmein");
        oldSpitter.setFullName("Bob O'Test");

        spitterDao = createNiceMock(SpitterDao.class);
        spitterDao.saveSpitter(oldSpitter);
        spitterDao.addSpitter(newSpitter);
        replay(spitterDao);

        spitterService = new SpitterServiceImpl();
        spitterService.setSpitterDao(spitterDao);
        spitterService.setTransactionTemplate(txTemplate);
    }

    @Test
    public void shouldAddSpitter() {
        spitterService.saveSpitter(newSpitter);
        spitterService.saveSpitter(oldSpitter);
        verify(spitterDao);
    }
}
