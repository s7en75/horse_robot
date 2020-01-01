/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Horse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TelegramGroupSenderHorse {
    

    static String token = "xoxb-718932286434-745113344820-GKkmucTWLTcDpIsO43dbZXmf";
//    static String chat_id = "change-price";
    static String channel = "horse_slack";
    static String text = "";
//    static String chat_id = "@gpchannelgroup";
    public static boolean flag = false;

    /**
     * Entry Point
     */
    public TelegramGroupSenderHorse(String message, String image, int index , String count) {
        
 
        String tempImage = "\"" + image + "\"";
        
        String payload = "[{" +
                "\"title\":"+count+ ", " +
                "\"image_url\":"+tempImage+ ", " +
                "}]";
        
//        while (flag == false) {
            try {
//                System.out.println("Message"+"sefaresh");
//                System.out.println("image"+image);
//                System.out.println("index"+index);
                System.out.println(tempImage);
                Document response= Jsoup.connect("https://slack.com/api/chat.postMessage?token=" + token)
                        .data("attachments",payload)
                        .data("channel",channel)
                        .data("text",message)
                        .post();
                System.out.println("doc is " +response);
                
//                flag = true;
            } catch (MalformedURLException e) {
                System.out.println("there is problem");
//                flag = false;
//            System.out.println(message);
            } catch (IOException e) {
                System.out.println("IO Exception");
//                flag = false;
//            System.out.println(message);
            }
//        }
//     
    }
}
