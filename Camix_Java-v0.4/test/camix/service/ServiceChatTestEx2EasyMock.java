package camix.service;

import camix.communication.ProtocoleChat;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(EasyMockRunner.class)
public class ServiceChatTestEx2EasyMock {
    private ClientChat clientChatMock;
    private String surnom;

    @Before
    public void setUp(){
        this.clientChatMock = EasyMock.createMock(ClientChat.class);
    }

    @Test
    public void testInformeDepartClient() throws IOException {
        ServiceChat serviceChat = new ServiceChat("canal");


        EasyMock.expect(this.clientChatMock.donneSurnom()).andReturn(surnom);
        EasyMock.replay(this.clientChatMock);

        String message = String.format(ProtocoleChat.MESSAGE_DEPART_CHAT, surnom);

        this.clientChatMock.envoieMessage(message);

        serviceChat.informeDepartClient(this.clientChatMock);

        EasyMock.verify(this.clientChatMock);
    }
}
