package com.tzegos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) 
public class JUnitTestWithMockFramework {
    
    @Mock
    Network networkMock;

    @Mock
    MessageService messageService;
       
    @Test
    public void testNetwork()  {
        assertNotNull(networkMock);
        when(networkMock.isAvailable()).thenReturn(true); 
        messageService  = new MessageService(networkMock);   
        when(messageService.checkConnectivity()).thenReturn(true); 
        boolean check = messageService.sendMessage("192.168.1.11", "foo");
        assertTrue(check);
    }
    
}
