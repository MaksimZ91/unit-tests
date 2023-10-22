package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void messageServiceTest(){
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);
        messageService.sendMessage("Hello", "Test");
        verify(messageService, times(1)).sendMessage("Hello", "Test");
    }
}