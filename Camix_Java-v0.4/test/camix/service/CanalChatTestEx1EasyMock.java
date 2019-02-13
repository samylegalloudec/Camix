package camix.service;


import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;

import static junit.framework.TestCase.fail;

@RunWith(EasyMockRunner.class)
public class CanalChatTestEx1EasyMock {
    private ClientChat clientChatMock;
    private CanalChat canalChatPartiel;

    @Before
    public void setUp(){
        this.clientChatMock = EasyMock.createMock(ClientChat.class);
        this.canalChatPartiel = EasyMock.partialMockBuilder(CanalChat.class).withConstructor(String.class).withArgs("Samy").addMockedMethod("estPresent").createMock();
    }


    @Test
    public void testAjouteClient_v1(){

        EasyMock.expect(this.clientChatMock.donneId()).andReturn("1").times(3);
        EasyMock.replay(this.clientChatMock);

        CanalChat canalChat = new CanalChat("Samy");

        canalChat.ajouteClient(this.clientChatMock);

        Assert.assertEquals(canalChat.donneNombreClients(), (Integer) 1);
        Assert.assertTrue(canalChat.estPresent(this.clientChatMock));
        EasyMock.verify(this.clientChatMock);

    }

    @Test
    public void testAjouteClientPresent_v1(){
        EasyMock.expect(this.clientChatMock.donneId()).andReturn("1").times(4);
        EasyMock.replay(this.clientChatMock);

        CanalChat canalChat = new CanalChat("Samy");

        canalChat.ajouteClient(this.clientChatMock);
        canalChat.ajouteClient(this.clientChatMock);

        Assert.assertEquals(canalChat.donneNombreClients(), (Integer) 1);
        Assert.assertTrue(canalChat.estPresent(this.clientChatMock));
        EasyMock.verify(this.clientChatMock);

    }

    @Test
    public void testAjouteClient_v2() throws NoSuchFieldException {
        Field attribut;
        EasyMock.expect(this.clientChatMock.donneId()).andReturn("1").times(2);
        EasyMock.replay(this.clientChatMock);

        CanalChat canalChat = new CanalChat("Samy");
        canalChat.ajouteClient(this.clientChatMock);

        String attributConcerne = "clients";

        try {
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);

            Assert.assertEquals(clients.size(), 1);
            Assert.assertTrue(clients.contains(clientChatMock));
            EasyMock.verify(this.clientChatMock);

        } catch (SecurityException e) {
            fail("Problème de sécurité sur la réflexion.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClientPresent_v2(){
        Field attribut;
        EasyMock.expect(this.clientChatMock.donneId()).andReturn("1").times(3);
        EasyMock.replay(this.clientChatMock);

        CanalChat canalChat = new CanalChat("Samy");
        canalChat.ajouteClient(this.clientChatMock);
        canalChat.ajouteClient(this.clientChatMock);

        String attributConcerne = "clients";

        try {
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);

            Assert.assertEquals(clients.size(), 1);
            Assert.assertTrue(clients.contains(clientChatMock));
            EasyMock.verify(this.clientChatMock);

        } catch (SecurityException e) {
            fail("Problème de sécurité sur la réflexion.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClient_v3(){
        Field attribut;
        EasyMock.expect(this.clientChatMock.donneId()).andReturn("1").times(2);
        EasyMock.replay(this.clientChatMock);

        CanalChat canalChat = new CanalChat("Samy");
        canalChat.ajouteClient(this.clientChatMock);
        String attributConcerne = "clients";

        try {
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);

            Assert.assertEquals(clients.size(), 1);
            Assert.assertTrue(clients.contains(this.clientChatMock));
            EasyMock.verify(this.clientChatMock);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClientPresent_v3(){
        Field attribut;
        EasyMock.expect(this.clientChatMock.donneId()).andReturn("1").times(2);
        EasyMock.replay(this.clientChatMock);

        CanalChat canalChat = new CanalChat("Samy");
        String attributConcerne = "clients";

        try {
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);
            clients.put(this.clientChatMock.donneId(), this.clientChatMock);

            canalChat.ajouteClient(this.clientChatMock);


            Assert.assertEquals(clients.size(), 1);
            Assert.assertTrue(clients.contains(this.clientChatMock));
            EasyMock.verify(this.clientChatMock);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClient_v4(){
        Field attribut;
        EasyMock.expect(this.clientChatMock.donneId()).andReturn("1").times(2);
        EasyMock.replay(this.clientChatMock);
        EasyMock.expect(this.canalChatPartiel.estPresent(this.clientChatMock)).andReturn(false);
        EasyMock.replay(this.canalChatPartiel);

        CanalChat canalChat = new CanalChat("Samy");
        canalChat.ajouteClient(this.clientChatMock);

        String attributConcerne = "clients";

        try{
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);

            Assert.assertEquals(clients.size(), 1);
            Assert.assertTrue(clients.contains(this.clientChatMock));
            EasyMock.verify(this.clientChatMock);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClientPresent_v4(){
        Field attribut;
        EasyMock.expect(this.clientChatMock.donneId()).andReturn("1").times(2);
        EasyMock.replay(this.clientChatMock);
        EasyMock.expect(this.canalChatPartiel.estPresent(this.clientChatMock)).andReturn(false);
        EasyMock.replay(this.canalChatPartiel);

        CanalChat canalChat = new CanalChat("Samy");

        String attributConcerne = "clients";

        try{
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);
            clients.put(this.clientChatMock.donneId(), this.clientChatMock);

            canalChat.ajouteClient(this.clientChatMock);

            Assert.assertEquals(clients.size(), 1);
            Assert.assertTrue(clients.contains(this.clientChatMock));
            EasyMock.verify(this.clientChatMock);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }




}
