package camix.service;

import org.easymock.EasyMockRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Hashtable;

public class CanalChatTestEx1Mockito {

    private ClientChat clientChatMock;

    @Before
    public void setUp(){
        this.clientChatMock = Mockito.mock(ClientChat.class);
    }


    @Test
    public void testAjouteClient_v1(){
        Mockito.when(this.clientChatMock.donneId()).thenReturn("1");

        CanalChat canalChat = new CanalChat("Samy");

        canalChat.ajouteClient(this.clientChatMock);

        Assert.assertTrue(canalChat.estPresent(this.clientChatMock));
        Assert.assertEquals(canalChat.donneNombreClients(), (Integer) 1);

        Mockito.verify(this.clientChatMock, Mockito.times(3)).donneId();
    }

    @Test
    public void testAjouteClientPresent_v1(){
        Mockito.when(this.clientChatMock.donneId()).thenReturn("1");

        CanalChat canalChat = new CanalChat("Samy");

        canalChat.ajouteClient(this.clientChatMock);
        canalChat.ajouteClient(this.clientChatMock);

        Assert.assertTrue(canalChat.estPresent(this.clientChatMock));
        Assert.assertEquals(canalChat.donneNombreClients(), (Integer) 1);

        Mockito.verify(this.clientChatMock, Mockito.times(4)).donneId();
    }

    @Test
    public void testAjouteClient_v2(){
        Field attribut;

        Mockito.when(this.clientChatMock.donneId()).thenReturn("1");
        CanalChat canalChat = new CanalChat("Samy");

        canalChat.ajouteClient(this.clientChatMock);
        String attributConcerne = "clients";

        try{
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);

            Assert.assertTrue(canalChat.estPresent(this.clientChatMock));
            Assert.assertTrue(clients.contains(this.clientChatMock));
            Assert.assertEquals(clients.size(), 1);
            Mockito.verify(this.clientChatMock, Mockito.times(3)).donneId();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClientPresent_v2(){
        Field attribut;

        Mockito.when(this.clientChatMock.donneId()).thenReturn("1");
        CanalChat canalChat = new CanalChat("Samy");

        canalChat.ajouteClient(this.clientChatMock);
        canalChat.ajouteClient(this.clientChatMock);

        String attributConcerne = "clients";

        try{
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);

            Assert.assertTrue(canalChat.estPresent(this.clientChatMock));
            Assert.assertTrue(clients.contains(this.clientChatMock));
            Assert.assertEquals(clients.size(), 1);
            Mockito.verify(this.clientChatMock, Mockito.times(4)).donneId();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClient_v3(){
        Field attribut;

        Mockito.when(this.clientChatMock.donneId()).thenReturn("1");
        CanalChat canalChat = new CanalChat("Samy");
        canalChat.ajouteClient(this.clientChatMock);
        String attributConcerne = "clients";


        try{
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);
            //clients.put(this.clientChatMock.donneId(), this.clientChatMock);

            Assert.assertTrue(canalChat.estPresent(this.clientChatMock));
            Assert.assertTrue(clients.contains(this.clientChatMock));
            Assert.assertEquals(clients.size(), 1);
            Mockito.verify(this.clientChatMock, Mockito.times(3)).donneId();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClientPresent_v3(){
        Field attribut;

        Mockito.when(this.clientChatMock.donneId()).thenReturn("1");
        CanalChat canalChat = new CanalChat("Samy");

        String attributConcerne = "clients";

        try{
            attribut = CanalChat.class.getDeclaredField(attributConcerne);
            attribut.setAccessible(true);
            Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);
            clients.put(this.clientChatMock.donneId(), this.clientChatMock);

            canalChat.ajouteClient(this.clientChatMock);

            Assert.assertTrue(canalChat.estPresent(this.clientChatMock));
            Assert.assertTrue(clients.contains(this.clientChatMock));
            Assert.assertEquals(clients.size(), 1);
            Mockito.verify(this.clientChatMock, Mockito.times(3)).donneId();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouteClient_v4(){

    }



}
