package app.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MailAdapterTest {

    @Test
    void constructorArgs(){
        MailAdapter mailAdapter = null;

        boolean result = false;


        try{
            mailAdapter = new MailAdapter(null,null);
            result = false;
        } catch(IllegalArgumentException e) {
            result = true;
        }
        assertTrue(result);

        try{
            mailAdapter = new MailAdapter(null,"test");
            result = false;
        } catch(IllegalArgumentException e) {
            result = true;
        }
        assertTrue(result);

        try{
            mailAdapter = new MailAdapter("test",null);
            result = false;
        } catch(IllegalArgumentException e) {
            result = true;
        }
        assertTrue(result);

        try{
            mailAdapter = new MailAdapter("test","");
            result = false;
        } catch(IllegalArgumentException e) {
            result = true;
        }
        assertTrue(result);

        try{
            mailAdapter = new MailAdapter("","");
            result = false;
        } catch(IllegalArgumentException e) {
            result = true;
        }
        assertTrue(result);

        try{
            mailAdapter = new MailAdapter("","test");
            result = false;
        } catch(IllegalArgumentException e) {
            result = true;
        }
        assertTrue(result);


        try{
            mailAdapter = new MailAdapter("test", "test");
            result = false;
        } catch(IllegalArgumentException e) {
            result = true;
        }
        assertFalse(result);

    }

    @Test
    void sendmsg(){
        MailAdapter mailAdapter = null;

        boolean result = false;

        //this test will only run if the constructor has valid parameters
        //and if the local machine running this code is connected to the DEI Vpn

        mailAdapter = new MailAdapter("*", "*");

        assertFalse(mailAdapter.sendMessage(null,null,null));
        assertFalse(mailAdapter.sendMessage(null,"foo",null));
        assertFalse(mailAdapter.sendMessage(null,null,"foo"));
        assertFalse(mailAdapter.sendMessage("","",""));
        assertFalse(mailAdapter.sendMessage("foo","",""));
        assertFalse(mailAdapter.sendMessage("","foo",""));
        assertFalse(mailAdapter.sendMessage("","","foo"));

        //this will only return true if the sender is the same as the receiver
        //and if subject is "test"
        //change the to: "*" to a valid user
        assertTrue(mailAdapter.sendMessage("*","Hello World!","Hello World!"));

        assertFalse(mailAdapter.sendMessage("test","test",""));
        assertFalse(mailAdapter.sendMessage("test","asd", null));
    }
}
