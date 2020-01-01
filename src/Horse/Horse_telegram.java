/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Horse;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author mohsen
 */
public class Horse_telegram {

    public static Map<String, String> cookies;
    static int j = 0;
    static int jj = 0;
    static int index = 0;
    public static boolean flag = false;
    public static boolean spliter = false;
    static String caption;
    static String image;
    static String tag;
    static String s;
    public static String mahmoole ;

    public Horse_telegram(String text) throws IOException {
        mahmoole = text;
        this.main(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        

        Connection.Response response = Jsoup.connect("https://seller.digikala.com/account/login/")
                .method(Connection.Method.POST)
                .data("login[email]", "nevermore.inviss@gmail.com")
                .data("login[password]", "697175Mms$#")
                .data("returnUrl", "0")
                .execute();
        cookies = response.cookies();

        for (int i = 0; i < 100; i++) {
            Document data = Jsoup.connect("https://seller.digikala.com/package/sellerpackagedetail/?packageId="+mahmoole)
                    .cookies(cookies)
                    .data("items", "100")
                    .data("page", String.valueOf(i))
                    .data("sortColumn", "product_id")
                    .data("sortOrder", "desc")
                    .post();
            Elements els = data.getElementsByClass("c-ui-table__row c-ui-table__row--collapsable c-ui-table__row--body");
            if (els.size() < 2) {
//                    System.out.println("breaked");
                break;
            }
            for (Element el : els) {
                jj++;
               try {
//                    System.out.println("hereeeee     " + el.select(".c-ui-table__cell").get(3).text());
                    if (spliter == false) {
                        tag = el.select(".c-ui-table__cell").get(3).text();
//                        System.out.println("im splitter      " + tag + "      " + el.select(".c-ui-table__cell").get(3).text());
                        spliter = true;
                    }
                    if ((tag.contains(el.select(".c-ui-table__cell").get(3).text())) && flag == true) {
//                        System.out.println("in seond step braek                  " + tag + "        " + el.select(".c-ui-table__cell").get(3));
//                        System.out.println(tag);
                        break;
                    }
                    
                    if ((tag.contains(el.select(".c-ui-table__cell").get(3).text())) && flag == false) {
//                        System.out.println("in if first step                     " + tag + "       " + el.select(".c-ui-table__cell").get(3).text());
//                        System.out.println(tag);
                        flag = true;
                    }

//                    System.out.print(el.select(".table-word-wrap").get(0).text()+"   ");
//                    System.out.print(el.select(".table-word-wrap").get(5).text()+"   ");
//                    System.out.println(el.select(".table-word-wrap").get(7).text());
                    s = el.select(".c-ui-table__cell > img").toString();
                    String count = convertToEnglishDigits(el.select(".c-ui-table__cell").get(5).text());
                  
                    caption = el.select(".c-ui-table__cell").get(1).text();
                    caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                    caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                    caption = caption.replace("\\|", "");
                    caption = caption.replace("|", "");
//                    System.out.println(caption);
                    s = s.substring(10, s.indexOf(".jpg") + 4 );
//                    new TelegramGroupSender(caption, s , index);
                    index++;
                    new TelegramGroupSenderHorse(caption, s ,index ,count);
//                    System.out.println(s);
                } catch (Exception e) {
                    continue;
                }
//                      String s = el.select(".table-word-wrap > img").toString();
//                      s=s.substring(10, 77);
////                            System.out.println(el.select(".table-word-wrap > img"));
//                        System.out.println(s);
//                            System.out.print("اسم محصول   :  ");
//                            System.out.println(el.select(".table-word-wrap").get(5).text());
//                            System.out.println(el.select(".table-word-wrap > img").text());

//                            TelegramGroupSender telegram = new TelegramGroupSender(el.select(".table-word-wrap").get(5).text(),chat_id);
//                            System.out.print("تعداد محصول   :  ");
//                            System.out.println(el.select(".table-word-wrap").get(7).text());
//                            System.out.println("      "+el.select(".table-word-wrap").get(5).text());
//                        System.out.print(el.select(".table-row-number-fix > span").text());
//                        System.out.print("   id =  " + Integer.parseInt(el.select(".product_variant_id > span").text()));
//                        System.out.println("  o = "+ o);
            }

        }

//        PostData postdata = new PostData(cookies);
//        CreateLinks links = new CreateLinks(cookies);
//        urlss=(Set<String>) links.getUrls();
    }

    public static String convertToEnglishDigits(String value) {
        String newValue = value.replaceAll("۱", "1").replaceAll("۲", "2").replaceAll("۳", "3").replaceAll("۴", "4").replaceAll("۵", "5")
                .replaceAll("۶", "6").replaceAll("۷", "7").replaceAll("۸", "8").replaceAll("۹", "9").replaceAll("۰", "0");
        return newValue;
    }

}
